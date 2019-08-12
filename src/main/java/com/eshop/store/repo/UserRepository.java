package com.eshop.store.repo;

import com.eshop.store.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByLogin(String login);
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public List<User> findByName(String name);
}
