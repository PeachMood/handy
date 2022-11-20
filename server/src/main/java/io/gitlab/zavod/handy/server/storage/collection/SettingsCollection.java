package io.gitlab.zavod.handy.server.storage.collection;

import io.gitlab.zavod.handy.server.storage.entity.user.SettingsEntity;

import java.util.List;

/**
 * <p>Provides functionality to manage settings.</p>
 */
public interface SettingsCollection {
    /**
     * <p>Creates new settings with the specified data.</p>
     *
     * @param id Unique settings identifier.
     * @param trashedPeriod Time for storing data in trash.
     */
    void createSettings(int id, int trashedPeriod);

    /**
     * <p>Finds settings by id.</p>
     *
     * @param id Settings id to be found.
     * @return <code>SettingsEntity</code> instance with the specified id, or <code>null</code> if such settings doesn't exist.
     */
    SettingsEntity findSettings(int id);

    /**
     * <p>Gets <code>List</code> of all settings.</p>
     *
     * @return <code>List</code> of all settings.
     */
    List<SettingsEntity> findAllSettings();

    /**
     * <p>Updates settings data. If the specified settings doesn't exists, new settings will be created.</p>
     *
     * @param settingsEntity <code>SettingsEntity</code> instance to be updated.
     * @return <code>true</code> if settings data changed as a result of this call, or <code>false</code> otherwise.
     */
    boolean updateSettings(SettingsEntity settingsEntity);

    /**
     * <p>Deletes settings by id.</p>
     *
     * @param id Settings id to be deleted.
     * @return <code>true</code> if settings collection changed as a result of this call, or <code>False</code> otherwise.
     */
    boolean deleteSettings(int id);
}
