package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: RelPhotoAlbum
 */
public abstract class RelPhotoAlbumBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.vh.locker.ejb.RelPhotoAlbumKey ejbCreate(java.lang.Long photoId, java.lang.Long albumId, long orderInAlbum) throws javax.ejb.CreateException {
		setPhotoId(photoId);
		setAlbumId(albumId);
        setOrderInAlbum(orderInAlbum);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long photoId, java.lang.Long albumId, long orderInAlbum)
		throws javax.ejb.CreateException {
	}
    
    public boolean update(long newOrderInAlbum) {
      try {
        if(newOrderInAlbum!=getOrderInAlbum()) setOrderInAlbum(newOrderInAlbum);
      } catch(Exception e) {
        e.printStackTrace();
        return false;
      }
      return true;                  
    }

    
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: photoId
	 */
	public abstract java.lang.Long getPhotoId();
	/**
	 * Set accessor for persistent attribute: photoId
	 */
	public abstract void setPhotoId(java.lang.Long newPhotoId);
	/**
	 * Get accessor for persistent attribute: albumId
	 */
	public abstract java.lang.Long getAlbumId();
	/**
	 * Set accessor for persistent attribute: albumId
	 */
	public abstract void setAlbumId(java.lang.Long newAlbumId);
	/**
	 * Get accessor for persistent attribute: orderInAlbum
	 */
	public abstract long getOrderInAlbum();
	/**
	 * Set accessor for persistent attribute: orderInAlbum
	 */
	public abstract void setOrderInAlbum(long newOrderInAlbum);
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Photo getPhoto();
	/**
	 * This method was generated for supporting the relationship role named photo.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setPhoto(com.vh.locker.ejb.Photo aPhoto);
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.PhotoAlbum getPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named photoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setPhotoAlbum(
		com.vh.locker.ejb.PhotoAlbum aPhotoAlbum);
}
