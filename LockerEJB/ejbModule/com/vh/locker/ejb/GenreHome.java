package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Genre
 */
public interface GenreHome extends javax.ejb.EJBLocalHome {
	
    /**
	 * Creates an instance from a key for Entity Bean: Genre
	 */
	public com.vh.locker.ejb.Genre create(java.lang.Long id, java.lang.String desc, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException;
	
    
    /**
	 * Finds an instance using a key for Entity Bean: Genre
	 */
	public com.vh.locker.ejb.Genre findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
	public com.vh.locker.ejb.Genre findByDescUser(java.lang.String desc, java.lang.Long userId) throws javax.ejb.FinderException;
}
