package ru.geekbrains.storageuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.storageuser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
