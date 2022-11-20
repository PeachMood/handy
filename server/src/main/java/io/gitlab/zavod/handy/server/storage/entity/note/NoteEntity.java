package io.gitlab.zavod.handy.server.storage.entity.note;

import io.gitlab.zavod.handy.server.storage.entity.user.UserEntity;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

/**
 * <p>Represents single note.</p>
 */
public class NoteEntity {
  private final int id;    // Unique note identifier
  private final UserEntity userEntity;    // Instance of UserEntity
  private String name;    // Note name
  private final Path content;    // Path to note content
  private final LocalDateTime creationDate;    // Date of note creation
  private LocalDateTime modificationDate;    // Date of note last modification
  private LocalDateTime trashedDate;    // Date of permanent note deletion
  private NoteState state;    // Current note state

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   *
   * @param id               Unique note identifier.
   * @param userEntity       Instance of UserEntity.
   * @param name             Note name.
   * @param content          Path to note content.
   * @param creationDate     Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate      Date of permanent note deletion.
   * @param state            Current note state.
   */
  public NoteEntity(int id,
      UserEntity userEntity,
      String name,
      Path content,
      LocalDateTime creationDate,
      LocalDateTime modificationDate,
      LocalDateTime trashedDate,
      NoteState state) {
    this.id = id;
    this.userEntity = userEntity;
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
   * @param id               Unique note identifier.
   * @param userEntity       Instance of UserEntity.
   * @param name             Note name.
   * @param content          Path to note content.
   * @param creationDate     Date of note creation.
   * @param modificationDate Date of note last modification.
   * @param trashedDate      Date of permanent note deletion.
   * @param state            Current note state.
   */
  public NoteEntity(int id,
      UserEntity userEntity,
      String name,
      String content,
      LocalDateTime creationDate,
      LocalDateTime modificationDate,
      LocalDateTime trashedDate,
      NoteState state) {
    this(id,
        userEntity,
        name,
        Paths.get(content),
        creationDate,
        modificationDate,
        trashedDate,
        state);
  }

  /**
   * <p>Creates instance of <code>NoteEntity</code> class.</p>
   *
   * @param id         Unique note identifier.
   * @param userEntity Instance of UserEntity.
   * @param name       Note name.
   * @param content    Path to note content.
   * @param state      Current note state.
   */
  public NoteEntity(int id,
      UserEntity userEntity,
      String name,
      Path content,
      NoteState state) {
    this(id,
        userEntity,
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
   * @param id         Unique note identifier.
   * @param userEntity Instance of UserEntity.
   * @param name       Note name.
   * @param content    Path to note content.
   * @param state      Current note state.
   */
  public NoteEntity(int id,
      UserEntity userEntity,
      String name,
      String content,
      NoteState state) {
    this(id,
        userEntity,
        name,
        Paths.get(content),
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
  public int getId() {
    return this.id;
  }

  /**
   * <p>Getter for <code>userEntity</code> field.</p>
   *
   * @return Instance of UserEntity.
   */
  public UserEntity getUserEntity() {
    return this.userEntity;
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
  public Path getContent() {
    return this.content;
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
