package by.kohanova.service;


import by.kohanova.model.News;
import by.kohanova.model.User;

import java.util.List;

/**
 * Service for {@link News}
 */
public interface NewsService {

    /**
     * Find all {@link News} from database
     *
     * @return list of {@link News}
     */
    List<News> findAll();

    /**
     * Edit {@link News} in database
     *
     * @param news
     * @return {@link News}
     */
    News update(News news);

    /**
     * Find list of {@link News} by {@link User} id in database
     *
     * @param id
     * @return list {@link News}
     */
    List<News> findById(Integer id);

    /**
     * Create and save {@link News} in database
     *
     * @param news
     */
    News create(News news);
}

