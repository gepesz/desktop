package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Contact
 */
public interface Contact extends javax.ejb.EJBLocalObject {

  public boolean update(java.lang.String name,
                        java.lang.String nickName, 
                        java.lang.String phone, 
                        java.lang.String email);

  /**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: nickName
	 */
	public java.lang.String getNickName();
	/**
	 * Set accessor for persistent attribute: nickName
	 */
	public void setNickName(java.lang.String newNickName);
	/**
	 * Get accessor for persistent attribute: phone
	 */
	public java.lang.String getPhone();
	/**
	 * Set accessor for persistent attribute: phone
	 */
	public void setPhone(java.lang.String newPhone);
	/**
	 * Get accessor for persistent attribute: email
	 */
	public java.lang.String getEmail();
	/**
	 * Set accessor for persistent attribute: email
	 */
	public void setEmail(java.lang.String newEmail);
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
}
