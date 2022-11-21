package io.gitlab.zavod.handy.server.controller;

import io.gitlab.zavod.handy.server.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Handles endpoints related to notes.</p>
 */
@RestController
@RequestMapping("/note")
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
