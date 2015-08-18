package com.vh.locker.ejb;
/**
 * Local Home interface for Enterprise Bean: MusicFile
 */
public interface MusicFileHome extends javax.ejb.EJBLocalHome {
	
  /**
	 * Creates an instance from a key for Entity Bean: MusicFile
	 */
	public com.vh.locker.ejb.MusicFile create(java.lang.Long id,
                                     com.vh.locker.ejb.Artist anArtist,
                                     java.lang.String songTitle,
                                     com.vh.locker.ejb.Album anAlbum,
                                     long length,
                                     java.util.Date dateCreated,
                                     java.lang.String link,
                                     long nofPlayed,
                                     com.vh.locker.ejb.Genre aGenre,
                                     com.vh.locker.ejb.FileType aFileType,
                                     com.vh.locker.ejb.User anUser) throws javax.ejb.CreateException;
	
    
  /**
	 * Finds an instance using a key for Entity Bean: MusicFile
	 */
	public com.vh.locker.ejb.MusicFile findByPrimaryKey(java.lang.Long primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.Long userId) throws javax.ejb.FinderException;
	public java.util.Collection findByAlbum(java.lang.Long albumId) throws javax.ejb.FinderException;
	public java.util.Collection findByArtist(java.lang.Long artistId) throws javax.ejb.FinderException;
	public java.util.Collection findByGenre(java.lang.Long genreId) throws javax.ejb.FinderException;
	public java.util.Collection findMostRecent(java.lang.Long userId)
		throws javax.ejb.FinderException;
	public java.util.Collection findByMix(java.lang.Long mixId)
		throws javax.ejb.FinderException;
}
