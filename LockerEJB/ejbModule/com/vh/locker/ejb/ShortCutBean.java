package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: ShortCut
 */
public abstract class ShortCutBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String desc, java.lang.String icon, int xCoord, int yCoord, com.vh.locker.ejb.Application anApplication, com.vh.locker.ejb.User aUser) throws javax.ejb.CreateException {
		setId(id);
		setDesc(desc);
        setIcon(icon);
        setXCoord(xCoord);
        setYCoord(yCoord);
        return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String desc, java.lang.String icon, int xCoord, int yCoord, com.vh.locker.ejb.Application anApplication, com.vh.locker.ejb.User aUser)
		throws javax.ejb.CreateException {
        setApplication(anApplication);
	    setUser(aUser);
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
	 * Get accessor for persistent attribute: icon
	 */
	public abstract java.lang.String getIcon();
	/**
	 * Set accessor for persistent attribute: icon
	 */
	public abstract void setIcon(java.lang.String newIcon);
	/**
	 * Get accessor for persistent attribute: xCoord
	 */
	public abstract int getXCoord();
	/**
	 * Set accessor for persistent attribute: xCoord
	 */
	public abstract void setXCoord(int newXCoord);
	/**
	 * Get accessor for persistent attribute: yCoord
	 */
	public abstract int getYCoord();
	/**
	 * Set accessor for persistent attribute: yCoord
	 */
	public abstract void setYCoord(int newYCoord);
	/**
	 * This method was generated for supporting the relationship role named application.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Application getApplication();
	/**
	 * This method was generated for supporting the relationship role named application.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setApplication(
		com.vh.locker.ejb.Application anApplication);
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
