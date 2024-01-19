package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.utilits.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Репозиторий для запросов к БД
 */
@Repository
public class UserRepository {

    /*
    Объект подключения к БД.
     */
    private final JdbcTemplate jdbc;

    /*
    Конструктор класса.
    @param jdbc
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public User findUserById(int id) {
        String sql = "SELECT * FROM userTable WHERE id = ?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, new Object[]{id}, new UserMapper()).stream().findFirst().orElse(null);
    }

    /*
    Метод получения всех пользователей из БД.
    @return список пользователей
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    /*
    Метод сохранения пользователя в БД.
    @param User объект пользователя
    @return User с id
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /*
    Метод удаления пользователя из БД.
    @param уникальный идентификатор
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /*
    Метод обновления данных пользователя в БД.
    @param User с обновленными данными
     */
    public void updateUser(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}
