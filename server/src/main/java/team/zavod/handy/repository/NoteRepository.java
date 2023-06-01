package team.zavod.handy.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.model.entity.note.Note;
import team.zavod.handy.model.entity.note.NoteState;
import team.zavod.handy.model.entity.user.UserEntity;

/** Provides functionality to manage notes. */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  /**
   * Creates new note with the specified data.
   *
   * @param note Note to be saved.
   */
  @SuppressWarnings("unchecked")
  Note save(Note note);

  /**
   * Finds note by id.
   *
   * @param id Note id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * Gets <code>List</code> of all notes.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * Checks weather note with the specified name exists.
   *
   * @param user User whose note will be checked.
   * @param name Note name to be checked.
   * @return <code>true</code> if note with such name exists, or <code>false</code> otherwise.
   */
  boolean existsByUserAndName(UserEntity user, String name);

  /**
   * Finds note by id.
   *
   * @param user User whose note will be found.
   * @param id Note id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified name.
   */
  <T> Optional<T> findByUserAndId(UserEntity user, Long id, Class<T> type);

  /**
   * Gets <code>List</code> of all notes for the specified user.
   *
   * @param user User whose notes will be returned.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes for the specified user.
   */
  <T> List<T> findAllByUser(UserEntity user, Class<T> type);

  /**
   * Gets <code>List</code> of all notes for the specified user and state.
   *
   * @param user User whose notes will be returned.
   * @param state Note state to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes for the specified user and state.
   */
  <T> List<T> findAllByUserAndState(UserEntity user, NoteState state, Class<T> type);

  /**
   * Deletes note by id.
   *
   * @param id Note id to be deleted.
   */
  void deleteById(Long id);
}
