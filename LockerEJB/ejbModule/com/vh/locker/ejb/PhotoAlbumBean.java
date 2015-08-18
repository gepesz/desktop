package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: PhotoAlbum
 */
public abstract class PhotoAlbumBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String title, java.lang.String desc, java.util.Date dateCreated, long nofVisits, com.vh.locker.ejb.User aUser)
		throws javax.ejb.CreateException {
		setId(id);
        setTitle(title);
        setDesc(desc);
        setDateCreated(dateCreated);
        setNofVisits(nofVisits);        
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String title, java.lang.String desc, java.util.Date dateCreated, long nofVisits, com.vh.locker.ejb.User aUser)
		throws javax.ejb.CreateException {
        setUser(aUser);
	}
    
    public boolean update(java.lang.String title, java.lang.String desc) {
      try {
        if((title!=null) && (!title.equals(getTitle()))) setTitle(title);
        if((desc!=null) && (!desc.equals(getDesc()))) setDesc(desc);
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
	 * Get accessor for persistent attribute: title
	 */
	public abstract java.lang.String getTitle();
	/**
	 * Set accessor for persistent attribute: title
	 */
	public abstract void setTitle(java.lang.String newTitle);
	/**
	 * Get accessor for persistent attribute: desc
	 */
	public abstract java.lang.String getDesc();
	/**
	 * Set accessor for persistent attribute: desc
	 */
	public abstract void setDesc(java.lang.String newDesc);
	/**
	 * Get accessor for persistent attribute: dateCreated
	 */
	public abstract java.util.Date getDateCreated();
	/**
	 * Set accessor for persistent attribute: dateCreated
	 */
	public abstract void setDateCreated(java.util.Date newDateCreated);
	/**
	 * Get accessor for persistent attribute: nofVisits
	 */
	public abstract long getNofVisits();
	/**
	 * Set accessor for persistent attribute: nofVisits
	 */
	public abstract void setNofVisits(long newNofVisits);
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
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getRelPhotoAlbum();
	/**
	 * This method was generated for supporting the relationship role named relPhotoAlbum.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setRelPhotoAlbum(java.util.Collection aRelPhotoAlbum);
}
