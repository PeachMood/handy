package team.zavod.handy.model.converter.note;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import team.zavod.handy.model.dto.note.request.NoteCreateRequestDto;
import team.zavod.handy.model.entity.note.Note;

@Mapper(
    componentModel = "spring",
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public abstract class NoteRequestConverter {
  public abstract Note convert(NoteCreateRequestDto source);
}
