package io.gitlab.zavod.handy.server.storage.collection;

import io.gitlab.zavod.handy.server.storage.entity.user.UserEntity;
import io.gitlab.zavod.handy.server.storage.entity.note.NoteEntity;
import io.gitlab.zavod.handy.server.storage.entity.note.NoteState;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>Provides functionality to manage notes.</p>
 */
public interface NoteCollection {
  /**
   * <p>Creates new note with the specified data.</p>
   *
   * @param id               Unique note identifier.
   * @param userEntity       Instance of UserEntity.
   * @param name             Note name.
   * @param content          Path to note content.
   * @param creationDate     Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate      Date of permanent note deletion.
   * @param state            Current note state.
   */
  void createNote(int id, UserEntity userEntity, String name, Path content, LocalDateTime creationDate, LocalDateTime modificationDate, LocalDateTime trashedDate, NoteState state);

  /**
   * <p>Finds note by id.</p>
   *
   * @param id Note id to be found.
   * @return <code>NoteEntity</code> with the specified id, or <code>null</code> if such note doesn't exist.
   */
  NoteEntity findNote(int id);

  /**
   * <p>Gets <code>List</code> of all notes.</p>
   *
   * @return <code>List</code> of all notes.
   */
  List<NoteEntity> findAllNotes();

  /**
   * <p>Gets <code>List</code> of all notes for the specified user.</p>
   *
   * @param userEntity User whose notes will be returned.
   * @return <code>List</code> of all notes for the specified user.
   */
  List<NoteEntity> findAllUserNotes(UserEntity userEntity);

  /**
   * <p>Finds note by name.</p>
   *
   * @param userEntity User whose note will be found.
   * @param name       Note name to be found.
   * @return <code>NoteEntity</code> instance with the specified name, or <code>null</code> if such note doesn't exist.
   */
  NoteEntity findNoteByName(UserEntity userEntity, String name);

  /**
   * <p>Gets <code>List</code> of all notes for the specified user and state.</p>
   *
   * @param userEntity User whose notes will be returned.
   * @param state      Note state to be found.
   * @return <code>List</code> of all notes for the specified user and state.
   */
  List<NoteEntity> findNotesByState(UserEntity userEntity, NoteState state);

  /**
   * <p>Updates note data. If the specified note doesn't exist, new note will be created.</p>
   *
   * @param noteEntity <code>NoteEntity</code> instance to be updated.
   * @return <code>true</code> if note data changed as a result of this call, or <code>false</code> otherwise.
   */
  boolean updateNote(NoteEntity noteEntity);

  /**
   * <p>Deletes note by id.</p>
   *
   * @param id Note id to be deleted.
   * @return <code>true</code> if note collection changed as a result of this call, or <code>false</code> otherwise.
   */
  boolean deleteNote(int id);
}
