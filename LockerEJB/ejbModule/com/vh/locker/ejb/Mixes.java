package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: Mixes
 */
public interface Mixes extends javax.ejb.EJBLocalObject {

  public boolean update(java.lang.String title,
                        long length,
                        com.vh.locker.ejb.Genre aGenre);

	/**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
  /**
	 * Get accessor for persistent attribute: title
	 */
	public java.lang.String getTitle();
	/**
	 * Set accessor for persistent attribute: title
	 */
	public void setTitle(java.lang.String newTitle);
	/**
	 * Get accessor for persistent attribute: length
	 */
	public long getLength();
	/**
	 * Set accessor for persistent attribute: length
	 */
	public void setLength(long newLength);
	/**
	 * Get accessor for persistent attribute: dateCreated
	 */
	public java.util.Date getDateCreated();
	/**
	 * Set accessor for persistent attribute: dateCreated
	 */
	public void setDateCreated(java.util.Date newDateCreated);
	/**
	 * Get accessor for persistent attribute: nofPlayed
	 */
	public long getNofPlayed();
	/**
	 * Set accessor for persistent attribute: nofPlayed
	 */
	public void setNofPlayed(long newNofPlayed);
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Genre getGenre();
	/**
	 * This method was generated for supporting the relationship role named genre.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setGenre(com.vh.locker.ejb.Genre aGenre);
	/**
	 * This method was generated for supporting the relationship role named relMusicMixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getRelMusicMixes();
	/**
	 * This method was generated for supporting the relationship role named relMusicMixes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setRelMusicMixes(java.util.Collection aRelMusicMixes);
}
