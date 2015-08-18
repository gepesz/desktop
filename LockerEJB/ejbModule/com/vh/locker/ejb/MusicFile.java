package com.vh.locker.ejb;
/**
 * Local interface for Enterprise Bean: MusicFile
 */
public interface MusicFile extends javax.ejb.EJBLocalObject {

  public boolean update(com.vh.locker.ejb.Artist anArtist,
                        java.lang.String songTitle,
                        com.vh.locker.ejb.Album anAlbum,
                        com.vh.locker.ejb.Genre aGenre);


	/**
   * Get accessor for persistent attribute: id
   */
  public abstract java.lang.Long getId();
	/**
	 * Get accessor for persistent attribute: songTitle
	 */
	public java.lang.String getSongTitle();
	/**
	 * Set accessor for persistent attribute: songTitle
	 */
	public void setSongTitle(java.lang.String newSongTitle);
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
	 * Get accessor for persistent attribute: link
	 */
	public java.lang.String getLink();
	/**
	 * Set accessor for persistent attribute: link
	 */
	public void setLink(java.lang.String newLink);
	/**
	 * Get accessor for persistent attribute: nofPlayed
	 */
	public long getNofPlayed();
	/**
	 * Set accessor for persistent attribute: nofPlayed
	 */
	public void setNofPlayed(long newNofPlayed);
	/**
	 * This method was generated for supporting the relationship role named fileType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.FileType getFileType();
	/**
	 * This method was generated for supporting the relationship role named fileType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setFileType(com.vh.locker.ejb.FileType aFileType);
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
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Album getAlbum();
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setAlbum(com.vh.locker.ejb.Album anAlbum);
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.vh.locker.ejb.Artist getArtist();
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setArtist(com.vh.locker.ejb.Artist anArtist);
}
