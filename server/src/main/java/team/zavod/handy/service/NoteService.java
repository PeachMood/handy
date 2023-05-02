package team.zavod.handy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.zavod.handy.model.entity.note.NoteEntity;
import team.zavod.handy.model.entity.note.NoteState;
import team.zavod.handy.model.entity.user.UserEntity;
import team.zavod.handy.repository.NoteRepository;

/**
 * <p>Implements complex logic related to notes.</p>
 */
@Service
public class NoteService {
  private final NoteRepository noteRepository;    // Instance of NoteRepository

  /**
   * <p>Constructs new instance of <code>NoteService</code> class.</p>
   *
   * @param noteRepository Instance of NoteRepository.
   */
  @Autowired
  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  /**
   * <p>Creates new note with the specified data.</p>
   *
   * @param note Note to be created.
   * @return <code>true</code> if NoteRepository was changed as a result of this call,
   * or <code>false</code> otherwise.
   */
  @Transactional
  public boolean createNote(NoteEntity note) {
    if(isUserNoteExists(note.getUser(), note.getName())) {
      return false;
    }
    note.setState(NoteState.ACTIVE);
    this.noteRepository.save(note);
    return true;
  }

  /**
   * <p>Finds note by id.</p>
   *
   * @param id Note id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return Note with the specified id if such note exists,
   * or <code>null</code> otherwise.
   */
  public <T> T findNote(Long id, Class<T> type) {
    return this.noteRepository.findById(id, type)
        .orElse(null);
  }

  /**
   * <p>Gets <code>List</code> of all notes.</p>
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes.
   */
  public <T> List<T> findAllNotes(Class<T> type) {
    return this.noteRepository.findAllProjectedBy(type);
  }

  /**
   * <p>Checks weather note with the specified name exists.</p>
   *
   * @param user User whose note will be checked.
   * @param name Note name to be checked.
   * @return <code>true</code> if note with such name exists,
   * or <code>false</code> otherwise.
   */
  public boolean isUserNoteExists(UserEntity user, String name) {
    return this.noteRepository.existsByUserAndName(user, name);
  }

  /**
   * <p>Finds note by name.</p>
   *
   * @param user User whose note will be found.
   * @param name Note name to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return Note with the specified name if such note exists,
   * or <code>null</code> otherwise.
   */
  public <T> T findUserNote(UserEntity user, String name, Class<T> type) {
    return this.noteRepository.findByUserAndName(user, name, type)
        .orElse(null);
  }

  /**
   * <p>Gets <code>List</code> of all notes for the specified user.</p>
   *
   * @param user User whose notes will be returned.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes for the specified user.
   */
  public <T> List<T> FindAllUserNotes(UserEntity user, Class<T> type) {
    return this.noteRepository.findAllByUser(user, type);
  }

  /**
   * <p>Gets <code>List</code> of all notes for the specified user and state.</p>
   *
   * @param user User whose notes will be returned.
   * @param state Note state to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all notes for the specified user and state.
   */
  public <T> List<T> findAllUserNotesWithState(UserEntity user, NoteState state, Class<T> type) {
    return this.noteRepository.findAllByUserAndState(user, state, type);
  }

  /**
   * <p>Updates note with the specified data.</p>
   *
   * @param with Note to be updated.
   * @return <code>true</code> if NoteRepository was changed as a result of this call,
   * or <code>false</code> otherwise.
   */
  @Transactional
  public boolean updateNote(NoteEntity with) {
    NoteEntity current = findNote(with.getId(), NoteEntity.class);
    if(Objects.isNull(current)) {
      return false;
    }
    with.setUser(current.getUser());
    with.setContent(current.getContent());
    with.setCreationDate(current.getCreationDate());
    with.setModificationDate(LocalDateTime.now());
    with.setTrashedDate(current.getTrashedDate());
    with.setState(current.getState());
    if(!with.getName().equals(current.getName()) && isUserNoteExists(with.getUser(), with.getName())) {
      return false;
    }
    this.noteRepository.save(with);
    return true;
  }

  /**
   * <p>Deletes note by id.</p>
   *
   * @param id Note id to be deleted.
   * @return <code>true</code> if NoteRepository was changed as a result of this call,
   * or <code>false</code> otherwise.
   */
  @Transactional
  public boolean deleteNote(Long id) {
    if(Objects.isNull(findNote(id, NoteEntity.class))) {
      return false;
    }
    this.noteRepository.deleteById(id);
    return true;
  }
}
