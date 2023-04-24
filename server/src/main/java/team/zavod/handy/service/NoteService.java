package team.zavod.handy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.zavod.handy.entity.note.Note;
import team.zavod.handy.entity.note.Operation;
import team.zavod.handy.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Implements complex logic related to notes.</p>
 */
@Service
public class NoteService {
  private final NoteRepository repository;    // Instance of repository

  /**
   * <p>Creates instance of <code>NoteService</code> class.</p>
   *
   * @param repository Instance of repository.
   */
  @Autowired
  public NoteService(NoteRepository repository) {
    this.repository = repository;
  }

  public List<Note> getAllNotes() {
    return repository.findAll();
  }

  public Note getNoteById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public void applyOperation(Operation operation) {
    Note note = operation.getNote();
    switch (operation.getType()) {
      case "insert" -> note.setContent(note.getContent().substring(0, operation.getPosition()) + operation.getValue() +
          note.getContent().substring(operation.getPosition()));
      case "delete" -> note.setContent(note.getContent().substring(0, operation.getPosition()) +
          note.getContent().substring(operation.getPosition() + operation.getValue().length()));
    }
    repository.save(note);
  }

  public void addOperationToNote(Operation operation) {
    Note note = operation.getNote();
    if (note.getOperations() == null) {
      note.setOperations(new ArrayList<>());
    }
    note.getOperations().add(operation);
    repository.save(note);
  }

  public void saveNote(Note note) {
    repository.save(note);
  }

  public void deleteNoteById(Long id) {
    repository.deleteById(id);
  }
}
