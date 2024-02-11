package ru.geekbrains.webclient.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webclient.model.User;

import java.util.List;

public interface RepositoryClient {

    @GetMapping
    List<User> getAll();

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user);

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id);
}
