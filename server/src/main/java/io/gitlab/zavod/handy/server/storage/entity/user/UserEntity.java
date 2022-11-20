package io.gitlab.zavod.handy.server.storage.entity.user;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>Represents single user.</p>
 */
public class UserEntity {
    private final int id;    // Unique user identifier
    private String name;    // Unique username
    private String email;    // User's e-mail address
    private Path avatar;    // Path to user's avatar
    private String passwordHash;    // Hash of user's password
    private final SettingsEntity settingsEntity;    // Instance of user SettingsEntity

    /**
     * <p>Constructs new instance of <code>UserEntity</code> class.</p>
     *
     * @param id Unique user identifier.
     * @param name Unique user name.
     * @param email User's e-mail address.
     * @param avatar Path to user's avatar.
     * @param passwordHash Hash of user's password.
     * @param settingsEntity Instance of user SettingsEntity.
     */
    public UserEntity(int id, String name, String email, Path avatar, String passwordHash, SettingsEntity settingsEntity) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.passwordHash = passwordHash;
        this.settingsEntity = settingsEntity;
    }

    /**
     * <p>Constructs new instance of <code>UserEntity</code> class.</p>
     *
     * @param id Unique user identifier.
     * @param name Unique user name.
     * @param email User's e-mail address.
     * @param avatar Path to user's avatar.
     * @param passwordHash Hash of user's password.
     * @param settingsEntity Instance of user SettingsEntity.
     */
    public UserEntity(int id, String name, String email, String avatar, String passwordHash, SettingsEntity settingsEntity) {
        this(id, name, email, Paths.get(avatar), passwordHash, settingsEntity);
    }

    /**
     * <p>Getter for <code>id</code> field.</p>
     *
     * @return Unique user identifier.
     */
    public int getId() {
        return this.id;
    }

    /**
     * <p>Getter for <code>name</code> field.</p>
     *
     * @return Unique username.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>Setter for <code>name</code> field.</p>
     *
     * @param name Unique username.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter for <code>email</code> field.</p>
     *
     * @return User's e-mail address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * <p>Setter for <code>email</code> field.</p>
     *
     * @param email User's e-mail address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>Getter for <code>avatar</code> field.</p>
     *
     * @return Path to user's avatar.
     */
    public Path getAvatar() {
        return this.avatar;
    }

    /**
     * <p>Setter for <code>avatar</code> field.</p>
     *
     * @param avatar Path to user's avatar.
     */
    public void setAvatar(Path avatar) {
        this.avatar = avatar;
    }

    /**
     * <p>Setter for <code>avatar</code> field.</p>
     *
     * @param avatar Path to user's avatar.
     */
    public void setAvatar(String avatar) {
        setAvatar(Paths.get(avatar));
    }

    /**
     * <p>Getter for <code>passwordHash</code> field.</p>
     *
     * @return Hash of user's password.
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * <p>Setter for <code>passwordHash</code> field.</p>
     *
     * @param passwordHash Hash of user's password.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * <p>Getter for <code>settingsEntity</code> field.</p>
     *
     * @return Instance of user SettingsEntity.
     */
    public SettingsEntity getSettings() {
        return this.settingsEntity;
    }
}
