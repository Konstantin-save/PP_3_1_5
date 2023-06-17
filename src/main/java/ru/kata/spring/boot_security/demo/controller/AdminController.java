
//---------------классы с контроллерами--------------------


package ru.kata.spring.boot_security.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {               //Controller обрабатывает запросы из фронта (при наличии Service работает только с ним)
    private final UserService userService;
    private final RoleService roleServiсe;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
    this.roleServiсe = roleService;
    this.userService = userService;
        }

    @RequestMapping(value = "/admin")
    public String showAllUsers(Principal principal, Model model) {
        List<User> allUsers = userService.getAllUser();       //результ помещаем в лист, на сервисе вызываем метод(в итоге он срабатывает из Dao)
        model.addAttribute("users", allUsers);    // в модель добавляем атрибут, у которого значение-все люди. View возьмет из AllEmps инф для отображения в браузере
        model.addAttribute("user", new User());

        return "admin";
    }
        //методы


//    @GetMapping("/admin")
//    public String admin() {
//        return "secured...";
//    }
}
