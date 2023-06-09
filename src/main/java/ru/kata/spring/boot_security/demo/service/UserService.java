
//-----------------классы c сервисами для моделей-----------------


package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
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

