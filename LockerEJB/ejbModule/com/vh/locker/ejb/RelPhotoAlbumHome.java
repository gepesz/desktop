package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: RelPhotoAlbum
 */
public interface RelPhotoAlbumHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: RelPhotoAlbum
	 */
	public com.vh.locker.ejb.RelPhotoAlbum create(java.lang.Long photoId, java.lang.Long albumId, long orderInAlbum) throws javax.ejb.CreateException;

	/**
	 * Finds an instance using a key for Entity Bean: RelPhotoAlbum
	 */
	public com.vh.locker.ejb.RelPhotoAlbum findByPrimaryKey(com.vh.locker.ejb.RelPhotoAlbumKey primaryKey) throws javax.ejb.FinderException;
}
