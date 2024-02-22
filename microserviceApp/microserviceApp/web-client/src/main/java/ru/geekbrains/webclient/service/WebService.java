package ru.geekbrains.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.webclient.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate template;

    public List<User> getUserList() {
        ResponseEntity<List<User>> response = template.exchange(
                "http://localhost:8081/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public User getNote(Long id) {
        ResponseEntity<User> response = template.exchange(
                "http://localhost:8081/users/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

//    public User save(Long id, String name, String lastName, String email) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        String url = "http://localhost:8081/users";
//        HttpMethod method;
//        User user = new User(name,lastName,email);
//        if (id != null) {
//            long noteId = id;
//            user.setId(noteId);
//            url += "/" + noteId;
//            method = HttpMethod.PUT;
//        } else {
//            method = HttpMethod.POST;
//        }
//        HttpEntity<User> entity = new HttpEntity<>(user, headers);
//        ResponseEntity<User> response = template.exchange(url, method, entity, User.class);
//        return response.getBody();
//    }

}
