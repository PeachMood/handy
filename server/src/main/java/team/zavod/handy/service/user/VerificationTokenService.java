package team.zavod.handy.service.user;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.zavod.handy.configuration.ApplicationConfiguration;
import team.zavod.handy.model.entity.user.UserEntity;
import team.zavod.handy.model.entity.user.VerificationTokenEntity;
import team.zavod.handy.repository.user.VerificationTokenRepository;

/** Implements complex logic related to verification tokens */
@Service
public class VerificationTokenService {
  private final VerificationTokenRepository
      verificationTokenRepository; // Instance of VerificationTokenRepository
  private final ApplicationConfiguration
      applicationConfiguration; // Instance of ApplicationConfiguration
  private final JavaMailSender javaMailSender; // Instance of JavaMailSender

  /**
   * Constructs new instance of <code>VerificationTokenService</code> class.
   *
   * @param verificationTokenRepository Instance of VerificationTokenRepository.
   * @param applicationConfiguration Instance of ApplicationConfiguration.
   * @param javaMailSender Instance of JavaMailSender.
   */
  @Autowired
  public VerificationTokenService(
      VerificationTokenRepository verificationTokenRepository,
      ApplicationConfiguration applicationConfiguration,
      JavaMailSender javaMailSender) {
    this.verificationTokenRepository = verificationTokenRepository;
    this.applicationConfiguration = applicationConfiguration;
    this.javaMailSender = javaMailSender;
  }

  /**
   * Creates new verification token with the specified data.
   *
   * @param verificationToken Verification token to be created.
   * @return <code>True</code> if VerificationTokenRepository was changed as a result of this call,
   *     or <code>false</code> otherwise.
   */
  @Transactional
  public boolean createVerificationToken(VerificationTokenEntity verificationToken) {
    this.verificationTokenRepository.save(verificationToken);
    sendEmail(verificationToken);
    return true;
  }

  /**
   * Finds verification token by id.
   *
   * @param id Verification token id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return Verification token with the specified id if such verification token exists, or <code>
   *     null</code> otherwise.
   */
  public <T> T findVerificationToken(Long id, Class<T> type) {
    return this.verificationTokenRepository.findById(id, type).orElse(null);
  }

  /**
   * Gets <code>List</code> of all verification tokens.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all verification tokens.
   */
  public <T> List<T> findAllVerificationTokens(Class<T> type) {
    return this.verificationTokenRepository.findAllProjectedBy(type);
  }

  /**
   * Checks weather verification token with the specified token exists.
   *
   * @param token Token to be checked.
   * @return <code>True</code> if such verification token exists, or <code>false</code> otherwise.
   */
  public boolean isVerificationTokenExists(String token) {
    return this.verificationTokenRepository.existsByToken(token);
  }

  /**
   * Finds verification token by token.
   *
   * @param token Token to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return Verification token with the specified token if such verification token exists, or
   *     <code>null</code> otherwise.
   */
  public <T> T findVerificationToken(String token, Class<T> type) {
    return this.verificationTokenRepository.findByToken(token, type).orElse(null);
  }

  /**
   * Gets <code>List</code> of all verification tokens for the specified user.
   *
   * @param user User whose verification tokens will be returned.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all verification tokens for the specified user.
   */
  public <T> List<T> findAllUserVerificationTokens(UserEntity user, Class<T> type) {
    return this.verificationTokenRepository.findAllByUser(user, type);
  }

  /**
   * Updates verification token with the specified data.
   *
   * @param with Verification token to be updated.
   * @return <code>True</code> if VerificationTokenRepository was changed as a result of this call,
   *     or <code>false</code> otherwise.
   */
  @Transactional
  public boolean updateVerificationToken(VerificationTokenEntity with) {
    VerificationTokenEntity current =
        findVerificationToken(with.getId(), VerificationTokenEntity.class);
    if (Objects.isNull(current)) {
      return false;
    }
    with.setCreationDate(current.getCreationDate());
    with.setUser(current.getUser());
    this.verificationTokenRepository.save(with);
    return true;
  }

  /**
   * Deletes verification token by id.
   *
   * @param id Verification token id to be deleted.
   * @return <code>True</code> if VerificationTokenRepository was changed as a result of this call,
   *     or <code>false</code> otherwise.
   */
  @Transactional
  public boolean deleteVerificationToken(Long id) {
    if (Objects.isNull(findVerificationToken(id, VerificationTokenEntity.class))) {
      return false;
    }
    this.verificationTokenRepository.deleteById(id);
    return true;
  }

  /* Sends email for account verification */
  private void sendEmail(VerificationTokenEntity verificationToken) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setFrom(applicationConfiguration.verification().email());
    mailMessage.setTo(verificationToken.getUser().getEmail());
    mailMessage.setSubject("Complete registration");
    mailMessage.setText(
        "To confirm your account please click here:\nhttps://"
            + this.applicationConfiguration.domain()
            + "/api/auth/activate?token="
            + verificationToken.getToken());
    this.javaMailSender.send(mailMessage);
  }
}
