package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: UserStatus
 */
public interface UserStatusHome extends javax.ejb.EJBLocalHome {
	
  /**
	 * Creates an instance from a key for Entity Bean: UserStatus
	 */
	public com.vh.locker.ejb.UserStatus create(java.lang.Long id, java.lang.String desc) throws javax.ejb.CreateException;


	/**
	 * Finds an instance using a key for Entity Bean: UserStatus
	 */
	public com.vh.locker.ejb.UserStatus findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;
}
