package com.eshop.store.repo;

import com.eshop.store.entities.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByLogin(String login);
    User findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByName(String name);
}
