package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: PhotoAlbum
 */
public interface PhotoAlbumHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: PhotoAlbum
	 */
	public com.vh.locker.ejb.PhotoAlbum create(java.lang.Long id, java.lang.String title, java.lang.String desc, java.util.Date dateCreated, long nofVisits, com.vh.locker.ejb.User aUser) throws javax.ejb.CreateException;
	
    /**
	 * Finds an instance using a key for Entity Bean: PhotoAlbum
	 */
	public com.vh.locker.ejb.PhotoAlbum findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
}