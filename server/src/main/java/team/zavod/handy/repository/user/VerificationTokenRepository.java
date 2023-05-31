package team.zavod.handy.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.model.entity.user.UserEntity;
import team.zavod.handy.model.entity.user.VerificationTokenEntity;

/** Provides functionality to manage verification tokens */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {
  /**
   * Creates new verification token with the specified data.
   *
   * @param verificationToken Verification token to be saved.
   */
  @SuppressWarnings("unchecked")
  VerificationTokenEntity save(VerificationTokenEntity verificationToken);

  /**
   * Finds verification token by id.
   *
   * @param id Verification token id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * Gets <code>List</code> of all verification tokens.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all verification tokens.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * Checks weather verification token with the specified token exists.
   *
   * @param token Token to be checked.
   * @return <code>True</code> if such verification token exists, or <code>false</code> otherwise.
   */
  boolean existsByToken(String token);

  /**
   * Finds verification token by token.
   *
   * @param token Token to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified token.
   */
  <T> Optional<T> findByToken(String token, Class<T> type);

  /**
   * Gets <code>List</code> of all verification tokens for the specified user.
   *
   * @param user User whose verification tokens will be returned.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all verification tokens for the specified user.
   */
  <T> List<T> findAllByUser(UserEntity user, Class<T> type);

  /**
   * Deletes verification token by id.
   *
   * @param id Verification token id to be deleted.
   */
  void deleteById(Long id);
}
