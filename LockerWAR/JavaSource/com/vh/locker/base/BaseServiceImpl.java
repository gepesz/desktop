/**
 * @file BaseServiceImpl
 * @author peter.szocs
 * 
 * This is a java class that every regular service must extend.
 * It contains base methods used by all services.
 */


package com.vh.locker.base;

import javax.ejb.FinderException;

import org.apache.log4j.Logger;
import com.vh.locker.ejb.User;
import com.vh.locker.ejb.UserHome;
import com.vh.locker.service.Service;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.Constants;
import com.vh.locker.util.EJBHomeCache;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class BaseServiceImpl implements Service, Constants {

  private static Logger log=Logger.getLogger(BaseServiceImpl.class);
  
  //homes:
  private UserHome      mUserHome     = null;  
  
  

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Major functionality:

  /**
   * Returns the user for the given userId.
   * 
   * @param id the userId
   * @return User the user with that userId.  Returns null if no user with that id can be found.
   */  
  public User findUserById(Long id) throws ServiceException {
    User ejb = null;
    try {
      ejb = getUserHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("User with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findUserById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findUserById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Getting EJB Homes:

  private synchronized UserHome getUserHome() throws ServiceException {
    if(mUserHome == null) {
      try {
        mUserHome = (UserHome)EJBHomeCache.lookup(User_HOME);
      } catch(Exception e) {
        log.error("UserHome cannot be initiated: "+e.toString());
        throw new ServiceException("UserHome cannot be initiated: "+e.getMessage());
      }
    }
    return mUserHome;
  }

}
