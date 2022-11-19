package io.gitlab.zavod.handy.server.storage.collection;

import io.gitlab.zavod.handy.server.storage.entity.SettingsEntity;
import io.gitlab.zavod.handy.server.storage.entity.UserEntity;

import java.nio.file.Path;
import java.util.List;

/**
 * <p>Provides functionality to manage users.</p>
 */
public interface UserCollection {
    /**
     * <p>Creates new user with the specified data.</p>
     *
     * @param id Unique user identifier.
     * @param name Unique username.
     * @param email User's e-mail address.
     * @param avatar Path to user's avatar.
     * @param passwordHash Hash of user's password.
     * @param settingsEntity Instance of user's SettingsEntity.
     */
    void createUser(int id, String name, String email, Path avatar, String passwordHash, SettingsEntity settingsEntity);

    /**
     * <p>Finds user by id.</p>
     *
     * @param id User's id to be found.
     * @return <code>UserEntity</code> instance with the specified id, or <code>null</code> if such user doesn't exist.
     */
    UserEntity findUser(int id);

    /**
     * <p>Gets <code>List</code> of all users.</p>
     *
     * @return <code>List</code> of all users.
     */
    List<UserEntity> findAllUsers();

    /**
     * <p>Finds user by name.</p>
     *
     * @param name Username to be found.
     * @return <code>UserEntity</code> instance with the specified name, or <code>null</code> if such user doesn't exist.
     */
    UserEntity findUserByName(String name);

    /**
     * <p>Finds user by e-mail address.</p>
     *
     * @param email User's e-mail address to be found.
     * @return <code>UserEntity</code> instance with the specified e-mail address, or <code>null</code> if such user doesn't exist.
     */
    UserEntity findUserByEmail(String email);

    /**
     * <p>Tries to authenticate user with the specified username.</p>
     *
     * @param name Username to be authenticated.
     * @param passwordHash Hash of user's password.
     * @return <code>UserEntity</code> instance if notification was succeeded, or <code>null</code> otherwise.
     */
    UserEntity authenticateUserByName(String name, String passwordHash);

    /**
     * <p>Tries to authenticate user with the specified e-mail address.</p>
     *
     * @param email User's e-mail address to be authenticated.
     * @param passwordHash Hash of user's password.
     * @return <code>UserEntity</code> instance if authentication was succeeded, or <code>null</code> otherwise.
     */
    UserEntity authenticateUserByEmail(String email, String passwordHash);

    /**
     * <p>Updates user's data. If the specified user doesn't exist, new user will be created.</p>
     *
     * @param userEntity <code>UserEntity</code> instance to be updated.
     * @return <code>true</code> if user's data changed as a result of this call, or <code>false</code> otherwise.
     */
    boolean updateUser(UserEntity userEntity);

    /**
     * <p>Deletes user by id.</p>
     *
     * @param id User's id to be deleted.
     * @return <code>true</code> if user collection changed as a result of this call, or <code>false</code> otherwise.
     */
    boolean deleteUser(int id);
}
