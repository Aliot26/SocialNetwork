package by.kohanova.controller;

import by.kohanova.model.Friends;
import by.kohanova.model.User;
import by.kohanova.service.FriendsService;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
