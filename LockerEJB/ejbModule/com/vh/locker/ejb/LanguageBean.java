package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: Language
 */
public abstract class LanguageBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String loc, java.lang.String flag) throws javax.ejb.CreateException {
		setId(id);
		setLoc(loc);
    setFlag(flag);
    return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String loc, java.lang.String flag) throws javax.ejb.CreateException {
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
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getUser();
	/**
	 * This method was generated for supporting the relationship role named user.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setUser(java.util.Collection anUser);
	/**
	 * Get accessor for persistent attribute: loc
	 */
	public abstract java.lang.String getLoc();
	/**
	 * Set accessor for persistent attribute: loc
	 */
	public abstract void setLoc(java.lang.String newLoc);
	/**
	 * Get accessor for persistent attribute: flag
	 */
	public abstract java.lang.String getFlag();
	/**
	 * Set accessor for persistent attribute: flag
	 */
	public abstract void setFlag(java.lang.String newFlag);
}
