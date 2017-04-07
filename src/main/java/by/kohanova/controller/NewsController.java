package by.kohanova.controller;

import by.kohanova.model.Friends;
import by.kohanova.model.News;
import by.kohanova.model.User;
import by.kohanova.service.FriendsService;
import by.kohanova.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Controller for the {@link NewsService}
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;
    private final FriendsService friendsService;

    @Autowired
    public NewsController(NewsService newsService, FriendsService friendsService) {
        this.newsService = newsService;
        this.friendsService = friendsService;
    }

    /**
     * Return list of all news from database
     *
     * @return list of news
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<News> loadAll() {
        try {
            return newsService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Find {@link News} by User id
     *
     * @param id {@link User}
     * @return list of news
     */
    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> loadNewsById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Create {@link News} in datebase from news form
     *
     * @param news model
     * @return http response with http status code
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createNews(@RequestBody News news) {
        try {
            news.date = new Date();
            return new ResponseEntity<>(newsService.create(news), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateDetails(@RequestBody News news) {
        try {
            newsService.update(news);
        } catch (Exception e) {
            System.out.println("Error in updating user's news");
        }
    }

    /**
     * Delete {@link News} by id from database
     *
     * @param id
     * @return http response with http status code
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNews(@PathVariable("id") Integer id) {
        try {
            newsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/friends/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> loadNewsByFriends(@PathVariable("id") Integer id) {
        try {
            List<Friends> friendsList = friendsService.findById(id);
            List<News> newsList = new ArrayList<>();
            for (Friends friends : friendsList) {
                if (friends.status) {
                    List<News> friendNewsList = newsService.findById(friends.user2.id);
                    for (News news : friendNewsList) {
                        newsList.add(news);
                    }
                }
            }
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
