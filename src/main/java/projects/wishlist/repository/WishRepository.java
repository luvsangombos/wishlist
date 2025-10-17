package projects.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.wishlist.model.Wish;

public interface WishRepository extends JpaRepository<Wish, Integer> {
}
