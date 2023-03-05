package team.zavod.handy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.zavod.handy.repository.NoteRepository;

/**
 * <p>Implements complex logic related to notes.</p>
 */
@Service
public class NoteService {
  private final NoteRepository repository;    // Instance of NoteRepository

  /**
   * <p>Creates instance of <code>NoteService</code> class.</p>
   *
   * @param repository Instance of NoteRepository.
   */
  @Autowired
  public NoteService(NoteRepository repository) {
    this.repository = repository;
  }
}
