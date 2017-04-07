package by.kohanova.controller;

import by.kohanova.model.Friends;
import by.kohanova.model.FriendsIds;
import by.kohanova.model.Role;
import by.kohanova.model.User;
import by.kohanova.service.FriendsService;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;
    private final UserService userService;

    @Autowired
    public FriendsController(FriendsService friendsService, UserService userService) {
        this.friendsService = friendsService;
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createFriends(@RequestBody FriendsIds friendsIds) {
        try {
            Integer currentId = friendsIds.current_id;
            Integer friendId = friendsIds.friend_id;
            User currentUser = userService.findById(currentId);
            User friendUser = userService.findById(friendId);
            Friends friends = new Friends();
            friends.user1 = currentUser;
            friends.user2 = friendUser;
            friends.status = false;
            friendsService.create(friends);

            return new ResponseEntity<>(new Friends(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/requested/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> loadRequestedFriendsById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(friendsService.findByFriendId(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFriends(@RequestBody FriendsIds friendsIds) {
        try {
            Integer id1 = friendsIds.current_id;
            Integer id2 = friendsIds.friend_id;
            Friends friends = friendsService.findFriendByFriendId(id1, id2);
            friends.status = true;
            return new ResponseEntity<>(friendsService.update(friends), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Return list of all friends from database
     *
     * @return list of friends
     */
    @RequestMapping("/all")
    public List<Friends> loadAllFriends() {
        try {
//            User user1 = userService.findByUsername("Olga");
//            User user2 = userService.findByUsername("Anna");
//
//            Friends friends = new Friends();
//            friends.user1 = user1;
//            friends.user2 = user2;
//            friends.status = false;
//
//            friendsService.create(friends);
            return friendsService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Find {@link Friends} by User id
     *
     * @param id {@link User}
     * @return list of friends
     */
    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> loadFriendsById(@PathVariable("id") Integer id) {
        try {

            return new ResponseEntity<>(friendsService.findById(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
