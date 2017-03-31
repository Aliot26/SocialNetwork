package by.kohanova.controller;

import by.kohanova.model.News;
import by.kohanova.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<News> loadAll() {
        try {
            return newsService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> loadNewsById(@PathVariable("id") Integer id) {
        try {
            System.out.println(newsService.findById(id).size());
            return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateDetails(@RequestBody News news){
        try {
            newsService.update(news);
        } catch (Exception e) {
            System.out.println("Error in updating user's news");
        }
    }
}
