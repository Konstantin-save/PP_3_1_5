
//---------------классы с контроллерами--------------------


package ru.kata.spring.boot_security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class AdminController {     //Controller обрабатывает запросы (при наличии Service работает только с ним)
    @GetMapping("/authenticated")
    public String pageForAutentikatedUsers() {
        return "secured...";
    }
}
