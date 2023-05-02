package team.zavod.handy.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.model.entity.user.RoleEntity;

/**
 * <p>Provides functionality to manage user roles.</p>
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
  /**
   * <p>Creates new user role with the specified data.</p>
   *
   * @param role User role to be saved.
   */
  @SuppressWarnings("unchecked")
  RoleEntity save(RoleEntity role);

  /**
   * <p>Finds role by id.</p>
   *
   * @param id role id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * <p>Finds role by name.</p>
   *
   * @param name Role name to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified name.
   */
  <T> Optional<T> findByName(String name, Class<T> type);

  /**
   * Gets <code>List</code> of all roles.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all roles.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * <p>Checks weather user role with the specified name exists.</p>
   *
   * @param name User role to be checked.
   * @return <code>true</code> if such user role exists,
   * or <code>false</code> otherwise.
   */
  boolean existsByName(String name);

  /**
   * <p>Deletes role by id.</p>
   *
   * @param id Role id to be deleted.
   */
  void deleteById(Long id);
}
