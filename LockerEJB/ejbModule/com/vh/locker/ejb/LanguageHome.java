package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: Language
 */
public interface LanguageHome extends javax.ejb.EJBLocalHome {
	
    /**
	 * Creates an instance from a key for Entity Bean: Language
	 */
	public com.vh.locker.ejb.Language create(java.lang.Long id, java.lang.String loc, java.lang.String flag) throws javax.ejb.CreateException;
	
    
    /**
	 * Finds an instance using a key for Entity Bean: Language
	 */
	public com.vh.locker.ejb.Language findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;
}
