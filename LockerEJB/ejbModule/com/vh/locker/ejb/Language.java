package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Language
 */
public interface Language extends javax.ejb.EJBLocalObject {
	/**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
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
	/**
	 * Get accessor for persistent attribute: loc
	 */
	public java.lang.String getLoc();
	/**
	 * Set accessor for persistent attribute: loc
	 */
	public void setLoc(java.lang.String newLoc);
	/**
	 * Get accessor for persistent attribute: flag
	 */
	public java.lang.String getFlag();
	/**
	 * Set accessor for persistent attribute: flag
	 */
	public void setFlag(java.lang.String newFlag);
}
