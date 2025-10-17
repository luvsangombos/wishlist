package projects.wishlist.service;

import projects.wishlist.dto.wish.WishRequest;
import projects.wishlist.model.Wish;

public interface WishService {
    Wish save(WishRequest wish);
}
