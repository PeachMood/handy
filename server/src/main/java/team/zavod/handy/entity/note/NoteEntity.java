package team.zavod.handy.entity.note;

import java.nio.file.Path;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import team.zavod.handy.entity.user.UserEntity;

/**
 * <p>Represents single note.</p>
 */
@Entity(name = "Note")
@Table(name = "note")
public class NoteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;    // Unique note identifier
  @ManyToOne
  private UserEntity user;    // Instance of UserEntity
  private String name;    // Note name
  private String content;    // Path to note content
  @Column(name = "creation_date")
  private LocalDateTime creationDate;    // Date of note creation
  @Column(name = "modification_date")
  private LocalDateTime modificationDate;    // Date of note last modification
  @Column(name = "trashed_date")
  private LocalDateTime trashedDate;    // Date of permanent note deletion
  @Enumerated(EnumType.STRING)
  private NoteState state;    // Current note state

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   */
  protected NoteEntity() {
  }

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param creationDate Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate Date of permanent note deletion.
   * @param state Current note state.
   */
  public NoteEntity(Long id,
      UserEntity user,
      String name,
      String content,
      LocalDateTime creationDate,
      LocalDateTime modificationDate,
      LocalDateTime trashedDate,
      NoteState state) {
    this.id = id;
    this.user = user;
    this.name = name;
    this.content = content;
    this.creationDate = creationDate;
    this.modificationDate = modificationDate;
    this.trashedDate = trashedDate;
    this.state = state;
  }

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param creationDate Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate Date of permanent note deletion.
   * @param state Current note state.
   */
  public NoteEntity(Long id,
      UserEntity user,
      String name,
      Path content,
      LocalDateTime creationDate,
      LocalDateTime modificationDate,
      LocalDateTime trashedDate,
      NoteState state) {
    this(id,
        user,
        name,
        content.toString(),
        creationDate,
        modificationDate,
        trashedDate,
        state);
  }

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param state Current note state.
   */
  public NoteEntity(Long id,
      UserEntity user,
      String name,
      String content,
      NoteState state) {
    this(id,
        user,
        name,
        content,
        LocalDateTime.now(),
        LocalDateTime.now(),
        null,
        state);
  }

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param state Current note state.
   */
  public NoteEntity(Long id,
      UserEntity user,
      String name,
      Path content,
      NoteState state) {
    this(id,
        user,
        name,
        content.toString(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        null,
        state);
  }

  /**
   * <p>Getter for <code>id</code> field.</p>
   *
   * @return Unique note identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * <p>Setter for <code>id</code> field.</p>
   *
   * @param id Unique note identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * <p>Getter for <code>user</code> field.</p>
   *
   * @return Instance of UserEntity.
   */
  public UserEntity getUser() {
    return this.user;
  }

  /**
   * <p>Setter for <code>user</code> field.</p>
   *
   * @param user Instance of UserEntity.
   */
  public void setUser(UserEntity user) {
    this.user = user;
  }

  /**
   * <p>Getter for <code>name</code> field.</p>
   *
   * @return Note name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * <p>Setter for <code>name</code> field.</p>
   *
   * @param name Note name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * <p>Getter for <code>content</code> field.</p>
   *
   * @return Path to note content.
   */
  public String getContent() {
    return this.content;
  }

  /**
   * <p>Setter for <code>content</code> field.</p>
   *
   * @param content Path to note content.
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * <p>Setter for <code>content</code> field.</p>
   *
   * @param content Path to note content.
   */
  public void setContent(Path content) {
    setContent(content.toString());
  }

  /**
   * <p>Getter for <code>creationDate</code> field.</p>
   *
   * @return Date of note creation.
   */
  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  /**
   * <p>Setter for <code>creationDate</code> field.</p>
   *
   * @param creationDate Date of note creation.
   */
  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * <p>Getter for <code>modificationDate</code> field.</p>
   *
   * @return Date of note last modification.
   */
  public LocalDateTime getModificationDate() {
    return this.modificationDate;
  }

  /**
   * <p>Setter for <code>modificationDate</code> field.</p>
   *
   * @param modificationDate Date of note last modification.
   */
  public void setModificationDate(LocalDateTime modificationDate) {
    this.modificationDate = modificationDate;
  }

  /**
   * <p>Getter for <code>trashedDate</code> field.</p>
   *
   * @return Date of permanent note deletion.
   */
  public LocalDateTime getTrashedDate() {
    return this.trashedDate;
  }

  /**
   * <p>Setter for <code>trashedDate</code> field.</p>
   *
   * @param trashedDate Date of permanent note deletion.
   */
  public void setTrashedDate(LocalDateTime trashedDate) {
    this.trashedDate = trashedDate;
  }

  /**
   * <p>Getter for <code>state</code> field.</p>
   *
   * @return Current note state.
   */
  public NoteState getState() {
    return this.state;
  }

  /**
   * <p>Setter for <code>state</code> field.</p>
   *
   * @param state Current note state.
   */
  public void setState(NoteState state) {
    this.state = state;
  }
}
