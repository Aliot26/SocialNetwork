package by.kohanova.controller;

import by.kohanova.model.Friends;
import by.kohanova.model.Role;
import by.kohanova.model.Token;
import by.kohanova.model.User;
import by.kohanova.security.TokenService;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Controller for {@link UserService}
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public UserController(UserService userService, TokenService tokenService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @RequestMapping("/hello")
    public String hello() {
        String hello = "Hello Spring! It was written by Olga";
        return hello;
    }

    /**
     * Create {@link User} in datebase from registration form
     *
     * @param user model
     * @return http response with http status code
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            String token = addUser(user);
            user.password = "";
            return new ResponseEntity<>(new Token(token, user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Return list of all users from database
     *
     * @return list of users
     */
    @RequestMapping("/all")
    public List<User> loadAllUsers() {
        try {
            return userService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Update {@link User} in database
     *
     * @param user model
     * @return http response with http status code
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Find {@link User} by username in database
     *
     * @param username
     * @return {@link User} entity
     */
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

    /**
     * Delete {@link User} by id from database
     *
     * @param id
     * @return http response with http status code
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Add {@link User} object to database with base user role
     * @param user
     */
    private String addUser(User user) {
        user.photo = "";
        Role role = new Role();
        role.id = 2;
        user.roles.add(role);
        List<User> users = loadAllUsers();
        for (User userFromDB : users) {
            if (userFromDB.username.equals(user.username)) {
                return null;
            }
        }
        userService.create(user);
        return tokenService.generate(user, user.password);
    }
}
