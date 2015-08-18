/**
 * @file ServiceFactory
 * @author peter.szocs
 * 
 * Uses commons pooling to implement pooling of services.
 */

package com.vh.locker.service;

import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.log4j.Logger;

import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2004 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class ServiceFactory implements KeyedPoolableObjectFactory {

  private static Logger log = Logger.getLogger(ServiceFactory.class);

  public Object makeObject(Object key) {
    try {
      return Class.forName(Constants.SERVICES.getString(key.toString())).newInstance();			
    } catch(Exception e) {
      log.error("Unable to make object for <"+key.toString()+">: "+e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public void destroyObject(Object key, Object obj) { }
  public boolean validateObject(Object key, Object obj) { return true; }
  public void activateObject(Object key, Object obj) { }
  public void passivateObject(Object key, Object obj) { }

}