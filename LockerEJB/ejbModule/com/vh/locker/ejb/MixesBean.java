package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: Mixes
 */
public abstract class MixesBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id, java.lang.String title, long length, java.util.Date dateCreated, long nofPlayed, com.vh.locker.ejb.Genre aGenre) throws javax.ejb.CreateException {
		setId(id);
    setTitle(title);
    setLength(length);
    setDateCreated(dateCreated);
    setNofPlayed(nofPlayed);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id, java.lang.String title, long length, java.util.Date dateCreated, long nofPlayed, com.vh.locker.ejb.Genre aGenre) throws javax.ejb.CreateException {
	  setGenre(aGenre);
  }
    
  public boolean update(java.lang.String title, long length, com.vh.locker.ejb.Genre aGenre) {
    try {
      if((title!=null) &&  (!title.equals(getTitle())))  setTitle(title);
      if(length!=getLength())                            setLength(length);
      if((aGenre!=null) && (!aGenre.equals(getGenre()))) setGenre(aGenre);      
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
	 * Get accessor for persistent attribute: length
	 */
	public abstract long getLength();
	/**
	 * Set accessor for persistent attribute: length
	 */
	public abstract void setLength(long newLength);
	/**
	 * Get accessor for persistent attribute: dateCreated
	 */
	public abstract java.util.Date getDateCreated();
	/**
	 * Set accessor for persistent attribute: dateCreated
	 */
	public abstract void setDateCreated(java.util.Date newDateCreated);
	/**
	 * Get accessor for persistent attribute: nofPlayed
	 */
	public abstract long getNofPlayed();
	/**
	 * Set accessor for persistent attribute: nofPlayed
	 */
	public abstract void setNofPlayed(long newNofPlayed);
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Genre getGenre();
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setGenre(com.vh.locker.ejb.Genre aGenre);
	/**
	 * This method was generated for supporting the relationship role named relMusicMixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getRelMusicMixes();
	/**
	 * This method was generated for supporting the relationship role named relMusicMixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setRelMusicMixes(java.util.Collection aRelMusicMixes);
}
