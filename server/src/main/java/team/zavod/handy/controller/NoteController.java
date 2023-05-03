package team.zavod.handy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.NoteService;

/** Handles endpoints related to notes. */
@RestController
@RequestMapping(value = "/api/note")
public class NoteController {
  private final ConversionService conversionService; // For type conversion purposes
  private final NoteService noteService; // Instance of NoteService

  /**
   * Constructs new instance of <code>NoteController</code> class.
   *
   * @param conversionService For type conversion Purposes.
   * @param noteService Instance of NoteService.
   */
  @Autowired
  public NoteController(ConversionService conversionService, NoteService noteService) {
    this.conversionService = conversionService;
    this.noteService = noteService;
  }
}
