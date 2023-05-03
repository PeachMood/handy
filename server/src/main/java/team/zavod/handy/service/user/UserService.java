package team.zavod.handy.service.user;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.zavod.handy.model.entity.user.RoleEntity;
import team.zavod.handy.model.entity.user.SettingsEntity;
import team.zavod.handy.model.entity.user.UserEntity;
import team.zavod.handy.repository.user.UserRepository;

/** Implements complex logic related to user. */
@Service
public class UserService implements UserDetailsService {
  private final UserRepository userRepository; // Instance of UserRepository
  private final RoleService roleService; // Instance of user RoleService
  private final PasswordEncoder passwordEncoder; // Instance of PasswordEncoder

  /**
   * Constructs new instance of <code>UserService</code> class.
   *
   * @param userRepository Instance of UserRepository.
   * @param roleService Instance of user RoleService.
   * @param passwordEncoder Instance of BCryptPasswordEncoder.
   */
  @Autowired
  public UserService(
      UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleService = roleService;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * Creates new user with the specified data.
   *
   * @param user User to be created.
   * @return <code>true</code> if UserRepository was changed as a result of this call, or <code>
   *     false</code> otherwise.
   */
  @Transactional
  public boolean createUser(UserEntity user) {
    if (isUsernameExists(user.getUsername()) || isEmailExists(user.getEmail())) {
      return false;
    }
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    user.setSettings(new SettingsEntity());
    user.setRoles(
        Stream.ofNullable(this.roleService.findRole(RoleEntity.DEFAULT_ROLE, RoleEntity.class))
            .collect(Collectors.toCollection(HashSet::new)));
    this.userRepository.save(user);
    return true;
  }

  /**
   * Finds user by id.
   *
   * @param id User's id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return User with the specified id if such user exists, or <code>null</code> otherwise.
   */
  public <T> T findUser(Long id, Class<T> type) {
    return this.userRepository.findById(id, type).orElse(null);
  }

  /**
   * Finds user by login.
   *
   * @param login User's name or e-mail address to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return User with the specified login if such user exists, or <code>null</code> otherwise.
   */
  public <T> T findUser(String login, Class<T> type) {
    return this.userRepository
        .findByUsername(login, type)
        .or(() -> this.userRepository.findByEmail(login, type))
        .orElse(null);
  }

  /**
   * Gets <code>List</code> of all users.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all users.
   */
  public <T> List<T> findAllUsers(Class<T> type) {
    return this.userRepository.findAllProjectedBy(type);
  }

  /**
   * Checks whether user with the specified username exists.
   *
   * @param username Username to be checked.
   * @return <code>true</code> if user with such username exists, or <code>false</code> otherwise.
   */
  public boolean isUsernameExists(String username) {
    return this.userRepository.existsByUsername(username);
  }

  /**
   * Checks whether user with the specified e-mail address exists.
   *
   * @param email E-mail address to be checked.
   * @return <code>true</code> if user with such e-mail address exists, or <code>false</code>
   *     otherwise.
   */
  public boolean isEmailExists(String email) {
    return this.userRepository.existsByEmail(email);
  }

  /**
   * Updates user with the specified data.
   *
   * @param with User to be updated.
   * @return <code>true</code> if UserRepository was changed as a result of this call, or <code>
   *     false</code> otherwise.
   */
  @Transactional
  public boolean updateUser(UserEntity with) {
    UserEntity current = findUser(with.getId(), UserEntity.class);
    if (Objects.isNull(current)) {
      return false;
    }
    with.setAvatar(current.getAvatar());
    with.setPassword(this.passwordEncoder.encode(with.getPassword()));
    with.setSettings(current.getSettings());
    with.setRoles(current.getRoles());
    if ((!with.getUsername().equals(current.getUsername()) && isUsernameExists(with.getUsername()))
        || (!with.getEmail().equals(current.getEmail()) && isEmailExists(with.getEmail()))) {
      return false;
    }
    this.userRepository.save(with);
    return true;
  }

  /**
   * Deletes user by id.
   *
   * @param id User's id to be deleted.
   * @return <code>true</code> if UserRepository was changed as a result of this call, or <code>
   *     false</code> otherwise.
   */
  @Transactional
  public boolean deleteUser(Long id) {
    if (Objects.isNull(findUser(id, UserEntity.class))) {
      return false;
    }
    this.userRepository.deleteById(id);
    return true;
  }

  /**
   * Locates the user based on the username.
   *
   * @param username Username identifying the user whose data is required.
   * @return Fully populated user record.
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = findUser(username, UserEntity.class);
    if (Objects.isNull(user)) {
      throw new UsernameNotFoundException("User not found");
    }
    return user;
  }
}
