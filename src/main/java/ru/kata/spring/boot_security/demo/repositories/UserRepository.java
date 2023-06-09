
//-----------------интерфейсы репозиториев---------------------


package ru.kata.spring.boot_security.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

//__запросы к БД__
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);                         //можно выполнять стандартные запросы к БД.
}
