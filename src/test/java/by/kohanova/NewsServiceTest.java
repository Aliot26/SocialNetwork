package by.kohanova;

import by.kohanova.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class NewsServiceTest {
    @Autowired
    private NewsService newsService;

    @Test
    public void test() {
        assertNotNull(newsService);
    }

    @Test
    public void testFindAllNews() {
        assertNotNull(newsService.findAll());
    }
}
