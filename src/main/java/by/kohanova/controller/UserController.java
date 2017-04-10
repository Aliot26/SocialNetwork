package by.kohanova.controller;

import by.kohanova.model.Friends;
import by.kohanova.model.Role;
import by.kohanova.model.Token;
import by.kohanova.model.User;
import by.kohanova.security.TokenService;
import by.kohanova.service.FriendsService;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * User Controller for {@link UserService}
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;
    private final FriendsService friendsService;

    @Autowired
    public UserController(UserService userService, FriendsService friendsService,
                          TokenService tokenService) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.friendsService = friendsService;
    }

    /**
     * Create {@link User} in database from registration form
     *
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
     * Return list of users excluding admin, current user and confirmed friends
     */
    @RequestMapping(value = "/friends/{id}", method = RequestMethod.GET)
    public List<User> loadPossibleFriends(@PathVariable Integer id) {
        try {
            List<Friends> friendsListByCurrentUser = friendsService.findById(id);
            List<Friends> friendsListByRequestedUser = friendsService.findByFriendId(id);
            List<User> allUsers = userService.findAll();

            for (Friends friends : friendsListByCurrentUser) {
                allUsers.remove(friends.userBeta);
            }
            for (Friends friends : friendsListByRequestedUser) {
                allUsers.remove(friends.userAlfa);
            }

            for (Iterator<User> iter = allUsers.listIterator(); iter.hasNext(); ) {
                User user = iter.next();
                if (Objects.equals(user.id, id) ||user.roles.get(0).id != 2){
                    iter.remove();
                }
            }
            return allUsers;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Update {@link User} info in database
     *
     * @return http response with http status code
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            Role role = new Role();
            role.id = 2;
            user.roles.add(role);
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Find {@link User} by username in database
     */
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> loadUserByUsername(@PathVariable String username) {
        try {
            return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete {@link User} by id from database
     *
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
