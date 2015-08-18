package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Artist
 */
public interface ArtistHome extends javax.ejb.EJBLocalHome {
	
  /**
	 * Creates an instance from a key for Entity Bean: Artist
	 */
	public com.vh.locker.ejb.Artist create(java.lang.Long id, java.lang.String desc, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException;
	
    
  /**
	 * Finds an instance using a key for Entity Bean: Artist
	 */
	public com.vh.locker.ejb.Artist findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Artist
	 */
	public com.vh.locker.ejb.Artist create(java.lang.Long id)
		throws javax.ejb.CreateException;
	public com.vh.locker.ejb.Artist findByDescUser(java.lang.String desc, java.lang.Long userId) throws javax.ejb.FinderException;
}
