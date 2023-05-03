package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.SettingsResponseDto;
import team.zavod.handy.model.entity.user.SettingsEntity;

/** Converts SettingsResponseDto to SettingsEntity. */
public class SettingsResponseDtoToSettingsEntityConverter
    implements Converter<SettingsResponseDto, SettingsEntity> {
  /**
   * Converts <code>SettingsResponseDto</code> to <code>SettingsEntity</code>.
   *
   * @param source SettingsResponseDto to convert.
   * @return Converted SettingsEntity.
   */
  @Override
  public SettingsEntity convert(SettingsResponseDto source) {
    SettingsEntity target = new SettingsEntity();
    target.setId(source.id());
    target.setTrashedPeriod(source.trashedPeriod());
    return target;
  }
}
