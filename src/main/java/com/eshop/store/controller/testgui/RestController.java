package com.eshop.store.controller.testgui;

import com.eshop.store.entities.User;
import com.eshop.store.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RestController {

    private final UserRepository userRepo;

    @Autowired
    public RestController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(
            value = "/api/rest",
            method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @RequestMapping(
            value = "/api/rest",
            method = RequestMethod.PUT)
    @ResponseBody
    public List<User> ormInsertUserById(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "name") String name
    ) {
        User user = User.builder()
                .login(login)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .name(name)
                .build();

        userRepo.save(user);
        return userRepo.findAll();
    }

    @RequestMapping(
            value = "/api/rest",
            method = RequestMethod.DELETE)
    @ResponseBody
    public List<User>  ormDeleteUserById(@RequestParam(value = "id") String id) {
        userRepo.deleteById(id);
        return userRepo.findAll();
    }

}
