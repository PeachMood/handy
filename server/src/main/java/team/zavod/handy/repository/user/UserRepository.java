package team.zavod.handy.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.model.entity.user.UserEntity;

/** Provides functionality to manage users. */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  /**
   * Creates new user with the specified data.
   *
   * @param user User to be saved.
   */
  @SuppressWarnings("unchecked")
  UserEntity save(UserEntity user);

  /**
   * Finds user by id.
   *
   * @param id User's id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * Finds user by username.
   *
   * @param username Username to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified username.
   */
  <T> Optional<T> findByUsername(String username, Class<T> type);

  /**
   * Finds user by e-mail address.
   *
   * @param email User's e-mail address to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified e-mail address.
   */
  <T> Optional<T> findByEmail(String email, Class<T> type);

  /**
   * Gets <code>List</code> of all users.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all users.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * Checks whether user with the specified username exists.
   *
   * @param username Username to be checked.
   * @return <code>true</code> if user with such username exists, or <code>false</code> otherwise.
   */
  boolean existsByUsername(String username);

  /**
   * Checks whether user with the specified e-mail address exists.
   *
   * @param email E-mail address to be checked.
   * @return <code>true</code> if user with such e-mail address exists, or <code>false</code>
   *     otherwise.
   */
  boolean existsByEmail(String email);

  /**
   * Deletes user by id.
   *
   * @param id User's id to be deleted.
   */
  void deleteById(Long id);
}
