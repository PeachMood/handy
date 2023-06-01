package team.zavod.handy.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team.zavod.handy.model.converter.note.NoteRequestConverter;
import team.zavod.handy.model.converter.note.NoteResponseConverter;
import team.zavod.handy.model.dto.note.NoteResponseDto;
import team.zavod.handy.model.dto.note.request.NoteCreateRequestDto;
import team.zavod.handy.model.dto.note.request.NoteUpdateRequestDto;
import team.zavod.handy.model.entity.note.Note;
import team.zavod.handy.model.entity.user.UserEntity;
import team.zavod.handy.service.NoteService;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteController {
  private final NoteService noteService;
  private final NoteRequestConverter requestConverter;
  private final NoteResponseConverter responseConverter;

  @Autowired
  public NoteController(
      NoteService noteService,
      NoteRequestConverter requestConverter,
      NoteResponseConverter responseConverter) {
    this.noteService = noteService;
    this.requestConverter = requestConverter;
    this.responseConverter = responseConverter;
  }

  @GetMapping
  public ResponseEntity<List<NoteResponseDto>> getAllNotes(
      @AuthenticationPrincipal UserEntity user) {
    List<NoteResponseDto> notes =
        noteService.findAllUserNotes(user, Note.class).stream()
            .map(responseConverter::convert)
            .toList();
    return ResponseEntity.ok(notes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<NoteResponseDto> getNote(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserEntity user) {
    Note note = noteService.findUserNote(user, id, Note.class);
    if (note == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(responseConverter.convert(note));
    }
  }

  @PostMapping
  public ResponseEntity<NoteResponseDto> createNote(
      @Valid @RequestBody NoteCreateRequestDto noteDto, @AuthenticationPrincipal UserEntity user) {
    Note note = requestConverter.convert(noteDto);
    note.setUser(user);

    note = noteService.createNote(note);
    NoteResponseDto noteResponseDto = responseConverter.convert(note);
    return ResponseEntity.status(HttpStatus.CREATED).body(noteResponseDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<NoteResponseDto> updateNote(
      @PathVariable("id") Long id,
      @Valid @RequestBody NoteUpdateRequestDto noteDto,
      @AuthenticationPrincipal UserEntity user) {
    Note note = noteService.findUserNote(user, id, Note.class);
    if (note == null) {
      return ResponseEntity.notFound().build();
    } else {
      if (noteDto.getName() != null) {
        note.setName(noteDto.getName());
      }
      if (noteDto.getContent() != null) {
        note.setContent(noteDto.getContent());
      }
      noteService.updateNote(note);
      return ResponseEntity.ok(responseConverter.convert(note));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteNote(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserEntity user) {
    Note note = noteService.findUserNote(user, id, Note.class);
    if (Objects.isNull(note)) {
      return ResponseEntity.notFound().build();
    }

    if (noteService.deleteNote(note.getId())) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
