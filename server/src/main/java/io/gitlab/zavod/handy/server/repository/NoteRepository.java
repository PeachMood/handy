package io.gitlab.zavod.handy.server.repository;

import io.gitlab.zavod.handy.server.entity.note.NoteEntity;
import io.gitlab.zavod.handy.server.entity.note.NoteState;
import io.gitlab.zavod.handy.server.entity.user.UserEntity;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Provides functionality to manage notes.</p>
 */
@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
  /**
   * <p>Creates new note with the specified data.</p>
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param creationDate Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate Date of permanent note deletion.
   * @param state Current note state.
   */
  void save(Long id,
      UserEntity user,
      String name,
      String content,
      LocalDateTime creationDate,
      LocalDateTime modificationDate,
      LocalDateTime trashedDate,
      NoteState state);

  /**
   * <p>Creates new note with the specified data.</p>
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param creationDate Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate Date of permanent note deletion.
   * @param state Current note state.
   */
  void save(Long id,
      UserEntity user,
      String name,
      Path content,
      LocalDateTime creationDate,
      LocalDateTime modificationDate,
      LocalDateTime trashedDate,
      NoteState state);

  /**
   * <p>Finds note by id.</p>
   *
   * @param id Note id to be found.
   * @return <code>Optional&lt;NoteEntity&gt;</code> with the specified id.
   */
  Optional<NoteEntity> findById(Long id);

  /**
   * <p>Gets <code>List</code> of all notes.</p>
   *
   * @return <code>List</code> of all notes.
   */
  List<NoteEntity> findAll();

  /**
   * <p>Gets <code>List</code> of all notes for the specified user.</p>
   *
   * @param user User whose notes will be returned.
   * @return <code>List</code> of all notes for the specified user.
   */
  List<NoteEntity> findAllByUser(UserEntity user);

  /**
   * <p>Finds note by name.</p>
   *
   * @param user User whose note will be found.
   * @param name Note name to be found.
   * @return <code>Optional&lt;NoteEntity&gt;</code> instance with the specified name.
   */
  Optional<NoteEntity> findByUserAndName(UserEntity user, String name);

  /**
   * <p>Gets <code>List</code> of all notes for the specified user and state.</p>
   *
   * @param user User whose notes will be returned.
   * @param state Note state to be found.
   * @return <code>List</code> of all notes for the specified user and state.
   */
  List<NoteEntity> findByUserAndState(UserEntity user, NoteState state);

  /**
   * <p>Deletes note by id.</p>
   *
   * @param id Note id to be deleted.
   */
  void deleteById(Long id);
}
