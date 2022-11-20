package io.gitlab.zavod.handy.server.storage.entity.note;

/**
 * <p>Represents current note state.</p>
 */
public enum NoteState {
  TRASHED,    // In trash, but not deleted
  DELETED,    // Permanently deleted
  ACTIVE    // Currently exist
}
