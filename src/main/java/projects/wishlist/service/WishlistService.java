package projects.wishlist.service;

import projects.wishlist.dto.wishlist.WishlistRequest;
import projects.wishlist.model.User;
import projects.wishlist.model.Wish;
import projects.wishlist.model.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist save(WishlistRequest wishlist, User user);
    List<Wishlist> getUserWishlist(Integer id);
}
