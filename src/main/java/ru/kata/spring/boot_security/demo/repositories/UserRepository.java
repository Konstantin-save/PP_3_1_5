
//-----------------интерфейсы репозиториев---------------------


package ru.kata.spring.boot_security.demo.repositories;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

//__запросы к БД__

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "roles")
    User findByEmail(String email);    //ищем по email

    User getUserById(Long id);    //ищем по id
}

