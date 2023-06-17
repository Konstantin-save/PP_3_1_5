
//-----------------классы c сервисами для моделей-----------------


package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

//-----по email пользователя предоставляет самого юзера---
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;      //объявл поля для обращения к методам userRepository

    public UserService(UserRepository userRepository) {  //внедрение зависим. от репозитория для получения инф из Бд
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  //на входе имя польз, и надо по нему вернуть самого юзера из базы
        User user = userRepository.findByEmail(username);                       //достаем из БД польз по email
        if (user == null) {                                      //если нет - ошибка
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>()); //возвр нового юзера и кладем в него нашего с данными и в лист
    }


       public List<User> getAllUser() {
        return userRepository.findAll();
       }


    @Transactional
    public void saveUser(User user) {saveUser(user);              //вызывает метод saveUser из Dao
    }


    @Transactional
    public User getUser(long id) {
        return getUser(id);      //возвращает юзера
    }


    @Transactional
    public void deleteUser(long id) {
        deleteUser(id);

    }

    @Transactional
    public void addUser(User user) {
        addUser(user);
    }


    @Transactional
    public void removeUser(long id) {deleteUser(id);
    }


    @Transactional
    public User getUserById(long id) {
        return getUserById(id);
    }
   }











    //зависимость от Дао чтобы не создавать руками - для вызова метода из него
//    private final UserDao userDao;
//
//    @Autowired
//    public UserService(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> getAllUser() {
//        return userDao.getAllUser();
//    }
//
//    @Override
//    @Transactional
//    public void saveUser(User user) {
//        userDao.saveUser(user);              //вызывает метод saveUser из Dao
//    }
//
//    @Override
//    @Transactional
//    public User getUser(long id) {
//        return userDao.getUser(id);      //возвращает юзера
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(long id) {
//        userDao.deleteUser(id);
//
//    }
//
//    @Override
//    @Transactional
//    public void addUser(User user) {
//        userDao.addUser(user);
//    }
//
//    @Override
//    @Transactional
//    public void removeUser(long id) {
//        userDao.deleteUser(id);
//    }
//
//    @Override
//    @Transactional
//    public User getUserById(long id) {
//        return userDao.getUserById(id);
//    }









//    @Override
//    @Transactional
//    public List<User> getAllUsers() {
//        return userDao.getAllUsers();         //вызываем метод(в итоге он срабатывает из Dao)
//    }

