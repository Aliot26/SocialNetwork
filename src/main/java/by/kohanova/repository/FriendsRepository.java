package by.kohanova.repository;

import by.kohanova.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {
    /**
     * Find {@link Friends} by user id from database
     * @param id
     * @return list of {@link Friends}
     */
    @Query("select f from Friends f where f.user1.id = :id")
    List<Friends> findById(@Param("id") Integer id);
}
