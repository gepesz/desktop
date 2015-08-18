package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: RelMusicMixes
 */
public interface RelMusicMixesHome extends javax.ejb.EJBLocalHome {
	
    /**
	 * Creates an instance from a key for Entity Bean: RelMusicMixes
	 */
	public com.vh.locker.ejb.RelMusicMixes create(java.lang.Long musicFileId, java.lang.Long mixesId, long orderInMix) throws javax.ejb.CreateException;
	
    
    /**
	 * Finds an instance using a key for Entity Bean: RelMusicMixes
	 */
	public com.vh.locker.ejb.RelMusicMixes findByPrimaryKey(com.vh.locker.ejb.RelMusicMixesKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByMix(java.lang.Long mixId) throws javax.ejb.FinderException;
}
