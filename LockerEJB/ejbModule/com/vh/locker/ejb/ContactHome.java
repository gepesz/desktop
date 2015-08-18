package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Contact
 */
public interface ContactHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Contact
	 */
	public com.vh.locker.ejb.Contact create(java.lang.Long id, java.lang.String name, java.lang.String nickName, java.lang.String phone, java.lang.String email, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException;
	
  /**
	 * Finds an instance using a key for Entity Bean: Contact
	 */
	public com.vh.locker.ejb.Contact findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
}
