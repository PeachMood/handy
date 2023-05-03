package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.SettingsRequestDto;
import team.zavod.handy.model.entity.user.SettingsEntity;

/** Converts SettingsRequestDto to SettingsEntity. */
public class SettingsRequestDtoToSettingsEntityConverter
    implements Converter<SettingsRequestDto, SettingsEntity> {
  /**
   * Converts <code>SettingsRequestDto</code> to <code>SettingsEntity</code>.
   *
   * @param source SettingsRequestDto to convert.
   * @return Converted SettingsEntity.
   */
  @Override
  public SettingsEntity convert(SettingsRequestDto source) {
    SettingsEntity target = new SettingsEntity();
    target.setId(source.id());
    target.setTrashedPeriod(source.trashedPeriod());
    return target;
  }
}
