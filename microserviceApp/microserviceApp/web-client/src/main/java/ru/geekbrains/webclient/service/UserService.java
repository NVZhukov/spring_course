package ru.geekbrains.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.geekbrains.webclient.client.RepositoryClient;
import ru.geekbrains.webclient.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final RepositoryClient repository;

    public UserService(RepositoryClient repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public ResponseEntity<User> createUser(User user) {
        return repository.createUser(user);
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        repository.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
