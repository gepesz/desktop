package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: Genre
 */
public abstract class GenreBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String desc, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException {
		setId(id);
    setDesc(desc);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String desc, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException {
	  setUser(anUser);  
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
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getMusicFile();
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setMusicFile(java.util.Collection aMusicFile);
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getMixes();
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setMixes(java.util.Collection aMixes);
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
}
