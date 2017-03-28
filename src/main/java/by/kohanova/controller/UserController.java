package by.kohanova.controller;

import by.kohanova.model.Details;
import by.kohanova.model.Role;
import by.kohanova.model.User;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/all")
    public List<User> loadAllUsers() {
        try {
            return userService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> loadUserByUsername(@PathVariable String username) {
        try {
            User user = userService.findByUsername(username);
            System.out.println(user.firstname);

            return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
