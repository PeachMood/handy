package team.zavod.handy.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.entity.user.UserEntity;

/**
 * <p>Provides functionality to manage users.</p>
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  /**
   * <p>Creates new user with the specified data.</p>
   *
   * @param user User to be saved.
   */
  @SuppressWarnings("unchecked")
  UserEntity save(UserEntity user);

  /**
   * <p>Finds user by id.</p>
   *
   * @param id User's id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * <p>Finds user by username.</p>
   *
   * @param name Username to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified username.
   */
  <T> Optional<T> findByName(String name, Class<T> type);

  /**
   * <p>Finds user by e-mail address.</p>
   *
   * @param email User's e-mail address to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified e-mail address.
   */
  <T> Optional<T> findByEmail(String email, Class<T> type);

  /**
   * <p>Gets <code>List</code> of all users.</p>
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all users.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * <p>Checks whether user with the specified username exists.</p>
   *
   * @param name Username to be checked.
   * @return <code>true</code> if user with such username exists,
   * or <code>false</code> otherwise.
   */
  boolean existsByName(String name);

  /**
   * <p>Checks whether user with the specified e-mail address exists.</p>
   *
   * @param email E-mail address to be checked.
   * @return <code>true</code> if user with such e-mail address exists,
   * or <code>false</code> otherwise.
   */
  boolean existsByEmail(String email);

  /**
   * <p>Deletes user by id.</p>
   *
   * @param id User's id to be deleted.
   */
  void deleteById(Long id);
}
