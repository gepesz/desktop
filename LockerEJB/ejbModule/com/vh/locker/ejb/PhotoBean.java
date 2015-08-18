package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: Photo
 */
public abstract class PhotoBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String desc, java.lang.String link, com.vh.locker.ejb.User anUser)
		throws javax.ejb.CreateException {
    setId(id);
    setDesc(desc);
    setLink(link);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String desc, java.lang.String link, com.vh.locker.ejb.User anUser)
		throws javax.ejb.CreateException {
    setUser(anUser);
  }
    
    public boolean update(java.lang.String desc, java.lang.String link) {
      try {
        if((desc!=null) && (!desc.equals(getDesc()))) setDesc(desc);
        if((link!=null) && (!link.equals(getLink()))) setLink(link);
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
	 * Get accessor for persistent attribute: id
	 */
	public abstract java.lang.Long getId();
	/**
	 * Set accessor for persistent attribute: id
	 */
	public abstract void setId(java.lang.Long newId);
	/**
	 * Get accessor for persistent attribute: desc
	 */
	public abstract java.lang.String getDesc();
	/**
	 * Set accessor for persistent attribute: desc
	 */
	public abstract void setDesc(java.lang.String newDesc);
	/**
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getRelPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setRelPhotoAlbum(java.util.Collection aRelPhotoAlbum);
	/**
	 * Get accessor for persistent attribute: link
	 */
	public abstract java.lang.String getLink();
	/**
	 * Set accessor for persistent attribute: link
	 */
	public abstract void setLink(java.lang.String newLink);
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.User getUser();
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setUser(com.vh.locker.ejb.User anUser);
	/**
	 * ejbCreate
	 */
	public java.lang.Long ejbCreate(java.lang.Long id)
		throws javax.ejb.CreateException {
		setId(id);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id)
		throws javax.ejb.CreateException {
	}
	/**
	 * This method was generated for supporting the relationship role named userWithThisAsWallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getUserWithThisAsWallpaper();
	/**
	 * This method was generated for supporting the relationship role named userWithThisAsWallpaper.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setUserWithThisAsWallpaper(
		java.util.Collection anUserWithThisAsWallpaper);
}
