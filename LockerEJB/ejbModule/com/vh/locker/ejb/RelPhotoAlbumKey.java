package com.vh.locker.ejb;
/**
 * Key class for Entity Bean: RelPhotoAlbum
 */
public class RelPhotoAlbumKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: photoId
	 */
	public java.lang.Long photoId;
	/**
	 * Implementation field for persistent attribute: albumId
	 */
	public java.lang.Long albumId;
	/**
	 * Creates an empty key for Entity Bean: RelPhotoAlbum
	 */
	public RelPhotoAlbumKey() {
	}
	/**
	 * Creates a key for Entity Bean: RelPhotoAlbum
	 */
	public RelPhotoAlbumKey(java.lang.Long photoId, java.lang.Long albumId) {
		this.photoId = photoId;
		this.albumId = albumId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.vh.locker.ejb.RelPhotoAlbumKey) {
			com.vh.locker.ejb.RelPhotoAlbumKey o =
				(com.vh.locker.ejb.RelPhotoAlbumKey) otherKey;
			return (
				(this.photoId.equals(o.photoId))
					&& (this.albumId.equals(o.albumId)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (photoId.hashCode() + albumId.hashCode());
	}
}
