package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: Application
 */
public abstract class ApplicationBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String desc, java.lang.String defaultIcon, java.lang.String targetUrl)	throws javax.ejb.CreateException {
		setId(id);
		setDesc(desc);
        setDefaultIcon(defaultIcon);
        setTargetUrl(targetUrl);
        return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String desc, java.lang.String defaultIcon, java.lang.String targetUrl) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: defaultIcon
	 */
	public abstract java.lang.String getDefaultIcon();
	/**
	 * Set accessor for persistent attribute: defaultIcon
	 */
	public abstract void setDefaultIcon(java.lang.String newDefaultIcon);
	/**
	 * Get accessor for persistent attribute: targetUrl
	 */
	public abstract java.lang.String getTargetUrl();
	/**
	 * Set accessor for persistent attribute: targetUrl
	 */
	public abstract void setTargetUrl(java.lang.String newTargetUrl);
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getShortCut();
	/**
	 * This method was generated for supporting the relationship role named shortCut.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setShortCut(java.util.Collection aShortCut);
}
