package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Photo
 */
public interface Photo extends javax.ejb.EJBLocalObject {

    public boolean update(java.lang.String desc, java.lang.String link);

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
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getRelPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setRelPhotoAlbum(java.util.Collection aRelPhotoAlbum);
	/**
	 * Get accessor for persistent attribute: link
	 */
	public java.lang.String getLink();
	/**
	 * Set accessor for persistent attribute: link
	 */
	public void setLink(java.lang.String newLink);
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
	/**
	 * This method was generated for supporting the relationship role named userWithThisAsWallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getUserWithThisAsWallpaper();
	/**
	 * This method was generated for supporting the relationship role named userWithThisAsWallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setUserWithThisAsWallpaper(
		java.util.Collection anUserWithThisAsWallpaper);
}
