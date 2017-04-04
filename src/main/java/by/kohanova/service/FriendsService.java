package by.kohanova.service;

import by.kohanova.model.Friends;
import by.kohanova.model.User;

import java.util.List;

public interface FriendsService {

    /**
     * Find all {@link Friends} from database
     *
     * @return list of {@link Friends}
     */
    List<Friends> findAll();

    /**
     * Create and save {@link Friends} in database
     *
     * @param friends
     */
    Friends create(Friends friends);

    /**
     * Find list of {@link Friends} by {@link User} id in database
     *
     * @param id
     * @return list {@link Friends}
     */
    List<Friends> findById(Integer id);
}
