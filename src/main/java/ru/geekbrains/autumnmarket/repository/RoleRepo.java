package ru.geekbrains.autumnmarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.autumnmarket.entity.Role;
@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
}
