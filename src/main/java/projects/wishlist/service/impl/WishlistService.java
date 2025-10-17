package projects.wishlist.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.wishlist.dto.wishlist.WishlistRequest;
import projects.wishlist.model.User;
import projects.wishlist.model.Wishlist;
import projects.wishlist.repository.WishlistRepository;

@Service
public class WishlistService implements projects.wishlist.service.WishlistService {
    @Autowired
    WishlistRepository wishlistRepository;


    public Wishlist save(WishlistRequest wishlist, User user) {
        Wishlist newWishlist = Wishlist.builder()
                .name(wishlist.name())
                .emoji(wishlist.emoji())
                .owner(user)
                .build();
        return wishlistRepository.save(newWishlist);
    }
}
