package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: Contact
 */
public abstract class ContactBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String name, java.lang.String nickName, java.lang.String phone, java.lang.String email, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException {
		setId(id);
    setName(name);
    setNickName(nickName);
    setPhone(phone);
    setEmail(email);    
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String name, java.lang.String nickName, java.lang.String phone, java.lang.String email, com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException {
	  setUser(anUser);
  }
  
  public boolean update(java.lang.String name,
                        java.lang.String nickName, 
                        java.lang.String phone, 
                        java.lang.String email) {
    try {
      if((name!=null)     && (!name.equals(getName())))         setName(name);
      if((nickName!=null) && (!nickName.equals(getNickName()))) setNickName(nickName);
      if((phone!=null)    && (!phone.equals(getPhone())))       setPhone(phone);
      if((email!=null)    && (!email.equals(getEmail())))       setEmail(email);
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
	 * Get accessor for persistent attribute: name
	 */
	public abstract java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public abstract void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: nickName
	 */
	public abstract java.lang.String getNickName();
	/**
	 * Set accessor for persistent attribute: nickName
	 */
	public abstract void setNickName(java.lang.String newNickName);
	/**
	 * Get accessor for persistent attribute: phone
	 */
	public abstract java.lang.String getPhone();
	/**
	 * Set accessor for persistent attribute: phone
	 */
	public abstract void setPhone(java.lang.String newPhone);
	/**
	 * Get accessor for persistent attribute: email
	 */
	public abstract java.lang.String getEmail();
	/**
	 * Set accessor for persistent attribute: email
	 */
	public abstract void setEmail(java.lang.String newEmail);
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
