package ru.geekbrains.autumnmarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.autumnmarket.entity.User;

import java.util.Optional;

@Repository
public interface UsersRepo extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
