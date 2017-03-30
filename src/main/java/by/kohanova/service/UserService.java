package by.kohanova.service;

import by.kohanova.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User create(User user);

    User update(User user);

    void delete(Integer id);
}