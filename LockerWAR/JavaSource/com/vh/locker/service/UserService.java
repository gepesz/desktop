/**
 * @file UserService
 * @author peter.szocs
 * 
 * Service methods related to user operations.
 */


package com.vh.locker.service;

import java.util.Collection;

import com.vh.locker.bean.outside.SignupForm;
import com.vh.locker.ejb.Application;
import com.vh.locker.ejb.Country;
import com.vh.locker.ejb.Language;
import com.vh.locker.ejb.SecretQuestion;
import com.vh.locker.ejb.ShortCut;
import com.vh.locker.ejb.User;
import com.vh.locker.ejb.UserStatus;
import com.vh.locker.ejb.UserType;
import com.vh.locker.service.exception.ExpiredPasswordException;
import com.vh.locker.service.exception.ServiceException;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface UserService extends Service {



  /**
   * This is the major login functionality.
   */
  public User authenticate(String username, String password) throws ServiceException;
  /**
   * Updates the (1) last login date to current date and (2) nof logins gets incremented by 1.
   */  
  public boolean updateLoginInfo(User theUser) throws ServiceException;
  /**
   * Returns whether the userName requested is still available.
   */  
  public boolean checkUserName(String userName) throws ServiceException;
  /**
   * Returns the user's preferred locale as a java.util.Locale object.
   * This method is used after login to switch the locale to the preferred one.
   */  
  public java.util.Locale getUserLocale(User theUser);

    

  /**
   * User
   */
  public User createUser(SignupForm signupForm, java.util.Date currentDate) throws ServiceException; 
                         
  public boolean updateUser(java.lang.Long userId,
                            java.lang.String firstName, 
                            java.lang.String middleName,
                            java.lang.String lastName,
                            byte gender,
                            java.util.Date birthDay,
                            java.lang.String address1,
                            java.lang.String address2,
                            java.lang.String city,
                            java.lang.String state,
                            java.lang.String zip,
                            java.lang.String userName,
                            java.lang.String password,
                            java.lang.String email,
                            java.lang.String phone,
                            java.lang.String secretAnswer,
                            java.lang.Long countryId,
                            java.lang.Long languageId,
                            java.lang.Long secretQuestionId) throws ServiceException;                         
  
  public boolean updateUserPreferences(java.lang.Long userId, java.lang.Long wallpaperId, java.lang.Long skinId) throws ServiceException;
  
  public User findUserById(Long id) throws ServiceException;
  
  public User findUserByUserName(String userName) throws ServiceException;
  
  public Collection findAllUsers() throws ServiceException;
  


  /**
   * Application
   */
  public Application findApplicationById(Long id) throws ServiceException;
  
  public Collection findAllApplications() throws ServiceException;
  
  
  
  /**
   * Country
   */
  public Country createCountry(java.lang.String desc) throws ServiceException;

  public Country findCountryById(Long id) throws ServiceException;

  public Collection findAllCountries() throws ServiceException;



  /**
   * Language
   */
  public Language createLanguage(java.lang.String loc, java.lang.String flag) throws ServiceException;

  public Language findLanguageById(Long id) throws ServiceException;

  public Collection findAllLanguages() throws ServiceException;



  /**
   * SecretQuestion
   */
  public SecretQuestion createSecretQuestion(java.lang.String desc) throws ServiceException;

  public SecretQuestion findSecretQuestionById(Long id) throws ServiceException;

  public Collection findAllSecretQuestions() throws ServiceException;



  /**
   * ShortCut
   */
  public ShortCut createShortCut(String desc, String icon, int xCoord, int yCoord, Long applicationId, Long userId) throws ServiceException;
  /**
   * Creates the default shortcuts at the default locations for a new user account.
   */
  public void createInitialShortCutsForNewUser(Long userId) throws ServiceException;

  public boolean deleteShortCutsForUser(Long userId) throws ServiceException;

  public ShortCut findShortCutById(Long id) throws ServiceException;

  public Collection findShortCutByUser(Long userId) throws ServiceException;



  /**
   * Skin
   */
  public Collection findAllSkins() throws ServiceException;



  /**
   * UserType
   */
  public UserType createUserType(java.lang.String desc) throws ServiceException;

  public UserType findUserTypeById(Long id) throws ServiceException;

  public Collection findAllUserTypes() throws ServiceException;



  /**
   * UserStatus
   */
  public UserStatus createUserStatus(java.lang.String desc) throws ServiceException;

  public UserStatus findUserStatusById(Long id) throws ServiceException;

  public Collection findAllUserStatus() throws ServiceException;

  
}
