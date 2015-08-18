package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: FileType
 */
public interface FileTypeHome extends javax.ejb.EJBLocalHome {
	
    /**
	 * Creates an instance from a key for Entity Bean: FileType
	 */
	public com.vh.locker.ejb.FileType create(java.lang.Long id, java.lang.String desc) throws javax.ejb.CreateException;
	
    
    /**
	 * Finds an instance using a key for Entity Bean: FileType
	 */
	public com.vh.locker.ejb.FileType findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findAll() throws javax.ejb.FinderException;
	public com.vh.locker.ejb.FileType findByDesc(java.lang.String desc) throws javax.ejb.FinderException;
}
