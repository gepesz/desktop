/**
 * @file ContactService
 * @author peter.szocs
 * 
 * Service methods related to user contacts (phone/sms module).
 */


package com.vh.locker.service;

import java.util.Collection;

import com.vh.locker.ejb.Contact;
import com.vh.locker.service.exception.ServiceException;


/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface ContactService extends Service {


  /**
   * Contact
   */
  public Contact createContact(String name, String nickName, String phone, String email, Long userId) throws ServiceException;

  public boolean deleteContacts(String[] contactIds) throws ServiceException;

  public boolean updateContact(Long id, String name, String nickName, String phone, String email) throws ServiceException;
    
  public Contact findContactById(Long id) throws ServiceException;

  public Collection findContactByUser(Long userId) throws ServiceException;


}
