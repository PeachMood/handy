package team.zavod.handy.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.zavod.handy.repository.user.UserRepository;

/**
 * <p>Implements complex logic related to user.</p>
 */
@Service
public class UserService {
  private final UserRepository repository;    // Instance of UserRepository

  /**
   * <p>Creates instance of <code>UserService</code> class.</p>
   *
   * @param repository Instance of UserRepository.
   */
  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }
}
