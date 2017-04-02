package by.kohanova.service;

import by.kohanova.model.User;

import java.util.List;

/**
 * Service for {@link User}
 */
public interface UserService {
    /**
     * Find all {@link User} from database
     *
     * @return list of {@link User}
     */
    List<User> findAll();

    /**
     * Find first of {@link User} by username in database
     *
     * @param username
     * @return {@link User}
     */
    User findByUsername(String username);

    /**
     * Create and save {@link User} in database
     *
     * @param user
     */
    User create(User user);

    /**
     * Edit {@link User} in database
     *
     * @param user
     * @return {@link User}
     */
    User update(User user);

    /**
     * Delete {@link User} by id from database
     *
     * @param id
     */
    void delete(Integer id);
}