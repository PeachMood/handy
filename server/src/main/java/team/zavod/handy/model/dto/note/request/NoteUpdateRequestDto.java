package team.zavod.handy.model.dto.note.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteUpdateRequestDto {
  @Size(min = 1)
  private String name;

  private String content;
}
