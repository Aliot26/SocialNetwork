package by.kohanova;

import by.kohanova.model.User;
import by.kohanova.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private User user;

    @Test
    public void test() {
        Assert.assertNotNull(userService);
    }

    @Test
    public void testCreateAndDeleteUser() {
        user = new User();
        user.username = "Test";
        user.password = "1111";
        user.firstname = "Test";
        user.surname = "Test";
        user.photo = "Test";
        userService.create(user);
        userService.delete(user.id);
    }

    @Test
    public void testFindByUsername() {
        User user = userService.findByUsername("Olga");
        assertEquals("Olga", user.firstname);
        assertEquals("Olga", user.surname);
    }
}