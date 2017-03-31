package by.kohanova.service;


import by.kohanova.model.News;

import java.util.List;

public interface NewsService {

    List<News> findAll();

    News update(News object);

    List<News> findById(Integer id);
}

