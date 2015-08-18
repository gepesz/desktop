package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: ShortCut
 */
public interface ShortCutHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: ShortCut
	 */
	public com.vh.locker.ejb.ShortCut create(java.lang.Long id, java.lang.String desc, java.lang.String icon, int xCoord, int yCoord, com.vh.locker.ejb.Application anApplication, com.vh.locker.ejb.User aUser) throws javax.ejb.CreateException;

	/**
	 * Finds an instance using a key for Entity Bean: ShortCut
	 */
	public com.vh.locker.ejb.ShortCut findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
}
