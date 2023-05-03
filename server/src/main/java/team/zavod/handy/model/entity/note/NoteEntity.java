package team.zavod.handy.model.entity.note;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import team.zavod.handy.model.entity.user.UserEntity;

/** Represents single note. */
@Entity(name = "Note")
@Table(name = "note")
public class NoteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique note identifier

  @ManyToOne private UserEntity user; // Instance of UserEntity
  private String name; // Note name
  private String content; // Path to note content

  @Column(name = "creation_date")
  private LocalDateTime creationDate; // Date of note creation

  @Column(name = "modification_date")
  private LocalDateTime modificationDate; // Date of note last modification

  @Column(name = "trashed_date")
  private LocalDateTime trashedDate; // Date of permanent note deletion

  @Enumerated(EnumType.STRING)
  private NoteState state; // Current note state

  /** Creates instance of <code>NoteEntity</code> class. */
  public NoteEntity() {}

  /**
   * Creates instance of <code>NoteEntity</code> class.
   *
   * @param id Unique note identifier.
   * @param user Instance of UserEntity.
   * @param name Note name.
   * @param content Path to note content.
   * @param state Current note state.
   */
  public NoteEntity(Long id, UserEntity user, String name, String content, NoteState state) {
    this(id, user, name, content, null, null, null, state);
    LocalDateTime now = LocalDateTime.now();
    this.creationDate = now;
    this.modificationDate = now;
  }

  /**
   * Creates instance of <code>NoteEntity</code> class.
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
  public NoteEntity(
      Long id,
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
   * Getter for <code>id</code> field.
   *
   * @return Unique note identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Setter for <code>id</code> field.
   *
   * @param id Unique note identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for <code>user</code> field.
   *
   * @return Instance of UserEntity.
   */
  public UserEntity getUser() {
    return this.user;
  }

  /**
   * Setter for <code>user</code> field.
   *
   * @param user Instance of UserEntity.
   */
  public void setUser(UserEntity user) {
    this.user = user;
  }

  /**
   * Getter for <code>name</code> field.
   *
   * @return Note name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setter for <code>name</code> field.
   *
   * @param name Note name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for <code>content</code> field.
   *
   * @return Path to note content.
   */
  public String getContent() {
    return this.content;
  }

  /**
   * Setter for <code>content</code> field.
   *
   * @param content Path to note content.
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Getter for <code>creationDate</code> field.
   *
   * @return Date of note creation.
   */
  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  /**
   * Setter for <code>creationDate</code> field.
   *
   * @param creationDate Date of note creation.
   */
  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * Getter for <code>modificationDate</code> field.
   *
   * @return Date of note last modification.
   */
  public LocalDateTime getModificationDate() {
    return this.modificationDate;
  }

  /**
   * Setter for <code>modificationDate</code> field.
   *
   * @param modificationDate Date of note last modification.
   */
  public void setModificationDate(LocalDateTime modificationDate) {
    this.modificationDate = modificationDate;
  }

  /**
   * Getter for <code>trashedDate</code> field.
   *
   * @return Date of permanent note deletion.
   */
  public LocalDateTime getTrashedDate() {
    return this.trashedDate;
  }

  /**
   * Setter for <code>trashedDate</code> field.
   *
   * @param trashedDate Date of permanent note deletion.
   */
  public void setTrashedDate(LocalDateTime trashedDate) {
    this.trashedDate = trashedDate;
  }

  /**
   * Getter for <code>state</code> field.
   *
   * @return Current note state.
   */
  public NoteState getState() {
    return this.state;
  }

  /**
   * Setter for <code>state</code> field.
   *
   * @param state Current note state.
   */
  public void setState(NoteState state) {
    this.state = state;
  }
}
