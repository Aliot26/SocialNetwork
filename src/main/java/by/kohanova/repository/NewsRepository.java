package by.kohanova.repository;

import by.kohanova.model.News;
import by.kohanova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JpaRepository for working with news table
 */
public interface NewsRepository extends JpaRepository<News, Integer> {

    /**
     * Find {@link News} by user id from database
     * @param id
     * @return list of {@link News}
     */
    @Query("select n from News n where n.user.id = :id")
    List<News> findById(@Param("id") Integer id);
}
