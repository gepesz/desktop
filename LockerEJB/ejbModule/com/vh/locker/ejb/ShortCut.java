package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: ShortCut
 */
public interface ShortCut extends javax.ejb.EJBLocalObject {
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
	 * Get accessor for persistent attribute: icon
	 */
	public java.lang.String getIcon();
	/**
	 * Set accessor for persistent attribute: icon
	 */
	public void setIcon(java.lang.String newIcon);
	/**
	 * Get accessor for persistent attribute: xCoord
	 */
	public int getXCoord();
	/**
	 * Set accessor for persistent attribute: xCoord
	 */
	public void setXCoord(int newXCoord);
	/**
	 * Get accessor for persistent attribute: yCoord
	 */
	public int getYCoord();
	/**
	 * Set accessor for persistent attribute: yCoord
	 */
	public void setYCoord(int newYCoord);
	/**
	 * This method was generated for supporting the relationship role named application.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Application getApplication();
	/**
	 * This method was generated for supporting the relationship role named application.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setApplication(com.vh.locker.ejb.Application anApplication);
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.User getUser();
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setUser(com.vh.locker.ejb.User anUser);
}
