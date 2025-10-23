package projects.wishlist.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.wishlist.dto.wishlist.WishlistRequest;
import projects.wishlist.error.custom.UserNotFoundException;
import projects.wishlist.model.User;
import projects.wishlist.model.Wish;
import projects.wishlist.model.Wishlist;
import projects.wishlist.repository.UserRepository;
import projects.wishlist.repository.WishlistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService implements projects.wishlist.service.WishlistService {
    @Autowired
    WishlistRepository wishlistRepository;

    @Autowired
    UserRepository userRepository;


    public Wishlist save(WishlistRequest wishlist, User user) {
        Wishlist newWishlist = Wishlist.builder()
                .name(wishlist.name())
                .emoji(wishlist.emoji())
                .owner(user)
                .build();
        return wishlistRepository.save(newWishlist);
    }



    @Override
    public List<Wishlist> getUserWishlist(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }  else {
            List<Wishlist> wishlist = user.get().getWishlists();
            return wishlist;
        }
    }
}
