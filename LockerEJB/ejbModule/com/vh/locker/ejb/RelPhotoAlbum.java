package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: RelPhotoAlbum
 */
public interface RelPhotoAlbum extends javax.ejb.EJBLocalObject {

    public boolean update(long newOrderInAlbum);

	/**
	 * Get accessor for persistent attribute: orderInAlbum
	 */
	public long getOrderInAlbum();
	/**
	 * Set accessor for persistent attribute: orderInAlbum
	 */
	public void setOrderInAlbum(long newOrderInAlbum);
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Photo getPhoto();
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setPhoto(com.vh.locker.ejb.Photo aPhoto);
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.PhotoAlbum getPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setPhotoAlbum(com.vh.locker.ejb.PhotoAlbum aPhotoAlbum);
}
