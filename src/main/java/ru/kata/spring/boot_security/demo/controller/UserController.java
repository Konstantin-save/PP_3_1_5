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
public class UserController {                                   //Controller обрабатывает запросы (при наличии Service работает только с ним)

	@RequestMapping(value = "/")
	public String showAllUsers(Principal principal, Model model) {

		if(principal == null ) {
			return "redirect:/login";
		}

		String name = principal.getName();

		switch (name) {
			case "user":
				return "redirect:/user";

			case "admin":
				return "redirect:/admin";
		}
		return name;
	}

    @Autowired
    UserService userService;

	@RequestMapping(value = "/user")
	public String showAllUsers(Model model) {
		List<User> allUsers = userService.getAllUser();       //результ помещаем в лист, на сервисе вызываем метод(в итоге он срабатывает из Dao)
		model.addAttribute("users", allUsers);  // в модель добавляем атрибут, у которого значение-все люди. View возьмет из AllEmps инф для отображения в браузере
		model.addAttribute("user", new User());

		return "user";
	}


}













//
//	@PostMapping("/user/add")
//	public String addNewUser(@ModelAttribute("user") User user, Model model) {           //метод добавление юзера
//
//		model.addAttribute("user", user);  // и помещаем в Модель
//		userRepository.addUser(user);
//		return "redirect:/";
//	}
//
//	@PostMapping("/user/update/{id}")                                        //метод добавления id в кнопку
//	public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user, Model model) {
//		user.setId(id);
//		userRepository.saveUser(user);
//		return "redirect:/";                                                      //переиспользуем "user-info"
//	}
//
//	@PostMapping("/user/delete/{id}")
//	public String deleteUser(@PathVariable("id") long id) {
//		userRepository.deleteUser(id);
//		return "redirect:/";                                       //переадресование на "/"(отвеч за view котор выводит всех на экран) т.к. должен выйти обновленный мписок юзеров
//	}
//}
//














//	}
//	private User createMockUser() {
//		User user = new User();
//		user.setId(1);
//		user.setLastName("kot");
//		user.setEmail("kot@mail.ru");
//		return user;
//	}











	//	private Pzzz
//	@GetMapping()
//	public String index(Model model) {
//		//получим всех людей из Dao и передадим на отображение в представление и отбразим с помощью tamlif
//	return null;
//	}
//	@GetMapping("/{id}")
//	public String show(@PathVariable("id") int id, Model model) {
//		//получим одного человека из Dao и передадим на отображение в представление и отбразим с помощью tamlif
//		return null;
//	}














