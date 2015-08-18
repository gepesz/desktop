package com.vh.locker.ejb;
/**
 * Bean implementation class for Enterprise Bean: MusicFile
 */
public abstract class MusicFileBean implements javax.ejb.EntityBean {
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
	public java.lang.Long ejbCreate(java.lang.Long id,
                                  com.vh.locker.ejb.Artist anArtist,
                                  java.lang.String songTitle,
                                  com.vh.locker.ejb.Album anAlbum,
                                  long length,
                                  java.util.Date dateCreated,
                                  java.lang.String link,
                                  long nofPlayed,
                                  com.vh.locker.ejb.Genre aGenre,
                                  com.vh.locker.ejb.FileType aFileType,
                                  com.vh.locker.ejb.User anUser)
                                  throws javax.ejb.CreateException {
		setId(id);
    setSongTitle(songTitle);
    setLength(length);
    setDateCreated(dateCreated);
    setLink(link);
    setNofPlayed(nofPlayed);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Long id,
                            com.vh.locker.ejb.Artist anArtist,
                            java.lang.String songTitle,
                            com.vh.locker.ejb.Album anAlbum,
                            long length,
                            java.util.Date dateCreated,
                            java.lang.String link,
                            long nofPlayed,
                            com.vh.locker.ejb.Genre aGenre,
                            com.vh.locker.ejb.FileType aFileType,
                            com.vh.locker.ejb.User anUser)
		                        throws javax.ejb.CreateException {
    setArtist(anArtist);
    setAlbum(anAlbum);
    setGenre(aGenre);
    setFileType(aFileType);
    setUser(anUser);
	}
    
  public boolean update(com.vh.locker.ejb.Artist anArtist,
                        java.lang.String songTitle,
                        com.vh.locker.ejb.Album anAlbum,
                        com.vh.locker.ejb.Genre aGenre) {
    try {
      if((anArtist!=null)   && (!anArtist.equals(getArtist())))     setArtist(anArtist);
      if((songTitle!=null)  && (!songTitle.equals(getSongTitle()))) setSongTitle(songTitle);
      if((anAlbum!=null)    && (!anAlbum.equals(getAlbum())))       setAlbum(anAlbum);
      if((aGenre!=null)     && (!aGenre.equals(getGenre())))        setGenre(aGenre);
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
	 * Get accessor for persistent attribute: songTitle
	 */
	public abstract java.lang.String getSongTitle();
	/**
	 * Set accessor for persistent attribute: songTitle
	 */
	public abstract void setSongTitle(java.lang.String newSongTitle);
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
	 * Get accessor for persistent attribute: link
	 */
	public abstract java.lang.String getLink();
	/**
	 * Set accessor for persistent attribute: link
	 */
	public abstract void setLink(java.lang.String newLink);
	/**
	 * Get accessor for persistent attribute: nofPlayed
	 */
	public abstract long getNofPlayed();
	/**
	 * Set accessor for persistent attribute: nofPlayed
	 */
	public abstract void setNofPlayed(long newNofPlayed);
	/**
	 * This method was generated for supporting the relationship role named fileType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.FileType getFileType();
	/**
	 * This method was generated for supporting the relationship role named fileType.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setFileType(com.vh.locker.ejb.FileType aFileType);
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
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Album getAlbum();
	/**
	 * This method was generated for supporting the relationship role named album.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setAlbum(com.vh.locker.ejb.Album anAlbum);
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.vh.locker.ejb.Artist getArtist();
	/**
	 * This method was generated for supporting the relationship role named artist.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setArtist(com.vh.locker.ejb.Artist anArtist);
}
