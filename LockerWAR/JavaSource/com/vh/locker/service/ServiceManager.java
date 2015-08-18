/**
 * @file ServiceManager
 * @author peter.szocs
 * 
 * This file is used to acquire and release services.
 */

package com.vh.locker.service;

import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.service.exception.UnsupportedServiceException;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class ServiceManager {

  private static Logger log=Logger.getLogger(ServiceManager.class);
  private static GenericKeyedObjectPool pool = new GenericKeyedObjectPool(new ServiceFactory(), 10, GenericObjectPool.WHEN_EXHAUSTED_GROW, 1000);    

  
  /**
   * Returns an implementation of the requested Service.
   * 
   * @param serviceName the name of the Service requested (use Constants)
   * @return Service the requested Service implementation
   * @throws ServiceException on error
   */
  public static Service acquire(java.lang.String serviceName) throws ServiceException {
    Service svc = null;
    if(serviceName!=null) {
      try {
        svc = (Service)pool.borrowObject(serviceName);
        if(log.isDebugEnabled()) log.debug("Acquired <" + serviceName + ">");
      } catch(Exception e) {
        log.error("No service instance could be created for service <"+serviceName+">: "+e.getMessage());
        e.printStackTrace();
        throw new UnsupportedServiceException(e);
      }
    } else {
      log.error("No serviceName specified (serviceName=null)");
      throw new UnsupportedServiceException("No serviceName specified (serviceName=null)");
    }
    return svc;
  }


  
  /**
   * Releases the Service object.
   * 
   * @param serviceName the name of the Service to be released
   * @param Service the Service object to be returned
   * @throws ServiceException on error
   */
  public static boolean release(java.lang.String serviceName, Object ss) throws ServiceException {
    boolean released = false;
    if((serviceName!=null) && (ss!=null)) {
      try {
        pool.returnObject(serviceName, ss);
        released=true;
        if(log.isDebugEnabled()) log.debug("Released <" + serviceName + ">");
      } catch(Exception e) {
        log.error("Error while releasing service <"+serviceName+">: "+e.getMessage());
        e.printStackTrace();
        throw new UnsupportedServiceException(e);
      }
    } else if(serviceName==null) {
      log.error("No serviceName specified (serviceName=null)");
      throw new UnsupportedServiceException("No serviceName specified (serviceName=null)");
    } else {
      log.warn("Service <"+serviceName+"> could not be returned: instance is null");      
    }
    return released;
  }

  
  
  /**
   * Logs information about the pools using log4j debug statements.
   */
  public static void getPoolInfo() {
    if(log.isDebugEnabled()) {
      log.debug("****** START POOL INFO ******");
      log.debug("Max Active: " + pool.getMaxActive());
      log.debug("Active objects: " + pool.getNumActive());
      log.debug("Max Idle: " + pool.getMaxIdle());
      log.debug("Idle objects: " + pool.getNumIdle());
      log.debug("Max Wait: " + pool.getMaxWait());

      log.debug("Test on borrow: " + pool.getTestOnBorrow());
      log.debug("Test on return: " + pool.getTestOnReturn());
      log.debug("Test while idle: " + pool.getTestWhileIdle());
      
      switch (pool.getWhenExhaustedAction()) {
        case GenericKeyedObjectPool.WHEN_EXHAUSTED_BLOCK: log.debug("When Exhausted Action: WHEN_EXHAUSTED_BLOCK"); break;
        case GenericKeyedObjectPool.WHEN_EXHAUSTED_FAIL:  log.debug("When Exhausted Action: WHEN_EXHAUSTED_FAIL");  break;
        case GenericKeyedObjectPool.WHEN_EXHAUSTED_GROW:  log.debug("When Exhausted Action: WHEN_EXHAUSTED_GROW");  break;
        default: log.debug("When Exhausted Action not defined, reading from pool: "+pool.getWhenExhaustedAction()); break;
      }      
      log.debug("****** END POOL INFO ******");
    }
  }
  
}