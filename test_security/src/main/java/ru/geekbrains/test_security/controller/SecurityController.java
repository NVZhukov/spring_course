package ru.geekbrains.test_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Контроллер приложения.
 */
@Controller
public class SecurityController {

    /**
     * Домашняя страница.
     * @return представление домашней страницы.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * Домашняя страница.
     * @return перенаправление на представление домашней страницы.
     */
    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    /**
     * Страница для пользователей с ролью ADMIN.
     * @return представление приватной страницы.
     */
    @GetMapping("/private-data")
    public String admin() {
        return "private-data";
    }

    /**
     * Страница для пользователей с ролью USER.
     * @return представление публичной страницы.
     */
    @GetMapping("/public-data")
    public String user() {
        return "public-data";
    }
}
