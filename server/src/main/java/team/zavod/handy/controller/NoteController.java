package team.zavod.handy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.zavod.handy.entity.note.Note;
import team.zavod.handy.service.NoteService;

import java.util.List;

/**
 * <p>Handles endpoints related to notes.</p>
 */
@RestController
@RequestMapping(value = "/api/notes")
public class NoteController {
  private final NoteService service;    // Instance of NoteService

  /**
   * <p>Creates instance of <code>NoteController</code> class.</p>
   *
   * @param service Instance of NoteService.
   */
  @Autowired
  public NoteController(NoteService service) {
    this.service = service;
  }

  @GetMapping
  public List<Note> getAllNotes() {
    return service.getAllNotes();
  }

  @PostMapping
  public Note saveNote(@RequestBody Note note) {
    service.saveNote(note);
    return note;
  }
}
