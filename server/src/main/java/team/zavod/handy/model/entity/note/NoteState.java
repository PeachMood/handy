package team.zavod.handy.model.entity.note;

/** Represents current note state. */
public enum NoteState {
  TRASHED, // In trash, but not deleted
  DELETED, // Permanently deleted
  ACTIVE // Currently exist
}
