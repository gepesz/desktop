package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Mixes
 */
public interface MixesHome extends javax.ejb.EJBLocalHome {
	
    /**
	 * Creates an instance from a key for Entity Bean: Mixes
	 */
	public com.vh.locker.ejb.Mixes create(java.lang.Long id, java.lang.String title, long length, java.util.Date dateCreated, long nofPlayed, com.vh.locker.ejb.Genre aGenre) throws javax.ejb.CreateException;
	
    
    /**
	 * Finds an instance using a key for Entity Bean: Mixes
	 */
	public com.vh.locker.ejb.Mixes findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
	public java.util.Collection findByGenre(java.lang.Long genreId) throws javax.ejb.FinderException;
}
