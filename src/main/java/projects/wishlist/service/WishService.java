package projects.wishlist.service;

import projects.wishlist.dto.wish.WishRequest;
import projects.wishlist.model.Wish;

import java.util.List;

public interface WishService {
    Wish save(WishRequest wish);

}
