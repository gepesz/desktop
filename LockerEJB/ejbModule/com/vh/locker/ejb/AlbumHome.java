package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Album
 */
public interface AlbumHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Album
	 */
	public com.vh.locker.ejb.Album create(java.lang.Long id, java.lang.String desc, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException;
	
    
  /**
	 * Finds an instance using a key for Entity Bean: Album
	 */
	public com.vh.locker.ejb.Album findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Album
	 */
	public com.vh.locker.ejb.Album create(java.lang.Long id)
		throws javax.ejb.CreateException;
	public com.vh.locker.ejb.Album findByDescUser(java.lang.String desc, java.lang.Long userId) throws javax.ejb.FinderException;
}
