package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Genre
 */
public interface Genre extends javax.ejb.EJBLocalObject {
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
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getMusicFile();
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setMusicFile(java.util.Collection aMusicFile);
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getMixes();
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setMixes(java.util.Collection aMixes);
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
