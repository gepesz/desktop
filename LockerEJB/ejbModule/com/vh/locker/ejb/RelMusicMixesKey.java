package com.vh.locker.ejb;
/**
 * Key class for Entity Bean: RelMusicMixes
 */
public class RelMusicMixesKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: musicFileId
	 */
	public java.lang.Long musicFileId;
	/**
	 * Implementation field for persistent attribute: mixesId
	 */
	public java.lang.Long mixesId;
	/**
	 * Creates an empty key for Entity Bean: RelMusicMixes
	 */
	public RelMusicMixesKey() {
	}
	/**
	 * Creates a key for Entity Bean: RelMusicMixes
	 */
	public RelMusicMixesKey(
		java.lang.Long musicFileId,
		java.lang.Long mixesId) {
		this.musicFileId = musicFileId;
		this.mixesId = mixesId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.vh.locker.ejb.RelMusicMixesKey) {
			com.vh.locker.ejb.RelMusicMixesKey o =
				(com.vh.locker.ejb.RelMusicMixesKey) otherKey;
			return (
				(this.musicFileId.equals(o.musicFileId))
					&& (this.mixesId.equals(o.mixesId)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (musicFileId.hashCode() + mixesId.hashCode());
	}
}
