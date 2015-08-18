package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: RelMusicMixes
 */
public interface RelMusicMixes extends javax.ejb.EJBLocalObject {

  public boolean update(long newOrderInMix);

  /**
   * Get accessor for persistent attribute: musicFileId
   */
  public abstract java.lang.Long getMusicFileId();
  /**
   * Get accessor for persistent attribute: mixesId
   */
  public abstract java.lang.Long getMixesId();
  /**
	 * Get accessor for persistent attribute: orderInMix
	 */
	public long getOrderInMix();
	/**
	 * Set accessor for persistent attribute: orderInMix
	 */
	public void setOrderInMix(long newOrderInMix);
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Mixes getMixes();
	/**
	 * This method was generated for supporting the relationship role named mixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setMixes(com.vh.locker.ejb.Mixes aMixes);
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.MusicFile getMusicFile();
	/**
	 * This method was generated for supporting the relationship role named musicFile.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setMusicFile(com.vh.locker.ejb.MusicFile aMusicFile);
}
