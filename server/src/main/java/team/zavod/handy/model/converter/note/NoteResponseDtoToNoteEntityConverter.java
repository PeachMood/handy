package team.zavod.handy.model.converter.note;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.note.NoteResponseDto;
import team.zavod.handy.model.entity.note.NoteEntity;

/**
 * <p>Converts NoteResponseDto to NoteEntity.</p>
 */
public class NoteResponseDtoToNoteEntityConverter implements Converter<NoteResponseDto, NoteEntity> {
  /**
   * <p>Converts <code>NoteResponseDto</code> to <code>NoteEntity</code>.</p>
   *
   * @param source NoteResponseDto to convert.
   * @return Converted NoteEntity.
   */
  @Override
  public NoteEntity convert(NoteResponseDto source) {
    NoteEntity target = new NoteEntity();
    target.setId(source.id());
    target.setName(source.name());
    target.setContent(source.content());
    target.setCreationDate(source.creationDate());
    target.setModificationDate(source.modificationDate());
    return target;
  }
}
