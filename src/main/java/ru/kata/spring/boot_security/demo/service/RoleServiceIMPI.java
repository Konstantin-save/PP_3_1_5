package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.List;
@Service
public class RoleServiceIMPI implements RoleService { //RoleServiceIMPI предоставляет функциональность для работы с ролями
private final RoleRepository roleRepository;

    public RoleServiceIMPI(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();   //вызывает метод findAll() у roleRepository для извлечения всех ролей из базы данных.
    }
}
