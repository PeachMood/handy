package team.zavod.handy.model.dto.note;

import java.time.LocalDateTime;

/**
 * Represents single note as a response for the client.
 *
 * @param id Unique note identifier.
 * @param name Note name.
 * @param content Path to note content.
 * @param creationDate Date of note creation.
 * @param modificationDate Date of note last modification.
 */
public record NoteResponseDto(
    Long id,
    String name,
    String content,
    LocalDateTime creationDate,
    LocalDateTime modificationDate) {}
