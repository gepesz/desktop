package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Skin
 */
public interface SkinHome extends javax.ejb.EJBLocalHome {

	/**
	 * Creates an instance from a key for Entity Bean: Skin
	 */
	public com.vh.locker.ejb.Skin create(java.lang.Long id, java.lang.String name, java.lang.String fileName)	throws javax.ejb.CreateException;

	/**
	 * Finds an instance using a key for Entity Bean: Skin
	 */
	public com.vh.locker.ejb.Skin findByPrimaryKey(java.lang.Long primaryKey)	throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;

}