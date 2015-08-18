package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: SecretQuestion
 */
public interface SecretQuestion extends javax.ejb.EJBLocalObject {
	/**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
  /**
	 * Get accessor for persistent attribute: desc
	 */
	public java.lang.String getDesc();
	/**
	 * Set accessor for persistent attribute: desc
	 */
	public void setDesc(java.lang.String newDesc);
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
