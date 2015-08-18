/* This software is published under the terms of the OpenSymphony Software
 * License version 1.1, of which a copy has been included with this
 * distribution in the LICENSE.txt file. */
package com.vh.locker.filter;

import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.Factory;
import com.opensymphony.module.sitemesh.Page;
import com.opensymphony.module.sitemesh.RequestConstants;
import com.opensymphony.module.sitemesh.filter.PageResponseWrapper;
import com.opensymphony.module.sitemesh.util.Container;
import com.vh.locker.base.TokenProcessor;
import com.vh.locker.util.Constants_Scope;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Main SiteMesh filter for applying Decorators to entire Pages.
 *
 * @author <a href="joe@truemesh.com">Joe Walnes</a>
 * @author <a href="scott@atlassian.com">Scott Farquhar</a>
 * @version $Revision: 1.12 $
 */
public class PageFilter implements Filter, RequestConstants {
    private FilterConfig filterConfig = null;
    private Factory factory = null;
    private static Logger log = Logger.getLogger(PageFilter.class);
    private final boolean IS_DEBUG = log.isDebugEnabled();
    
    /**
     * Constants for the allowed extensions for last page in session.
     */
    private static final String INCLUDED_EXTENSIONS = ".do,.bg,.none,.jsp";
    private static final String EXCLUDED_PAGES = "/index.jsp,/ssodetect.jsp,/outside/SelectLocale.do";
    private static HashSet LAST_PAGE_INCLUDED_EXTENSIONS = new HashSet();
	private static HashSet LAST_PAGE_EXCLUDED_PAGES = new HashSet();
    
    /**
     * Initializing the LAST_PAGE_EXTENSION hash set.
     */
    static {
      StringTokenizer e = new StringTokenizer(INCLUDED_EXTENSIONS, ",");
	  StringTokenizer p = new StringTokenizer(EXCLUDED_PAGES, ",");
      while(e.hasMoreElements()) LAST_PAGE_INCLUDED_EXTENSIONS.add(e.nextToken());
	  while(p.hasMoreElements()) LAST_PAGE_EXCLUDED_PAGES.add(p.nextToken());
    }
    
    
    /**
     * Sets the last page into session under name Constants.LASTPAGE_KEY.
     * 
     * @author Peter.Szocs
     * @since 3/2/05
     */
    private void setLastPage(HttpServletRequest request) {
      
      String lastPage = request.getServletPath();
      String token = TokenProcessor.getRequestToken(request);
      //log.debug("lastPage="+lastPage);
      //log.debug("token="+token);      
      
      int i = lastPage.indexOf(".");
      if(i>0) { // last page has extension
        String ext = lastPage.substring(i);
        if((LAST_PAGE_INCLUDED_EXTENSIONS.contains(ext)) && (!LAST_PAGE_EXCLUDED_PAGES.contains(lastPage)) && (token==null)) {
          //lastPage = lastPage.substring(0, i)+".do";
          request.getSession().setAttribute(Constants_Scope.LASTPAGE_KEY, lastPage);
          if(IS_DEBUG) log.debug("'"+lastPage+"' saved into session");
        } 
      } else { // no extension
        if(IS_DEBUG) log.debug("lastPage='"+lastPage+"' has no extension: NOT saved into session");
      }
      
    }
    
