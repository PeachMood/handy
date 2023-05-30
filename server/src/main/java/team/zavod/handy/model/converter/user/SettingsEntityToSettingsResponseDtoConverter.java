package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.SettingsResponseDto;
import team.zavod.handy.model.entity.user.SettingsEntity;

/** Converts SettingsEntity to SettingsResponseDto. */
public class SettingsEntityToSettingsResponseDtoConverter
    implements Converter<SettingsEntity, SettingsResponseDto> {
  /**
   * Converts <code>SettingsEntity</code> to <code>SettingsResponseDto</code>.
   *
   * @param source SettingsEntity to convert.
   * @return Converted SettingsResponseDto.
   */
  @Override
  public SettingsResponseDto convert(SettingsEntity source) {
    return new SettingsResponseDto(source.getId(), source.getTrashedPeriod());
  }
}
