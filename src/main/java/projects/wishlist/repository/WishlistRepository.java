package projects.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.wishlist.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}
