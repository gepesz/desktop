package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Skin
 */
public interface Skin extends javax.ejb.EJBLocalObject {
  /**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: fileName
	 */
	public java.lang.String getFileName();
	/**
	 * Set accessor for persistent attribute: fileName
	 */
	public void setFileName(java.lang.String newFileName);
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getUser();
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setUser(java.util.Collection anUser);
}
