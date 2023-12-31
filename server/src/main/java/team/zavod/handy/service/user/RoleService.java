package team.zavod.handy.service.user;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.zavod.handy.model.entity.user.RoleEntity;
import team.zavod.handy.repository.user.RoleRepository;

/** Implements complex logic related to user roles. */
@Service
public class RoleService {
  private final RoleRepository roleRepository; // Instance of user RoleRepository

  /**
   * Constructs new instance of <code>RoleService</code> class.
   *
   * @param roleRepository Instance of user RoleRepository.
   */
  @Autowired
  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  /**
   * Creates new user role with the specified data.
   *
   * @param role User role to be created.
   * @return <code>true</code> if RoleRepository was changed as a result of this call, or <code>
   *     false</code> otherwise.
   */
  @Transactional
  public boolean createRole(RoleEntity role) {
    if (isRoleExists(role.getName())) {
      return false;
    }
    this.roleRepository.save(role);
    return true;
  }

  /**
   * Finds role by id.
   *
   * @param id role id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return User role with the specified id if such role exists, or <code>null</code> otherwise.
   */
  public <T> T findRole(Long id, Class<T> type) {
    return this.roleRepository.findById(id, type).orElse(null);
  }

  /**
   * Finds role by name.
   *
   * @param name Role name to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return User role with the specified name if such role exists, or <code>null</code> otherwise.
   */
  public <T> T findRole(String name, Class<T> type) {
    return this.roleRepository.findByName(name, type).orElse(null);
  }

  /**
   * Gets <code>List</code> of all roles.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all roles.
   */
  public <T> List<T> findAllRoles(Class<T> type) {
    return this.roleRepository.findAllProjectedBy(type);
  }

  /**
   * Checks weather user role with the specified name exists.
   *
   * @param name User role to be checked.
   * @return <code>true</code> if such user role exists, or <code>false</code> otherwise.
   */
  public boolean isRoleExists(String name) {
    return this.roleRepository.existsByName(name);
  }

  /**
   * Updates user role with the specified data.
   *
   * @param with User role to be updated.
   * @return <code>true</code> if RoleRepository was changed as a result of this call, or <code>
   *     false</code> otherwise.
   */
  @Transactional
  public boolean updateRole(RoleEntity with) {
    RoleEntity current = findRole(with.getId(), RoleEntity.class);
    if (Objects.isNull(current)) {
      return false;
    }
    if (!with.getName().equals(current.getName()) && isRoleExists(with.getName())) {
      return false;
    }
    this.roleRepository.save(with);
    return true;
  }

  /**
   * Deletes role by id.
   *
   * @param id Role id to be deleted.
   * @return <code>true</code> if RoleRepository was changed as a result of this call, or <code>
   *     false</code> otherwise.
   */
  @Transactional
  public boolean deleteRole(Long id) {
    if (Objects.isNull(findRole(id, RoleEntity.class))) {
      return false;
    }
    this.roleRepository.deleteById(id);
    return true;
  }
}
