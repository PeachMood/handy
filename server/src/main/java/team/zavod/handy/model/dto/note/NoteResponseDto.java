package team.zavod.handy.model.dto.note;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponseDto {
  Long id;
  String name;
  String content;
  LocalDateTime creationDate;
  LocalDateTime modificationDate;
}
