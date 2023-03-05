package team.zavod.handy.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.entity.note.NoteEntity;
import team.zavod.handy.entity.note.NoteState;
import team.zavod.handy.entity.user.UserEntity;

/**
 * <p>Provides functionality to manage notes.</p>
 */
@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
  /**
   * <p>Creates new note with the specified data.</p>
   *
   * @param note Note to be saved.
   */
  @SuppressWarnings("unchecked")
  NoteEntity save(NoteEntity note);

  /**
   * <p>Finds note by id.</p>
   *
   * @param id Note id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * <p>Gets <code>List</code> of all notes.</p>
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * <p>Checks weather note with the specified name exists.</p>
   *
   * @param user User whose note will be checked.
   * @param name Note name to be checked.
   * @return <code>true</code> if note with such name exists,
   * or <code>false</code> otherwise.
   */
  boolean existsByUserAndName(UserEntity user, String name);

  /**
   * <p>Finds note by name.</p>
   *
   * @param user User whose note will be found.
   * @param name Note name to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified name.
   */
  <T> Optional<T> findByUserAndName(UserEntity user, String name, Class<T> type);

  /**
   * <p>Gets <code>List</code> of all notes for the specified user.</p>
   *
   * @param user User whose notes will be returned.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes for the specified user.
   */
  <T> List<T> findAllByUser(UserEntity user, Class<T> type);

  /**
   * <p>Gets <code>List</code> of all notes for the specified user and state.</p>
   *
   * @param user User whose notes will be returned.
   * @param state Note state to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes for the specified user and state.
   */
  <T> List<T> findAllByUserAndState(UserEntity user, NoteState state, Class<T> type);

  /**
   * <p>Deletes note by id.</p>
   *
   * @param id Note id to be deleted.
   */
  void deleteById(Long id);
}
