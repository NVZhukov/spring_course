package ru.geekbrains.SpringMVC2.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

/**
 * Контроллер рандомных чисел
 */
@Controller
public class RandomController {

    /**
     *{@value} внедрение внешний свойств из application.properties
     */
    @Value("${parameter.min:15}")
    private Integer minDefault;

    /**
     *{@value} внедрение внешний свойств из application.properties
     */
    @Value("${parameter.max:55}")
    private Integer maxDefault;


    /**
     * Метод получения представления простой страницы
     * @return представлениe простой страницы
     */
    @GetMapping("/page")
    public String simplePage() {
        return "simplePage";
    }

    /**
     * Метод отображения на странице значений с использованием Thymeleaf
     * @param model для передачи данных в представление
     * @return представление с рандомными значениями
     */
    @GetMapping("/random")
    public String random(Model model) {
        model.addAttribute("min", minDefault);
        model.addAttribute("max", maxDefault);
        model.addAttribute("number", new Random().nextInt(minDefault,maxDefault));
        return "random";
    }

    /**
     * Метод отображения на странице значений с использованием Thymeleaf
     * с передачей значений в URL запросе
     * @param min минимальное значение
     * @param max максимальное значение
     * @param model для передачи данных в представление
     * @return представление с рандомными значениями
     */
    @GetMapping("/random/{min}/{max}")
    public String randomMinMax(@PathVariable("min") int min,
                               @PathVariable("max") int max, Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", new Random().nextInt(min,max));
        return "random";
    }

    /**
     * Метод отображения на странице значений с использованием Thymeleaf
     * и @RequestParam для извлечения параметров запроса
     * @param min минимальное значение
     * @param max максимальное значение
     * @param model для передачи данных в представление
     * @return представление с рандомными значениями
     */
    @GetMapping("/random")
    public String randomMinMax2(@RequestParam("min") Integer min,
                               @RequestParam("max") Integer max, Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", new Random().nextInt(min,max));
        return "random";
    }
}
