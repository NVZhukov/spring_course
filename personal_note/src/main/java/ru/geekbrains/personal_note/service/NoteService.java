package ru.geekbrains.personal_note.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.personal_note.model.Note;
import ru.geekbrains.personal_note.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс для работы с заметками
 */
@Service
@RequiredArgsConstructor
public class NoteService {

    /**
     * Объект NoteRepository
     */
    private final NoteRepository noteRepository;

    /**
     * Метод добавления новой заметки
     * @param note объект заметки
     * @return добавленная заметка
     */
    public Note createNote(Note note) {
        LocalDateTime time = LocalDateTime.now();
        note.setCreated(time);
        return noteRepository.save(note);
    }

    /**
     * Метод получения списка всех заметок
     * @return список всех заметок
     */
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }


    /**
     * Метод получения заметки по уникальному идентификатору
     * @param id уникальный идентификатор
     * @return объект заметки
     */
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Note not found with id: " + id));
    }

    /**
     * Метод обновления заметки
     * @param note объект заметки
     * @return обновленная заметка
     */
    public Note updateNote(Note note) {
        Note newNote = getNoteById(note.getId());
        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        return noteRepository.save(newNote);
    }

    /**
     * Метод удаления заметки
     * @param id уникальный идентификатор
     */
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
