package ru.kata.spring.boot_security.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	//Controller обрабатывает запросы (при наличии Service работает только с ним)
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String showAllUsers(Model model, Principal principal) {
		List<User> allUsers = userService.getAllUser();       //результ помещаем в лист, на сервисе вызываем метод(в итоге он срабатывает из Dao)
		model.addAttribute("users", allUsers);  // в модель добавляем атрибут, у которого значение-все люди. View возьмет из AllEmps инф для отображения в браузере
		model.addAttribute("user", userService.getUser(principal.getName())); //

		return "user";
	}
}
