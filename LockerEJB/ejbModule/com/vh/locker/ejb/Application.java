package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Application
 */
public interface Application extends javax.ejb.EJBLocalObject {
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
	 * Get accessor for persistent attribute: defaultIcon
	 */
	public java.lang.String getDefaultIcon();
	/**
	 * Set accessor for persistent attribute: defaultIcon
	 */
	public void setDefaultIcon(java.lang.String newDefaultIcon);
	/**
	 * Get accessor for persistent attribute: targetUrl
	 */
	public java.lang.String getTargetUrl();
	/**
	 * Set accessor for persistent attribute: targetUrl
	 */
	public void setTargetUrl(java.lang.String newTargetUrl);
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getShortCut();
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setShortCut(java.util.Collection aShortCut);
}
