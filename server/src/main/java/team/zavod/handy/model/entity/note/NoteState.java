package team.zavod.handy.model.entity.note;

/**
 * <p>Represents current note state.</p>
 */
public enum NoteState {
  TRASHED,    // In trash, but not deleted
  DELETED,    // Permanently deleted
  ACTIVE    // Currently exist
}
