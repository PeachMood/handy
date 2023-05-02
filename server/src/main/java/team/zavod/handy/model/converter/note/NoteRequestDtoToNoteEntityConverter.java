package team.zavod.handy.model.converter.note;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.note.NoteRequestDto;
import team.zavod.handy.model.entity.note.NoteEntity;

/**
 * <p>Converts NoteRequestDto to NoteEntity.</p>
 */
public class NoteRequestDtoToNoteEntityConverter implements Converter<NoteRequestDto, NoteEntity> {
  /**
   * <p>Converts <code>NoteRequestDto</code> to <code>NoteEntity</code>.</p>
   *
   * @param source NoteRequestDto to convert.
   * @return Converted NoteEntity.
   */
  @Override
  public NoteEntity convert(NoteRequestDto source) {
    NoteEntity target = new NoteEntity();
    target.setId(source.id());
    target.setName(source.name());
    return target;
  }
}
