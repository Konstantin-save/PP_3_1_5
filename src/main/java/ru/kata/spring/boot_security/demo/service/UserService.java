
//-----------------классы c сервисами для моделей-----------------

package ru.kata.spring.boot_security.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import java.util.*;

//-----по email пользователя предоставляет самого юзера---
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;      //объявл поля для обращения к методам userRepository
    private final PasswordEncoder passwordEncoder;      //объявл поля для обращения к методам passwordEncoder

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {  //внедрение зависим. от репозитория для получения инф из Бд
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  //на входе имя польз, и надо по нему вернуть самого юзера из базы
        User user = userRepository.findByEmail(username);                       //достаем из БД польз по email
        if (user == null) {                                      //если нет - ошибка
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user; //возвр нового юзера и кладем в него нашего с данными и в лист
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @Transactional
    public void saveUser(User user) {
        User userFromDB = userRepository.findByEmail(user.getUsername());
        user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    @Transactional
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
        userRepository.save(user);
    }
    @Transactional
    public User getUser(String email) {
        return userRepository.findByEmail(email);      //возвращает юзера
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Transactional
    public User getUserById(Long id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return userFromDb.orElseThrow(RuntimeException::new);
    }
}