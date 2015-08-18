package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: User
 */
public interface User extends javax.ejb.EJBLocalObject {

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
                        com.vh.locker.ejb.SecretQuestion aSecretQuestion);
                        
  public boolean updatePreferences(com.vh.locker.ejb.Photo wallpaper, com.vh.locker.ejb.Skin skin);
                        
	/**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
  /**
	 * Get accessor for persistent attribute: firstName
	 */
	public java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: middleName
	 */
	public java.lang.String getMiddleName();
	/**
	 * Set accessor for persistent attribute: middleName
	 */
	public void setMiddleName(java.lang.String newMiddleName);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public void setLastName(java.lang.String newLastName);
	/**
	 * Get accessor for persistent attribute: gender
	 */
	public byte getGender();
	/**
	 * Set accessor for persistent attribute: gender
	 */
	public void setGender(byte newGender);
	/**
	 * Get accessor for persistent attribute: birthDay
	 */
	public java.util.Date getBirthDay();
	/**
	 * Set accessor for persistent attribute: birthDay
	 */
	public void setBirthDay(java.util.Date newBirthDay);
	/**
	 * Get accessor for persistent attribute: address1
	 */
	public java.lang.String getAddress1();
	/**
	 * Set accessor for persistent attribute: address1
	 */
	public void setAddress1(java.lang.String newAddress1);
	/**
	 * Get accessor for persistent attribute: address2
	 */
	public java.lang.String getAddress2();
	/**
	 * Set accessor for persistent attribute: address2
	 */
	public void setAddress2(java.lang.String newAddress2);
	/**
	 * Get accessor for persistent attribute: city
	 */
	public java.lang.String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public void setCity(java.lang.String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState);
	/**
	 * Get accessor for persistent attribute: zip
	 */
	public java.lang.String getZip();
	/**
	 * Set accessor for persistent attribute: zip
	 */
	public void setZip(java.lang.String newZip);
	/**
	 * Get accessor for persistent attribute: userName
	 */
	public java.lang.String getUserName();
	/**
	 * Set accessor for persistent attribute: userName
	 */
	public void setUserName(java.lang.String newUserName);
	/**
	 * Get accessor for persistent attribute: password
	 */
	public java.lang.String getPassword();
	/**
	 * Set accessor for persistent attribute: password
	 */
	public void setPassword(java.lang.String newPassword);
	/**
	 * Get accessor for persistent attribute: email
	 */
	public java.lang.String getEmail();
	/**
	 * Set accessor for persistent attribute: email
	 */
	public void setEmail(java.lang.String newEmail);
	/**
	 * Get accessor for persistent attribute: phone
	 */
	public java.lang.String getPhone();
	/**
	 * Set accessor for persistent attribute: phone
	 */
	public void setPhone(java.lang.String newPhone);
	/**
	 * Get accessor for persistent attribute: dateCreated
	 */
	public java.util.Date getDateCreated();
	/**
	 * Set accessor for persistent attribute: dateCreated
	 */
	public void setDateCreated(java.util.Date newDateCreated);
	/**
	 * This method was generated for supporting the relationship role named country.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Country getCountry();
	/**
	 * This method was generated for supporting the relationship role named country.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setCountry(com.vh.locker.ejb.Country aCountry);
	/**
	 * This method was generated for supporting the relationship role named language.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Language getLanguage();
	/**
	 * This method was generated for supporting the relationship role named language.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setLanguage(com.vh.locker.ejb.Language aLanguage);
	/**
	 * This method was generated for supporting the relationship role named secretQuestion.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.SecretQuestion getSecretQuestion();
	/**
	 * This method was generated for supporting the relationship role named secretQuestion.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setSecretQuestion(com.vh.locker.ejb.SecretQuestion aSecretQuestion);
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getMusicFile();
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setMusicFile(java.util.Collection aMusicFile);
	/**
	 * Get accessor for persistent attribute: nofLogins
	 */
	public long getNofLogins();
	/**
	 * Set accessor for persistent attribute: nofLogins
	 */
	public void setNofLogins(long newNofLogins);
	/**
	 * Get accessor for persistent attribute: lastLogin
	 */
	public java.util.Date getLastLogin();
	/**
	 * Set accessor for persistent attribute: lastLogin
	 */
	public void setLastLogin(java.util.Date newLastLogin);
	/**
	 * This method was generated for supporting the relationship role named userStatus.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.UserStatus getUserStatus();
	/**
	 * This method was generated for supporting the relationship role named userStatus.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setUserStatus(com.vh.locker.ejb.UserStatus anUserStatus);
	/**
	 * This method was generated for supporting the relationship role named userType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.UserType getUserType();
	/**
	 * This method was generated for supporting the relationship role named userType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setUserType(com.vh.locker.ejb.UserType anUserType);
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getGenre();
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setGenre(java.util.Collection aGenre);
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getAlbum();
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setAlbum(java.util.Collection anAlbum);
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getArtist();
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setArtist(java.util.Collection anArtist);
	/**
	 * This method was generated for supporting the relationship role named contact.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getContact();
	/**
	 * This method was generated for supporting the relationship role named contact.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setContact(java.util.Collection aContact);
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setPhotoAlbum(java.util.Collection aPhotoAlbum);
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getShortCut();
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setShortCut(java.util.Collection aShortCut);
	/**
	 * Get accessor for persistent attribute: secretAnswer
	 */
	public java.lang.String getSecretAnswer();
	/**
	 * Set accessor for persistent attribute: secretAnswer
	 */
	public void setSecretAnswer(java.lang.String newSecretAnswer);
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getPhoto();
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setPhoto(java.util.Collection aPhoto);
	/**
	 * This method was generated for supporting the relationship role named wallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Photo getWallpaper();
	/**
	 * This method was generated for supporting the relationship role named wallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setWallpaper(com.vh.locker.ejb.Photo aWallpaper);
	/**
	 * This method was generated for supporting the relationship role named skin.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Skin getSkin();
	/**
	 * This method was generated for supporting the relationship role named skin.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setSkin(com.vh.locker.ejb.Skin aSkin);
}
