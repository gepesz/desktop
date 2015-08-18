package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: RelMusicMixes
 */
public abstract class RelMusicMixesBean implements javax.ejb.EntityBean {
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
	public com.vh.locker.ejb.RelMusicMixesKey ejbCreate(java.lang.Long musicFileId, java.lang.Long mixesId, long orderInMix) throws javax.ejb.CreateException {
		setMusicFileId(musicFileId);
		setMixesId(mixesId);
		setOrderInMix(orderInMix);
    return null;
	}
    
  public boolean update(long newOrderInMix) {
    try {
      if(newOrderInMix!=getOrderInMix()) setOrderInMix(newOrderInMix);
    } catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;                  
  }
    
    
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long musicFileId, java.lang.Long mixesId, long orderInMix) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: musicFileId
	 */
	public abstract java.lang.Long getMusicFileId();
	/**
	 * Set accessor for persistent attribute: musicFileId
	 */
	public abstract void setMusicFileId(java.lang.Long newMusicFileId);
	/**
	 * Get accessor for persistent attribute: mixesId
	 */
	public abstract java.lang.Long getMixesId();
	/**
	 * Set accessor for persistent attribute: mixesId
	 */
	public abstract void setMixesId(java.lang.Long newMixesId);
	/**
	 * Get accessor for persistent attribute: orderInMix
	 */
	public abstract long getOrderInMix();
	/**
	 * Set accessor for persistent attribute: orderInMix
	 */
	public abstract void setOrderInMix(long newOrderInMix);
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Mixes getMixes();
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setMixes(com.vh.locker.ejb.Mixes aMixes);
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.MusicFile getMusicFile();
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setMusicFile(com.vh.locker.ejb.MusicFile aMusicFile);
}
