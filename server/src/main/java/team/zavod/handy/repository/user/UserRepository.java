package team.zavod.handy.repository.user;

import team.zavod.handy.entity.user.SettingsEntity;
import team.zavod.handy.entity.user.UserEntity;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Provides functionality to manage users.</p>
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  /**
   * <p>Creates new user with the specified data.</p>
   *
   * @param id Unique user identifier.
   * @param name Unique username.
   * @param email User's e-mail address.
   * @param avatar Path to user's avatar.
   * @param passwordHash Hash of user's password.
   * @param settings Instance of user's SettingsEntity.
   */
  void save(Long id,
      String name,
      String email,
      String avatar,
      String passwordHash,
      SettingsEntity settings);

  /**
   * <p>Creates new user with the specified data.</p>
   *
   * @param id Unique user identifier.
   * @param name Unique username.
   * @param email User's e-mail address.
   * @param avatar Path to user's avatar.
   * @param passwordHash Hash of user's password.
   * @param settings Instance of user's SettingsEntity.
   */
  void save(Long id,
      String name,
      String email,
      Path avatar,
      String passwordHash,
      SettingsEntity settings);

  /**
   * <p>Finds user by id.</p>
   *
   * @param id User's id to be found.
   * @return <code>Optional&lt;UserEntity&gt;</code> instance with the specified id.
   */
  Optional<UserEntity> findById(Long id);

  /**
   * <p>Gets <code>List</code> of all users.</p>
   *
   * @return <code>List</code> of all users.
   */
  List<UserEntity> findAll();

  /**
   * <p>Finds user by name.</p>
   *
   * @param name Username to be found.
   * @return <code>Optional&lt;UserEntity&gt;</code> instance with the specified name.
   */
  Optional<UserEntity> findByName(String name);

  /**
   * <p>Finds user by e-mail address.</p>
   *
   * @param email User's e-mail address to be found.
   * @return <code>Optional&lt;UserEntity&gt;</code> instance with the specified e-mail address.
   */
  Optional<UserEntity> findByEmail(String email);

  /**
   * <p>Tries to authenticate user with the specified username.</p>
   *
   * @param name Username to be authenticated.
   * @param passwordHash Hash of user's password.
   * @return <code>Optional&lt;UserEntity&gt;</code> instance if authentication was succeeded.
   */
  Optional<UserEntity> findByNameAndPasswordHash(String name, String passwordHash);

  /**
   * <p>Tries to authenticate user with the specified e-mail address.</p>
   *
   * @param email User's e-mail address to be authenticated.
   * @param passwordHash Hash of user's password.
   * @return <code>Optional&lt;UserEntity&gt;</code> instance if authentication was succeeded.
   */
  Optional<UserEntity> findByEmailAndPasswordHash(String email, String passwordHash);

  /**
   * <p>Deletes user by id.</p>
   *
   * @param id User's id to be deleted.
   */
  void deleteById(Long id);
}
