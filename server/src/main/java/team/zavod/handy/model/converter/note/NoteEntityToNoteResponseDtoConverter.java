package team.zavod.handy.model.converter.note;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.note.NoteResponseDto;
import team.zavod.handy.model.entity.note.NoteEntity;

/** Converts NoteEntity to NoteResponseDto. */
public class NoteEntityToNoteResponseDtoConverter
    implements Converter<NoteEntity, NoteResponseDto> {
  /**
   * Converts <code>NoteEntity</code> to <code>NoteResponseDto</code>.
   *
   * @param source NoteEntity to convert.
   * @return Converted NoteResponseDto.
   */
  @Override
  public NoteResponseDto convert(NoteEntity source) {
    return new NoteResponseDto(
        source.getId(),
        source.getName(),
        source.getContent(),
        source.getCreationDate(),
        source.getModificationDate());
  }
}
