package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: SecretQuestion
 */
public interface SecretQuestionHome extends javax.ejb.EJBLocalHome {
	
    /**
	 * Creates an instance from a key for Entity Bean: SecretQuestion
	 */
	public com.vh.locker.ejb.SecretQuestion create(java.lang.Long id, java.lang.String desc) throws javax.ejb.CreateException;
	
    
    /**
	 * Finds an instance using a key for Entity Bean: SecretQuestion
	 */
	public com.vh.locker.ejb.SecretQuestion findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;
}
