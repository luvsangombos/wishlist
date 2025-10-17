package projects.wishlist.service;

import projects.wishlist.dto.wishlist.WishlistRequest;
import projects.wishlist.model.User;
import projects.wishlist.model.Wishlist;

public interface WishlistService {
    Wishlist save(WishlistRequest wishlist, User user);
}
