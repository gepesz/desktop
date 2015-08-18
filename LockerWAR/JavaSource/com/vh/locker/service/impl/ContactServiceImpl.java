/**
 * @file ContactServiceImpl
 * @author peter.szocs
 * 
 * Service methods related to user contacts (phone/sms module).
 */


package com.vh.locker.service.impl;

import java.util.Collection;

import javax.ejb.FinderException;

import org.apache.log4j.Logger;

import com.vh.locker.base.BaseServiceImpl;
import com.vh.locker.ejb.Contact;
import com.vh.locker.ejb.ContactHome;
import com.vh.locker.ejb.User;
import com.vh.locker.service.ContactService;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.EJBHomeCache;


/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class ContactServiceImpl extends BaseServiceImpl implements ContactService {

  private static Logger log=Logger.getLogger(ContactServiceImpl.class);
  private final boolean IS_DEBUG = log.isDebugEnabled();
  
  //homes:
  private ContactHome         mContactHome        = null;
  
  


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Contact:

  /**
   * @see com.vh.locker.service.ContactService#createContact(Long, String, String, String, String, User)
   */
  public Contact createContact(String name, String nickName, String phone, String email, Long userId) throws ServiceException {
    Contact ejb = null;
    User aUser = null;
    try {
      if(userId!=null) aUser=findUserById(userId);
      ejb = getContactHome().create(null, name, nickName, phone, email, aUser);
    } catch(Exception e) {
      log.error("Contact could not be created: "+e.toString());
      throw new ServiceException("Contact could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.ContactService#deleteContact(String[])
   */    
  public boolean deleteContacts(String[] contactIds) throws ServiceException {
    boolean deleted = false;
    try {
      for(int i=0;i<contactIds.length;i++) {
        Long cId = new Long(contactIds[i]);
        findContactById(cId).remove();
      }
      deleted=true;
    } catch(Exception e) {
      log.error("Delete contacts error: "+e.toString());
      throw new ServiceException("Delete contacts error: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.ContactService#updateContact(Long, String, String, String, String)
   */    
  public boolean updateContact(Long id, String name, String nickName, String phone, String email) throws ServiceException {
    boolean updated = false;
    try {
      Contact c = getContactHome().findByPrimaryKey(id);
      updated = c.update(name, nickName, phone, email);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Contact with id=" + id + " could not be found");    
    } catch(Exception e) {
      log.error("Contact "+id+" could not be updated: "+e.toString());
      throw new ServiceException("Contact "+id+" could not be updated: "+e.getMessage());
    }
    return updated;  
  }

  /**
   * @see com.vh.locker.service.ContactService#findContactById(Long)
   */    
  public Contact findContactById(Long id) throws ServiceException {
    Contact ejb = null;
    try {
      ejb = getContactHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Contact with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findContactById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findContactById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.ContactService#findContactByUser(Long)
   */
  public Collection findContactByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getContactHome().findByUser(userId);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Contact collection with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findContactByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findContactByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;    
  }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Getting EJB Homes:


  private synchronized ContactHome getContactHome() throws ServiceException {
    if(mContactHome == null) {
      try {
        mContactHome = (ContactHome)EJBHomeCache.lookup(Contact_HOME);
      } catch(Exception e) {
        log.error("ContactHome cannot be initiated: "+e.toString());
        throw new ServiceException("ContactHome cannot be initiated: "+e.getMessage());
      }
    }
    return mContactHome;
  }

}
