/**
 * @file UserServiceImpl
 * @author peter.szocs
 * 
 * Service method implementations related to user operations.
 */


package com.vh.locker.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;

import org.apache.log4j.Logger;

import com.vh.locker.base.BaseServiceImpl;
import com.vh.locker.bean.outside.LocaleBean;
import com.vh.locker.bean.outside.SignupForm;
import com.vh.locker.ejb.Application;
import com.vh.locker.ejb.ApplicationHome;
import com.vh.locker.ejb.Country;
import com.vh.locker.ejb.CountryHome;
import com.vh.locker.ejb.Language;
import com.vh.locker.ejb.LanguageHome;
import com.vh.locker.ejb.Photo;
import com.vh.locker.ejb.PhotoHome;
import com.vh.locker.ejb.SecretQuestion;
import com.vh.locker.ejb.SecretQuestionHome;
import com.vh.locker.ejb.ShortCut;
import com.vh.locker.ejb.ShortCutHome;
import com.vh.locker.ejb.Skin;
import com.vh.locker.ejb.SkinHome;
import com.vh.locker.ejb.User;
import com.vh.locker.ejb.UserHome;
import com.vh.locker.ejb.UserStatus;
import com.vh.locker.ejb.UserStatusHome;
import com.vh.locker.ejb.UserType;
import com.vh.locker.ejb.UserTypeHome;
import com.vh.locker.service.UserService;
import com.vh.locker.service.exception.ExpiredPasswordException;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.Constants;
import com.vh.locker.util.EJBHomeCache;
import com.vh.locker.util.Constants_UI;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {

  private static Logger log=Logger.getLogger(UserServiceImpl.class);
  private static boolean IS_DEBUG = log.isDebugEnabled();
  
  // homes:
  private UserHome              mUserHome           = null;  
  private CountryHome           mCountryHome        = null;  
  private ApplicationHome       mApplicationHome    = null;  
  private LanguageHome          mLanguageHome       = null;
  private PhotoHome             mPhotoHome          = null;
  private SecretQuestionHome    mSecretQuestionHome = null;
  private ShortCutHome          mShortCutHome       = null;
  private SkinHome              mSkinHome           = null;
  private UserTypeHome          mUserTypeHome       = null;  
  private UserStatusHome        mUserStatusHome     = null;  
  
  

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Major functionality:

  /**
    * @see com.vh.locker.service.user.UserService#authenticate(String, String)
    */
  public User authenticate(String userName, String password) throws ServiceException {
    User theUser = null;
    //log.debug("password="+password);
    try {
      User temp = getUserHome().findByUserName(userName);
      if(password.equals(temp.getPassword())) theUser = temp;
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("User with username="+userName+" could not be found");
    } catch(Exception e) {
      log.error("Authentication error: "+e.toString());
      throw new ServiceException("Authentication error: "+e.getMessage());
    }
    return theUser;
  }



  /**
   * @see com.vh.locker.service.user.UserService#updateLoginInfo(User)
   */
  public boolean updateLoginInfo(User theUser) throws ServiceException {
    try {
      theUser.setLastLogin(new java.util.Date(System.currentTimeMillis()));
      theUser.setNofLogins(theUser.getNofLogins()+1);
    } catch(Exception e) {
      log.error("updateLoginInfo error: "+e.toString());
      throw new ServiceException("updateLoginInfo error: "+e.getMessage());
    }         
    return true;
  }



  /**
   * @see com.vh.locker.service.user.UserService#checkUserName(String)
   */
  public boolean checkUserName(String userName) throws ServiceException {
    boolean temp = false;
    try {
      User u = findUserByUserName(userName);
      if(u==null) temp=true;
    } catch(Exception e) {
      log.error("checkUserName error: "+e.toString());
      throw new ServiceException("checkUserName error: "+e.getMessage());
    }
    return temp;     
  }



  /**
   * @see com.vh.locker.service.user.UserService#getUserLocale(User)
   */
  public java.util.Locale getUserLocale(User theUser) {
      String language = theUser.getLanguage().getLoc().substring(0, 2);
      String country  = theUser.getLanguage().getLoc().substring(3);
      java.util.Locale loc = new java.util.Locale(language, country);
      if(log.isDebugEnabled()) log.debug("New locale="+loc.toString());
      return loc;
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// User:

  /**
   * @see com.vh.locker.service.user.UserService#createUser(String, String, String, byte, Date, String, String, String, String, String, String, String, String, String, long, Date)
   */
  
  public User createUser(SignupForm signupForm, java.util.Date currentDate) throws ServiceException {
    User ejb = null;
    try {
      Country aCountry = getCountryHome().findByPrimaryKey(new Long(1));
      Language aLanguage = getLanguageHome().findByPrimaryKey(new Long(1));
      SecretQuestion aSecretQuestion = getSecretQuestionHome().findByPrimaryKey(signupForm.getQuestion());
      UserStatus aUserStatus = getUserStatusHome().findByPrimaryKey(Constants.USERSTATUS_TRIAL);
      UserType aUserType = getUserTypeHome().findByPrimaryKey(Constants.USERTYPE_BASIC);
      Photo defaultWallpaper = getPhotoHome().findByPrimaryKey(new Long(0));
      Skin defaultSkin = getSkinHome().findByPrimaryKey(new Long(0));
      ejb = getUserHome().create(new Long(0), signupForm.getFirstName(), null, signupForm.getLastName(), Constants.GENDER_MALE, null, null, null, null, null, null, signupForm.getUserName(), signupForm.getPassword(), signupForm.getEmail(), null, signupForm.getAnswer(), 1, currentDate, currentDate, aCountry, aLanguage, aSecretQuestion, aUserStatus, aUserType, defaultWallpaper, defaultSkin);
    } catch(Exception e) {
      log.error("User could not be created: "+e.toString());
      throw new ServiceException("User could not be created: "+e.getMessage());
    }
    return ejb; 
  }
    
  /**
   * @see com.vh.locker.service.user.UserService#updateUser(Long, String, String, String, byte, Date, String, String, String, String, String, String, String, String, String)
   */  
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
                            java.lang.Long secretQuestionId) throws ServiceException {                         
    boolean updated = false;
    Country aCountry = null;
    Language aLanguage = null;
    SecretQuestion aSecretQuestion = null;    
    try {
      if(countryId!=null) aCountry = getCountryHome().findByPrimaryKey(countryId);
      if(languageId!=null) aLanguage = getLanguageHome().findByPrimaryKey(languageId);
      if(secretQuestionId!=null) aSecretQuestion = getSecretQuestionHome().findByPrimaryKey(secretQuestionId);        
      User usr = getUserHome().findByPrimaryKey(userId);
      updated = usr.update(firstName, middleName, lastName, gender, birthDay, address1, address2, city, state, zip, userName, password, email, phone, secretAnswer, aCountry, aLanguage, aSecretQuestion);
    } catch(Exception e) {
      log.error("User could not be updated: "+e.toString());
      throw new ServiceException("User could not be updated: "+e.getMessage());
    }
    return updated;                            
  }

  /**
   * @see com.vh.locker.service.user.UserService#updateUserPreferences(Long, Long, Long)
   */  
  public boolean updateUserPreferences(java.lang.Long userId, java.lang.Long wallpaperId, java.lang.Long skinId) throws ServiceException {
    boolean updated = false;
    Photo wallpaper = null;
    Skin skin = null;
    try {
      if(wallpaperId!=null) wallpaper = getPhotoHome().findByPrimaryKey(wallpaperId);
      if(skinId!=null) skin = getSkinHome().findByPrimaryKey(skinId);
      User usr = getUserHome().findByPrimaryKey(userId);
      updated = usr.updatePreferences(wallpaper, skin);
    } catch(Exception e) {
      log.error("User preferences could not be updated: "+e.toString());
      throw new ServiceException("User preferences could not be updated: "+e.getMessage());
    }
    return updated;
  }
  
  /**
   * @see com.vh.locker.service.user.UserService#findUserById(Long)
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

  /**
   * @see com.vh.locker.service.user.UserService#findUserByUserName(String)
   */  
  public User findUserByUserName(String userName) throws ServiceException {
    User theUser = null;
    //log.debug("password="+password);
    try {
      theUser = getUserHome().findByUserName(userName);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("User with username="+userName+" could not be found");
    } catch(Exception e) {
      log.error("findUserByUserName with userName="+userName+" error: "+e.toString());
      throw new ServiceException("findUserByUserName with userName="+userName+" error: "+e.getMessage());
    }
    return theUser;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findAllUsers()
   */    
  public Collection findAllUsers() throws ServiceException {
    Collection list = null;
    try {
      list = getUserHome().findAll();
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("All User collection could not be found");
    } catch(Exception e) {
      log.error("All User collection error: "+e.toString());
      throw new ServiceException("All User collection error: "+e.getMessage());
    }
    return list;      
  }
  


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Country:

  /**
   * @see com.vh.locker.service.user.UserService#createCountry(String)
   */
  public Country createCountry(java.lang.String desc) throws ServiceException {
    Country ejb = null;
    try {
      ejb = getCountryHome().create(new Long(0), desc);
    } catch(Exception e) {
      log.error("Country could not be created: "+e.toString());
      throw new ServiceException("Country could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.user.UserService#findCountryById(Long)
   */  
  public Country findCountryById(Long id) throws ServiceException {
    Country ejb = null;
    try {
      ejb = getCountryHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Country with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findCountryById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findCountryById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findAllCountries()
   */    
  public Collection findAllCountries() throws ServiceException {
    Collection list = null;
    try {
      list = getCountryHome().findAll();
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("All Country collection could not be found");
    } catch(Exception e) {
      log.error("All Country collection error: "+e.toString());
      throw new ServiceException("All Country collection error: "+e.getMessage());
    }
    return list;      
  }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Language:

  /**
   * @see com.vh.locker.service.user.UserService#createLanguage(String, String)
   */
  public Language createLanguage(java.lang.String loc, java.lang.String flag) throws ServiceException {
    Language ejb = null;
    try {
      ejb = getLanguageHome().create(new Long(0), loc, flag);
    } catch(Exception e) {
      log.error("Language could not be created: "+e.toString());
      throw new ServiceException("Language could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.user.UserService#findLanguageById(Long)
   */  
  public Language findLanguageById(Long id) throws ServiceException {
    Language ejb = null;
    try {
      ejb = getLanguageHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Language with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findLanguageById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findLanguageById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findAllLanguages()
   */    
  public Collection findAllLanguages() throws ServiceException {
    ArrayList arr = new ArrayList();
    try {
      Collection langColl = getLanguageHome().findAll();
      Iterator it = langColl.iterator();
      while(it.hasNext()) {
        Language language = (Language) it.next();
        arr.add( new LocaleBean(language.getLoc(), language.getFlag()) );
      }
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("All Language collection could not be found");
    } catch(Exception e) {
      log.error("All Language collection error: "+e.toString());
      throw new ServiceException("All Language collection error: "+e.getMessage());
    }
    return arr;
  }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// SecretQuestion:

  /**
   * @see com.vh.locker.service.user.UserService#createSecretQuestion(String)
   */
  public SecretQuestion createSecretQuestion(java.lang.String desc) throws ServiceException {
    SecretQuestion ejb = null;
    try {
      ejb = getSecretQuestionHome().create(new Long(0), desc);
    } catch(Exception e) {
      log.error("SecretQuestion could not be created: "+e.toString());
      throw new ServiceException("SecretQuestion could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.user.UserService#findSecretQuestionById(Long)
   */  
  public SecretQuestion findSecretQuestionById(Long id) throws ServiceException {
    SecretQuestion ejb = null;
    try {
      ejb = getSecretQuestionHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("SecretQuestion with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findSecretQuestionById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findSecretQuestionById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findAllSecretQuestions()
   */    
  public Collection findAllSecretQuestions() throws ServiceException {
    Collection list = null;
    try {
      list = getSecretQuestionHome().findAll();
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("All SecretQuestion collection could not be found");
    } catch(Exception e) {
      log.error("All SecretQuestion collection error: "+e.toString());
      throw new ServiceException("All SecretQuestion collection error: "+e.getMessage());
    }
    return list;      
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Application:

  /**
   * @see com.vh.locker.service.user.UserService#findApplicationById(Long)
   */
  public Application findApplicationById(Long id) throws ServiceException {
    Application ejb = null;
    try {
      ejb = getApplicationHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Application with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findApplicationById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findApplicationById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;   
  }

 /**
  * @see com.vh.locker.service.user.UserService#findAllApplications()
  */
  public Collection findAllApplications() throws ServiceException {
    Collection list = null;
    try {
      list = getApplicationHome().findAll();
    } catch(Exception e) {
      log.error("All application collection error: "+e.toString());
      throw new ServiceException("All application collection error: "+e.getMessage());
    }
    return list;  
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ShortCut:

  /**
   * @see com.vh.locker.service.user.UserService#createShortCut(String, String, int, int, Long, Long)
   */
  public ShortCut createShortCut(String desc, String icon, int xCoord, int yCoord, Long applicationId, Long userId) throws ServiceException {
    ShortCut ejb = null;
    Application anApplication = null;
    User aUser = null;
    try {
      if(applicationId!=null) anApplication = getApplicationHome().findByPrimaryKey(applicationId);
      if(userId!=null) aUser = findUserById(userId);
      ejb = getShortCutHome().create(null, desc, icon, xCoord, yCoord, anApplication, aUser);
    } catch(Exception e) {
      log.error("ShortCut could not be created: "+e.toString());
      throw new ServiceException("ShortCut could not be created: "+e.getMessage());
    }
    return ejb;  
  }

  /**
   * @see com.vh.locker.service.user.UserService#createInitialShortCutsForNewUser(Long)
   */
  public void createInitialShortCutsForNewUser(Long userId) throws ServiceException {
    Collection allApps = findAllApplications();
    Iterator it = allApps.iterator();
    int i=0;
    while(it.hasNext()) {
      Application app = (Application) it.next();
      if(i%2==0) createShortCut(app.getDesc(), app.getDefaultIcon(), Constants_UI.CANVAS_LEFT_MARGIN,                                  Constants_UI.CANVAS_TOP_MARGIN+(Constants_UI.SHORTCUT_DIV_HEIGHT+5)*(i/2), app.getId(), userId);
      else       createShortCut(app.getDesc(), app.getDefaultIcon(), Constants_UI.CANVAS_LEFT_MARGIN+Constants_UI.SHORTCUT_DIV_WIDTH+1, Constants_UI.CANVAS_TOP_MARGIN+(Constants_UI.SHORTCUT_DIV_HEIGHT+5)*(i/2), app.getId(), userId);
      i++;
    }
  }

  /**
   * @see com.vh.locker.service.user.UserService#deleteShortCutsForUser(Long)
   */
  public boolean deleteShortCutsForUser(Long userId) throws ServiceException {
    boolean deleted = false;
    try {
      Collection coll = findShortCutByUser(userId);
      Iterator it = coll.iterator();
      while(it.hasNext()) ((ShortCut) it.next()).remove();
      deleted=true;
    } catch(Exception e) {
      log.error("Delete shortcuts error: "+e.toString());
      throw new ServiceException("Delete shortcuts error: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.user.UserService#findShortCutById(Long)
   */
  public ShortCut findShortCutById(Long id) throws ServiceException {
    ShortCut ejb = null;
    try {
      ejb = getShortCutHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("ShortCut with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findShortCutById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findShortCutById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findShortCutByUser(Long)
   */
  public Collection findShortCutByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getShortCutHome().findByUser(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("ShortCut collection with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findShortCutByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findShortCutByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Skin:

  /**
   * @see com.vh.locker.service.user.UserService#findAllSkins()
   */
  public Collection findAllSkins() throws ServiceException {
    Collection list = null;
    try {
      list = getSkinHome().findAll();
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("All Skins collection could not be found");
    } catch(Exception e) {
      log.error("All Skins finder error: "+e.toString());
      throw new ServiceException("All Skins finder error: "+e.getMessage());
    }
    return list;    
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// UserType:

  /**
   * @see com.vh.locker.service.user.UserService#createUserType(String)
   */
  public UserType createUserType(java.lang.String desc) throws ServiceException {
    UserType ejb = null;
    try {
      ejb = getUserTypeHome().create(new Long(0), desc);
    } catch(Exception e) {
      log.error("UserType could not be created: "+e.toString());
      throw new ServiceException("UserType could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.user.UserService#findUserTypeById(Long)
   */  
  public UserType findUserTypeById(Long id) throws ServiceException {
    UserType ejb = null;
    try {
      ejb = getUserTypeHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("UserType with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findUserTypeById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findUserTypeById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findAllUserTypes()
   */    
  public Collection findAllUserTypes() throws ServiceException {
    Collection list = null;
    try {
      list = getUserTypeHome().findAll();
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("All UserType collection could not be found");
    } catch(Exception e) {
      log.error("All UserType collection error: "+e.toString());
      throw new ServiceException("All UserType collection error: "+e.getMessage());
    }
    return list;      
  }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// UserStatus:

  /**
   * @see com.vh.locker.service.user.UserService#createUserStatus(String)
   */
  public UserStatus createUserStatus(java.lang.String desc) throws ServiceException {
    UserStatus ejb = null;
    try {
      ejb = getUserStatusHome().create(new Long(0), desc);
    } catch(Exception e) {
      log.error("UserStatus could not be created: "+e.toString());
      throw new ServiceException("UserStatus could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.user.UserService#findUserStatusById(Long)
   */  
  public UserStatus findUserStatusById(Long id) throws ServiceException {
    UserStatus ejb = null;
    try {
      ejb = getUserStatusHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("UserStatus with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findUserStatusById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findUserStatusById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.user.UserService#findAllUserStatus()
   */    
  public Collection findAllUserStatus() throws ServiceException {
    Collection list = null;
    try {
      list = getUserStatusHome().findAll();
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("All UserStatus collection could not be found");
    } catch(Exception e) {
      log.error("All UserStatus collection error: "+e.toString());
      throw new ServiceException("All UserStatus collection error: "+e.getMessage());
    }
    return list;      
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

  private synchronized ApplicationHome getApplicationHome() throws ServiceException {
    if(mApplicationHome == null) {
      try {
        mApplicationHome = (ApplicationHome)EJBHomeCache.lookup(Application_HOME);
      } catch(Exception e) {
        log.error("ApplicationHome cannot be initiated: "+e.toString());
        throw new ServiceException("ApplicationHome cannot be initiated: "+e.getMessage());
      }
    }
    return mApplicationHome;
  }

  private synchronized CountryHome getCountryHome() throws ServiceException {
    if(mCountryHome == null) {
      try {
        mCountryHome = (CountryHome)EJBHomeCache.lookup(Country_HOME);
      } catch(Exception e) {
        log.error("CountryHome cannot be initiated: "+e.toString());
        throw new ServiceException("CountryHome cannot be initiated: "+e.getMessage());
      }
    }
    return mCountryHome;
  }

  private synchronized LanguageHome getLanguageHome() throws ServiceException {
    if(mLanguageHome == null) {
      try {
        mLanguageHome = (LanguageHome)EJBHomeCache.lookup(Language_HOME);
      } catch(Exception e) {
        log.error("LanguageHome cannot be initiated: "+e.toString());
        throw new ServiceException("LanguageHome cannot be initiated: "+e.getMessage());
      }
    }
    return mLanguageHome;
  }

  private synchronized PhotoHome getPhotoHome() throws ServiceException {
    if(mPhotoHome == null) {
      try {
        mPhotoHome = (PhotoHome)EJBHomeCache.lookup(Photo_HOME);
      } catch(Exception e) {
        log.error("PhotoHome cannot be initiated: "+e.toString());
        throw new ServiceException("PhotoHome cannot be initiated: "+e.getMessage());
      }
    }
    return mPhotoHome;
  }

  private synchronized SecretQuestionHome getSecretQuestionHome() throws ServiceException {
    if(mSecretQuestionHome == null) {
      try {
          mSecretQuestionHome = (SecretQuestionHome)EJBHomeCache.lookup(SecretQuestion_HOME);
      } catch(Exception e) {
        log.error("SecretQuestionHome cannot be initiated: "+e.toString());
        throw new ServiceException("SecretQuestionHome cannot be initiated: "+e.getMessage());
      }
    }
    return mSecretQuestionHome;
  }

  private synchronized ShortCutHome getShortCutHome() throws ServiceException {
    if(mShortCutHome == null) {
      try {
        mShortCutHome = (ShortCutHome)EJBHomeCache.lookup(ShortCut_HOME);
      } catch(Exception e) {
        log.error("ShortCutHome cannot be initiated: "+e.toString());
        throw new ServiceException("ShortCutHome cannot be initiated: "+e.getMessage());
      }
    }
    return mShortCutHome;
  }

  private synchronized SkinHome getSkinHome() throws ServiceException {
    if(mSkinHome == null) {
      try {
        mSkinHome = (SkinHome)EJBHomeCache.lookup(Skin_HOME);
      } catch(Exception e) {
        log.error("SkinHome cannot be initiated: "+e.toString());
        throw new ServiceException("SkinHome cannot be initiated: "+e.getMessage());
      }
    }
    return mSkinHome;
  }

  private synchronized UserTypeHome getUserTypeHome() throws ServiceException {
    if(mUserTypeHome == null) {
      try {
          mUserTypeHome = (UserTypeHome)EJBHomeCache.lookup(UserType_HOME);
      } catch(Exception e) {
        log.error("UserTypeHome cannot be initiated: "+e.toString());
        throw new ServiceException("UserTypeHome cannot be initiated: "+e.getMessage());
      }
    }
    return mUserTypeHome;
  }

  private synchronized UserStatusHome getUserStatusHome() throws ServiceException {
    if(mUserStatusHome == null) {
      try {
          mUserStatusHome = (UserStatusHome)EJBHomeCache.lookup(UserStatus_HOME);
      } catch(Exception e) {
        log.error("UserStatusHome cannot be initiated: "+e.toString());
        throw new ServiceException("UserStatusHome cannot be initiated: "+e.getMessage());
      }
    }
    return mUserStatusHome;
  }


}
