package projects.wishlist.service;

import projects.wishlist.model.User;
import projects.wishlist.model.Wishlist;

public interface UserService {
    public boolean existsByUsername(String username);
    public void save(User user);
    public User findByUserName(String username);
}
