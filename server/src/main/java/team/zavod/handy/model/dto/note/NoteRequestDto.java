package team.zavod.handy.model.dto.note;

/**
 * Represents single note as a request to the server.
 *
 * @param id Unique note identifier.
 * @param name Note name.
 */
public record NoteRequestDto(String name) {}
