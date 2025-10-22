package projects.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.wishlist.model.User;

import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsUserByUsername(String username);
    Optional<User> findUserByUsername(String username);
}
