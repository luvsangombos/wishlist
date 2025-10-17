package projects.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.wishlist.model.Friends;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {
}
