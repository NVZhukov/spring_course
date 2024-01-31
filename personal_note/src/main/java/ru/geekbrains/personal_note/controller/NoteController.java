package ru.geekbrains.personal_note.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.personal_note.model.Note;
import ru.geekbrains.personal_note.service.NoteService;

import java.util.List;

/**
 * Контроллер заметок
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    /**
     * Объект NoteService
     */
    private final NoteService noteService;

    /**
     * Метод получения списка всех заметок
     * @return список всех заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    /**
     * Метод добавления новой заметки
     * @param note объект заметки
     * @return добавленная заметка
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    /**
     * Метод получения заметки по уникальному идентификатору
     * @param id уникальный идентификатор
     * @return объект заметки
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note noteById;
        try {
            noteById = noteService.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    /**
     * Метод обновления заметки
     * @param note объект заметки
     * @return обновленная заметка
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    /**
     * Метод удаления заметки
     * @param id уникальный идентификатор
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
