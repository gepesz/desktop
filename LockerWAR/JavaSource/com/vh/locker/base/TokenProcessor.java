/**
 * @file TokenProcessor
 * @author peter.szocs
 * @version 1.0
 * 
 * Utility class for token related functionality.
 */


package com.vh.locker.base;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vh.locker.util.Constants_Scope;

/**
 * TokenProcessor is responsible for handling all token related functionality.  The 
 * methods in this class are synchronized to protect token processing from multiple
 * threads.  Servlet containers are allowed to return a different HttpSession object
 * for two threads accessing the same session so it is not possible to synchronize 
 * on the session.
 * 
 * @since 3/2/2005
 */
public class TokenProcessor {

  /**
   * The singleton instance of this class.
   */
  private static TokenProcessor instance = new TokenProcessor();

  /**
   * Retrieves the singleton instance of this class.
   */
  public static TokenProcessor getInstance() {
    return instance;
  }

  /**
   * Protected constructor for TokenProcessor.  Use TokenProcessor.getInstance()
   * to obtain a reference to the processor.
   */
  protected TokenProcessor() {
    super();
  }


  /**
   * Return <code>true</code> if there is a transaction token stored in
   * the user's current session, and the value submitted as a request
   * parameter with this action matches it.  Returns <code>false</code>
   * under any of the following circumstances:
   * <ul>
   * <li>No session associated with this request</li>
   * <li>No transaction token saved in the session</li>
   * <li>No transaction token included as a request parameter</li>
   * <li>The included transaction token value does not match the
   *     transaction token in the user's session</li>
   * </ul>
   *
   * @param request The servlet request we are processing
   */
  public synchronized boolean isTokenValid(HttpServletRequest request) {
    return this.isTokenValid(request, false);
  }

  /**
   * Return <code>true</code> if there is a transaction token stored in
   * the user's current session, and the value submitted as a request
   * parameter with this action matches it.  Returns <code>false</code>
   * <ul>
   * <li>No session associated with this request</li>
   * <li>No transaction token saved in the session</li>
   * <li>No transaction token included as a request parameter</li>
   * <li>The included transaction token value does not match the
   *     transaction token in the user's session</li>
   * </ul>
   *
   * @param request The servlet request we are processing
   * @param reset Should we reset the token after checking it?
   */
  public synchronized boolean isTokenValid(HttpServletRequest request, boolean reset) {

    String token = getRequestToken(request);
    Set s = getSessionTokenSet(request);
    try {
      return s.contains(token);
    } finally {
      if(reset) s.remove(token);
    }
  }

  /**
   * Reset the saved transaction token in the user's session.  This
   * indicates that transactional token checking will not be needed
   * on the next request that is submitted.
   *
   * @param request The servlet request we are processing
   */
  public synchronized void resetToken(HttpServletRequest request) {

    String token = getRequestToken(request);
    Set s = getSessionTokenSet(request);
    s.remove(token);    
  }

  /**
   * Save a new transaction token in the user's current session, creating
   * a new session if necessary.
   *
   * @param request The servlet request we are processing
   */
  public synchronized static String saveToken(HttpServletRequest request) {

    String token = generateToken(request);
    Set s = getSessionTokenSet(request);
    s.add(token);    
    return token;
  }

  /**
   * Returns the token set from session.
   * 
   * @param request The request we are processing
   */
  public static Set getSessionTokenSet(HttpServletRequest request) {
    Set s = (Set)request.getSession().getAttribute(Constants_Scope.TOKENS_KEY);
    if(s==null) {
      s = new HashSet();
      request.getSession().setAttribute(Constants_Scope.TOKENS_KEY, s);
    }
    return s;
  }

  /**
   * Returns the token String from request.
   * 
   * @param request The request we are processing
   */
  public static String getRequestToken(HttpServletRequest request) {
    return request.getParameter(Constants_Scope.REQUEST_TOKEN_KEY);
  }


  /**
   * Generate a new transaction token, to be used for enforcing a single
   * request for a particular transaction.
   * 
   * @param request The request we are processing
   */
  private static long i = 0;
    
  private synchronized static String generateToken(HttpServletRequest request) {    
    i++;
    if(i<0) i=0;
    return ""+i;    
  }


}
