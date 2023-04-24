package team.zavod.handy.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.zavod.handy.entity.note.Note;
import team.zavod.handy.entity.note.Operation;

import java.util.List;

@SpringBootTest
@Transactional
public class NoteServiceTest {
    @Autowired
    private NoteService noteService;

    @Test
    void testGetAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        Assertions.assertNotNull(notes);
    }

    @Test
    void testGetNoteById() {
        Note newNote = new Note();
        noteService.saveNote(newNote);

        Note note = noteService.getNoteById(newNote.getId());
        Assertions.assertNotNull(note);
        Assertions.assertEquals(newNote.getId(), note.getId());
    }

    @Test
    void testSaveNote() {
        Note note = new Note();
        note.setName("New Note");
        note.setContent("This is a new note");
        noteService.saveNote(note);
        Note savedNote = noteService.getNoteById(note.getId());
        Assertions.assertNotNull(savedNote);
        Assertions.assertEquals("New Note", savedNote.getName());
        Assertions.assertEquals("This is a new note", savedNote.getContent());
    }

    @Test
    void testApplyOperation() {
        Note note = new Note();
        note.setName("New Note");
        note.setContent("First Note");
        noteService.saveNote(note);

        Operation operation = new Operation();
        operation.setType("insert");
        operation.setPosition(0);
        operation.setValue("This is a new line\n");
        operation.setNote(note);

        noteService.applyOperation(operation);

        Note updatedNote = noteService.getNoteById(note.getId());
        Assertions.assertNotNull(updatedNote);
        Assertions.assertEquals("This is a new line\nFirst Note", updatedNote.getContent());
    }
}