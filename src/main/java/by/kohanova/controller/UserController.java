package by.kohanova.controller;

import by.kohanova.model.Details;
import by.kohanova.model.Role;
import by.kohanova.model.User;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/hello")
    public String hello() {
        String hello = "Hello Spring! It was written by Olga";
        return hello;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            user.photo = "";
//            Role role = new Role();
//            role.id = 1;
//            user.roles.add(role);

            System.out.println(user.username + " " + user.password);
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public void createUser(@RequestBody User user) {
//        try {
//            System.out.println(user.username+" "+user.password+" "+user.id);
//            userService.create(user);
//        } catch (NullPointerException e) {
//            System.out.println("Error of users created");
//        }
//    }

    @RequestMapping("/all")
    public List<User> loadAllUsers() {
        try {

//            User user = new User();
//            user.username = "asd";
//            user.password = "asd";
//            user.firstname = "qwe";
//            user.surname = "qwe";
//            user.photo = "123";
//            userService.create(user);

            return userService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
