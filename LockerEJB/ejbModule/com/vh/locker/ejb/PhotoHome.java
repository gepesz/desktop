package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Photo
 */
public interface PhotoHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Photo
	 */
	public com.vh.locker.ejb.Photo create(java.lang.Long id, java.lang.String desc, java.lang.String link, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException;
	
    /**
	 * Finds an instance using a key for Entity Bean: Photo
	 */
	public com.vh.locker.ejb.Photo findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByAlbum(java.lang.Long albumId) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Photo
	 */
	public com.vh.locker.ejb.Photo create(java.lang.Long id)
		throws javax.ejb.CreateException;
}
