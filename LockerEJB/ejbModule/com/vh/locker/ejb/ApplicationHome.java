package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Application
 */
public interface ApplicationHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Application
	 */
	public com.vh.locker.ejb.Application create(java.lang.Long id, java.lang.String desc, java.lang.String defaultIcon, java.lang.String targetUrl) throws javax.ejb.CreateException;

	/**
	 * Finds an instance using a key for Entity Bean: Application
	 */
	public com.vh.locker.ejb.Application findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;
}
