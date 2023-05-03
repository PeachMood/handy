package team.zavod.handy.model.converter.note;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.note.NoteRequestDto;
import team.zavod.handy.model.entity.note.NoteEntity;

/** Converts NoteRequestDto to NoteEntity. */
public class NoteRequestDtoToNoteEntityConverter implements Converter<NoteRequestDto, NoteEntity> {
  /**
   * Converts <code>NoteRequestDto</code> to <code>NoteEntity</code>.
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
