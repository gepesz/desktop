package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: PhotoAlbum
 */
public interface PhotoAlbum extends javax.ejb.EJBLocalObject {

    public boolean update(java.lang.String title, java.lang.String desc);

    /**
     * Get accessor for persistent attribute: id
     */
    public abstract java.lang.Long getId();
	/**
	 * Get accessor for persistent attribute: title
	 */
	public java.lang.String getTitle();
	/**
	 * Set accessor for persistent attribute: title
	 */
	public void setTitle(java.lang.String newTitle);
	/**
	 * Get accessor for persistent attribute: desc
	 */
	public java.lang.String getDesc();
	/**
	 * Set accessor for persistent attribute: desc
	 */
	public void setDesc(java.lang.String newDesc);
	/**
	 * Get accessor for persistent attribute: dateCreated
	 */
	public java.util.Date getDateCreated();
	/**
	 * Set accessor for persistent attribute: dateCreated
	 */
	public void setDateCreated(java.util.Date newDateCreated);
	/**
	 * Get accessor for persistent attribute: nofVisits
	 */
	public long getNofVisits();
	/**
	 * Set accessor for persistent attribute: nofVisits
	 */
	public void setNofVisits(long newNofVisits);
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
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getRelPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setRelPhotoAlbum(java.util.Collection aRelPhotoAlbum);
}
