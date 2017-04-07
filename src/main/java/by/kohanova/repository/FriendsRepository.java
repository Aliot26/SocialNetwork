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
    List<Friends> findByCurrentUserId(@Param("id") Integer id);

    @Query("select f from Friends f where f.user2.id = :id")
    List<Friends> findByFriendId(@Param("id") Integer id);

    @Query("select f from Friends f where f.user1.id = :id1 and f.user2.id = :id2")
    Friends findFriendByFriendId(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
