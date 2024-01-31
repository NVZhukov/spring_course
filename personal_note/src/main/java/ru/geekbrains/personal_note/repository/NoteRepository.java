package ru.geekbrains.personal_note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.personal_note.model.Note;

import java.util.Optional;

/**
 * Интерфейс для упраления репозиторием заметок
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    /**
     * Метод получения заметки по уникальному идентификатору
     * @param id уникальный идентификатор
     * @return объект заметки
     */
    Optional<Note> findById(Long id);
}