    /**
     * Main method of the Filter.
     *
     * <p>Checks if the Filter has been applied this request. If not, parses the page
     * and applies {@link com.opensymphony.module.sitemesh.Decorator} (if found).
     */
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) rq;

        if (rq.getAttribute(FILTER_APPLIED) != null || factory.isPathExcluded(extractRequestPath(request))) {
            // ensure that filter is only applied once per request
            chain.doFilter(rq, rs);
        }
        else {
            request.setAttribute(FILTER_APPLIED, Boolean.TRUE);

            // force creation of the session now because Tomcat 4 had problems with
            // creating sessions after the response had been committed
            if (Container.get() == Container.TOMCAT) {
                request.getSession(true);
            }
            HttpServletResponse response = (HttpServletResponse) rs;

            // parse data into Page object (or continue as normal if Page not parseable)
            Page page = parsePage(request, response, chain);

            if (page != null) {
                page.setRequest(request);

                Decorator decorator = factory.getDecoratorMapper().getDecorator(request, page);
                if (decorator != null && decorator.getPage() != null) {
                    if(IS_DEBUG) log.debug("Decorator="+decorator.getName());
                    applyDecorator(page, decorator, request, response);
                    page = null;
                    return;
                }

                // if we got here, an exception occured or the decorator was null,
                // what we don't want is an exception printed to the user, so
                // we write the original page
                writeOriginal(request, response, page);
                page = null;
            }
        }
    }

    private String extractRequestPath(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String query = request.getQueryString();
        return (servletPath == null ? "" : servletPath)
                + (pathInfo == null ? "" : pathInfo)
                + (query == null ? "" : ("?" + query));
    }

    /** Set FilterConfig, and get instance of {@link com.opensymphony.module.sitemesh.DecoratorMapper}. */
    public void init(FilterConfig filterConfig) {
        if (filterConfig != null) {
            this.filterConfig = filterConfig;
            factory = Factory.getInstance(new Config(filterConfig));
        }
        else {
            destroy();
        }
    }

    /** @deprecated Not needed in final version of Servlet 2.3 API - replaced by init(). */
    // NOTE: SiteMesh doesn't work with Orion 1.5.2 without this method
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    /** @deprecated Not needed in final version of Servlet 2.3 API - replaced by init(). */
    // NOTE: SiteMesh doesn't work with Orion 1.5.2 without this method
    public void setFilterConfig(FilterConfig filterConfig) {
        init(filterConfig);
    }

    /** Shutdown filter. */
    public void destroy() {
        factory = null;
    }

    /**
     * Continue in filter-chain, writing all content to buffer and parsing
     * into returned {@link com.opensymphony.module.sitemesh.Page} object. If
     * {@link com.opensymphony.module.sitemesh.Page} is not parseable, null is returned.
     */
    protected Page parsePage(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {            
            // set lastPage, Peter Szocs, 2/21/05
            setLastPage(request);
            
            PageResponseWrapper pageResponse = new PageResponseWrapper(response, factory);
            chain.doFilter(request, pageResponse);
            // check if another servlet or filter put a page object to the request
            Page result = (Page)request.getAttribute(PAGE);
            if (result == null) {
                // parse the page
                result = pageResponse.getPage();
            }
            request.setAttribute(USING_STREAM, new Boolean(pageResponse.isUsingStream()));
            return result;
        }
        catch (IllegalStateException e) {
            // weblogic throws an IllegalStateException when an error page is served.
            // it's ok to ignore this, however for all other containers it should be thrown
            // properly.
            if (Container.get() != Container.WEBLOGIC) throw e;
            return null;
        }
    }

    /**
     * Apply {@link com.opensymphony.module.sitemesh.Decorator} to
     * {@link com.opensymphony.module.sitemesh.Page} and write to the response.
     */
    protected void applyDecorator(Page page, Decorator decorator, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute(PAGE, page);
            ServletContext context = filterConfig.getServletContext();
            // see if the URI path (webapp) is set
            if (decorator.getURIPath() != null) {
                // in a security conscious environment, the servlet container
                // may return null for a given URL
                if (context.getContext(decorator.getURIPath()) != null) {
                    context = context.getContext(decorator.getURIPath());
                }
            }
            // get the dispatcher for the decorator
            RequestDispatcher dispatcher = context.getRequestDispatcher(decorator.getPage());
            // create a wrapper around the response
            dispatcher.include(request, response);

            // set the headers specified as decorator init params
            while (decorator.getInitParameterNames().hasNext()) {
                String initParam = (String) decorator.getInitParameterNames().next();
                if (initParam.startsWith("header.")) {
                    response.setHeader(initParam.substring(initParam.indexOf('.')), decorator.getInitParameter(initParam));
                }
            }

            request.removeAttribute(PAGE);
        }
        catch (RuntimeException e) {
            // added a print message here because otherwise Tomcat swallows
            // the error and you never see it = bad!
            if (Container.get() == Container.TOMCAT)
                e.printStackTrace();

            throw e;
        }
    }

    /** Write the original page data to the response. */
    private void writeOriginal(HttpServletRequest request, HttpServletResponse response, Page page) throws IOException {
        response.setContentLength(page.getContentLength());
        if (request.getAttribute(USING_STREAM).equals(Boolean.TRUE))
        {
            PrintWriter writer = new PrintWriter(response.getOutputStream());
            page.writePage(writer);
            //flush writer to underlying outputStream
            writer.flush();
            response.getOutputStream().flush();
        }
        else
        {
            page.writePage(response.getWriter());
            response.getWriter().flush();
        }
    }
}
