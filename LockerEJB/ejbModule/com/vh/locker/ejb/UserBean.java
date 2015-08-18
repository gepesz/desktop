package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: User
 */
public abstract class UserBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public java.lang.Long ejbCreate(java.lang.Long id, 
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
                                  long nofLogins,
                                  java.util.Date lastLogin,
                                  java.util.Date dateCreated,
                                  com.vh.locker.ejb.Country aCountry,
                                  com.vh.locker.ejb.Language aLanguage,
                                  com.vh.locker.ejb.SecretQuestion aSecretQuestion,
                                  com.vh.locker.ejb.UserStatus aUserStatus,
                                  com.vh.locker.ejb.UserType aUserType,
                                  com.vh.locker.ejb.Photo wallpaper,
                                  com.vh.locker.ejb.Skin skin)
                                  throws javax.ejb.CreateException {
    setId(id);
    setFirstName(firstName);
    setMiddleName(middleName);
    setLastName(lastName);
    setGender(gender);
    setBirthDay(birthDay);
    setAddress1(address1);
    setAddress2(address2);
    setCity(city);
    setState(state);
    setZip(zip);
    setUserName(userName);
    setPassword(password);
    setEmail(email);
    setPhone(phone);
    setSecretAnswer(secretAnswer);
    setNofLogins(nofLogins);
    setLastLogin(lastLogin);
    setDateCreated(dateCreated);
    return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, 
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
                            long nofLogins,
                            java.util.Date lastLogin,
                            java.util.Date dateCreated,
                            com.vh.locker.ejb.Country aCountry,
                            com.vh.locker.ejb.Language aLanguage,
                            com.vh.locker.ejb.SecretQuestion aSecretQuestion,
                            com.vh.locker.ejb.UserStatus aUserStatus,
                            com.vh.locker.ejb.UserType aUserType,
                            com.vh.locker.ejb.Photo wallpaper,
                            com.vh.locker.ejb.Skin skin)
                            throws javax.ejb.CreateException {
    setCountry(aCountry);
    setLanguage(aLanguage);
    setSecretQuestion(aSecretQuestion);
    setUserStatus(aUserStatus);
    setUserType(aUserType);
    setWallpaper(wallpaper);
    setSkin(skin);
	}
    
  public boolean update(java.lang.String firstName, 
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
                        com.vh.locker.ejb.Country aCountry,
                        com.vh.locker.ejb.Language aLanguage,
                        com.vh.locker.ejb.SecretQuestion aSecretQuestion) {
    try {
      if((firstName!=null)       && (!firstName.equals(getFirstName())))            setFirstName(firstName);
      if((middleName!=null)      && (!middleName.equals(getMiddleName())))          setMiddleName(middleName);
      if((lastName!=null)        && (!lastName.equals(getLastName())))              setLastName(lastName);
      if(gender!=getGender())                                                       setGender(gender);
      if((birthDay!=null)        && (!birthDay.equals(getBirthDay())))              setBirthDay(birthDay);
      if((address1!=null)        && (!address1.equals(getAddress1())))              setAddress1(address1);
      if((address2!=null)        && (!address2.equals(getAddress2())))              setAddress2(address2);
      if((city!=null)            && (!city.equals(getCity())))                      setCity(city);
      if((state!=null)           && (!state.equals(getState())))                    setState(state);
      if((zip!=null)             && (!zip.equals(getZip())))                        setZip(zip);
      if((userName!=null)        && (!userName.equals(getUserName())))              setUserName(userName);
      if((password!=null)        && (!password.equals(getPassword())))              setPassword(password);
      if((email!=null)           && (!email.equals(getEmail())))                    setEmail(email);
      if((phone!=null)           && (!phone.equals(getPhone())))                    setPhone(phone);
      if((secretAnswer!=null)    && (!secretAnswer.equals(getSecretAnswer())))      setSecretAnswer(secretAnswer);
      if((aCountry!=null)        && (!aCountry.equals(getCountry())))               setCountry(aCountry);
      if((aLanguage!=null)       && (!aLanguage.equals(getLanguage())))             setLanguage(aLanguage);
      if((aSecretQuestion!=null) && (!aSecretQuestion.equals(getSecretQuestion()))) setSecretQuestion(aSecretQuestion);
      
      //if(nofLogins!=getNofLogins()) setNofLogins(nofLogins);
      //if((lastLogin!=null)   && (!lastLogin.equals(getLastLogin()))) setLastLogin(lastLogin);
      //if((dateCreated!=null) && (!dateCreated.equals(getDateCreated()))) setDateCreated(dateCreated);            
    } catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;        
  }


  public boolean updatePreferences(com.vh.locker.ejb.Photo wallpaper, com.vh.locker.ejb.Skin skin) {
    try {
      if((wallpaper!=null)  && (!wallpaper.equals(getWallpaper())))   setWallpaper(wallpaper);
      if((skin!=null)       && (!skin.equals(getSkin())))             setSkin(skin);       
    } catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;        
  }

    
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: id
	 */
	public abstract java.lang.Long getId();
	/**
	 * Set accessor for persistent attribute: id
	 */
	public abstract void setId(java.lang.Long newId);
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public abstract java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public abstract void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: middleName
	 */
	public abstract java.lang.String getMiddleName();
	/**
	 * Set accessor for persistent attribute: middleName
	 */
	public abstract void setMiddleName(java.lang.String newMiddleName);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public abstract java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public abstract void setLastName(java.lang.String newLastName);
	/**
	 * Get accessor for persistent attribute: gender
	 */
	public abstract byte getGender();
	/**
	 * Set accessor for persistent attribute: gender
	 */
	public abstract void setGender(byte newGender);
	/**
	 * Get accessor for persistent attribute: birthDay
	 */
	public abstract java.util.Date getBirthDay();
	/**
	 * Set accessor for persistent attribute: birthDay
	 */
	public abstract void setBirthDay(java.util.Date newBirthDay);
	/**
	 * Get accessor for persistent attribute: address1
	 */
	public abstract java.lang.String getAddress1();
	/**
	 * Set accessor for persistent attribute: address1
	 */
	public abstract void setAddress1(java.lang.String newAddress1);
	/**
	 * Get accessor for persistent attribute: address2
	 */
	public abstract java.lang.String getAddress2();
	/**
	 * Set accessor for persistent attribute: address2
	 */
	public abstract void setAddress2(java.lang.String newAddress2);
	/**
	 * Get accessor for persistent attribute: city
	 */
	public abstract java.lang.String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public abstract void setCity(java.lang.String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public abstract java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public abstract void setState(java.lang.String newState);
	/**
	 * Get accessor for persistent attribute: zip
	 */
	public abstract java.lang.String getZip();
	/**
	 * Set accessor for persistent attribute: zip
	 */
	public abstract void setZip(java.lang.String newZip);
	/**
	 * Get accessor for persistent attribute: userName
	 */
	public abstract java.lang.String getUserName();
	/**
	 * Set accessor for persistent attribute: userName
	 */
	public abstract void setUserName(java.lang.String newUserName);
	/**
	 * Get accessor for persistent attribute: password
	 */
	public abstract java.lang.String getPassword();
	/**
	 * Set accessor for persistent attribute: password
	 */
	public abstract void setPassword(java.lang.String newPassword);
	/**
	 * Get accessor for persistent attribute: email
	 */
	public abstract java.lang.String getEmail();
	/**
	 * Set accessor for persistent attribute: email
	 */
	public abstract void setEmail(java.lang.String newEmail);
	/**
	 * Get accessor for persistent attribute: phone
	 */
	public abstract java.lang.String getPhone();
	/**
	 * Set accessor for persistent attribute: phone
	 */
	public abstract void setPhone(java.lang.String newPhone);
	/**
	 * Get accessor for persistent attribute: dateCreated
	 */
	public abstract java.util.Date getDateCreated();
	/**
	 * Set accessor for persistent attribute: dateCreated
	 */
	public abstract void setDateCreated(java.util.Date newDateCreated);
	/**
	 * This method was generated for supporting the relationship role named country.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Country getCountry();
	/**
	 * This method was generated for supporting the relationship role named country.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setCountry(com.vh.locker.ejb.Country aCountry);
	/**
	 * This method was generated for supporting the relationship role named language.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Language getLanguage();
	/**
	 * This method was generated for supporting the relationship role named language.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setLanguage(com.vh.locker.ejb.Language aLanguage);
	/**
	 * This method was generated for supporting the relationship role named secretQuestion.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.SecretQuestion getSecretQuestion();
	/**
	 * This method was generated for supporting the relationship role named secretQuestion.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setSecretQuestion(
		com.vh.locker.ejb.SecretQuestion aSecretQuestion);
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getMusicFile();
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setMusicFile(java.util.Collection aMusicFile);
	/**
	 * Get accessor for persistent attribute: nofLogins
	 */
	public abstract long getNofLogins();
	/**
	 * Set accessor for persistent attribute: nofLogins
	 */
	public abstract void setNofLogins(long newNofLogins);
	/**
	 * Get accessor for persistent attribute: lastLogin
	 */
	public abstract java.util.Date getLastLogin();
	/**
	 * Set accessor for persistent attribute: lastLogin
	 */
	public abstract void setLastLogin(java.util.Date newLastLogin);
	/**
	 * This method was generated for supporting the relationship role named userStatus.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.UserStatus getUserStatus();
	/**
	 * This method was generated for supporting the relationship role named userStatus.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setUserStatus(com.vh.locker.ejb.UserStatus anUserStatus);
	/**
	 * This method was generated for supporting the relationship role named userType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.UserType getUserType();
	/**
	 * This method was generated for supporting the relationship role named userType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setUserType(com.vh.locker.ejb.UserType anUserType);
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getGenre();
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setGenre(java.util.Collection aGenre);
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getAlbum();
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setAlbum(java.util.Collection anAlbum);
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getArtist();
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setArtist(java.util.Collection anArtist);
	/**
	 * This method was generated for supporting the relationship role named contact.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getContact();
	/**
	 * This method was generated for supporting the relationship role named contact.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setContact(java.util.Collection aContact);
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setPhotoAlbum(java.util.Collection aPhotoAlbum);
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getShortCut();
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setShortCut(java.util.Collection aShortCut);
	/**
	 * Get accessor for persistent attribute: secretAnswer
	 */
	public abstract java.lang.String getSecretAnswer();
	/**
	 * Set accessor for persistent attribute: secretAnswer
	 */
	public abstract void setSecretAnswer(java.lang.String newSecretAnswer);
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getPhoto();
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setPhoto(java.util.Collection aPhoto);
	/**
	 * This method was generated for supporting the relationship role named wallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Photo getWallpaper();
	/**
	 * This method was generated for supporting the relationship role named wallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setWallpaper(com.vh.locker.ejb.Photo aWallpaper);
	/**
	 * This method was generated for supporting the relationship role named skin.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Skin getSkin();
	/**
	 * This method was generated for supporting the relationship role named skin.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setSkin(com.vh.locker.ejb.Skin aSkin);
	/**
	 * ejbCreate
	 */
	public java.lang.Long ejbCreate(java.lang.Long id)
		throws javax.ejb.CreateException {
		setId(id);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id)
		throws javax.ejb.CreateException {
	}
}
