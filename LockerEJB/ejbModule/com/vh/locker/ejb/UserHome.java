package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: User
 */
public interface UserHome extends javax.ejb.EJBLocalHome {
	
	/**
	 * Creates an instance from a key for Entity Bean: User
	 */
	public com.vh.locker.ejb.User create(java.lang.Long id, 
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
                                throws javax.ejb.CreateException;

	/**
	 * Finds an instance using a key for Entity Bean: User
	 */
	public com.vh.locker.ejb.User findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public com.vh.locker.ejb.User findByUserName(java.lang.String userName) throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;

	/**
	 * Creates an instance from a key for Entity Bean: User
	 */
	public com.vh.locker.ejb.User create(java.lang.Long id)
		throws javax.ejb.CreateException;
}