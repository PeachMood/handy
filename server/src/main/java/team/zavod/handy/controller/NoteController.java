package team.zavod.handy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.NoteService;

/**
 * <p>Handles endpoints related to notes.</p>
 */
@RestController
@RequestMapping(value = "/api/note")
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
}
