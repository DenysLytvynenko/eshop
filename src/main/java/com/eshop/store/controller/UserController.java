package com.eshop.store.controller;

import com.eshop.store.entities.db.User;
import com.eshop.store.repo.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init(){

    }
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> list() {
        return repository.findAll();
    }
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@Valid @RequestBody User user) {
        user.setId(ObjectId.get().toString());
        repository.save(user);
/*        String userId = repository.save(User.builder().login(user.login)
                .firstName(user.firstName)
                .lastName(user.lastName)
                .password(user.password)
                .name(user.name)
                .build()).id;*/
        return user;
   }
}
