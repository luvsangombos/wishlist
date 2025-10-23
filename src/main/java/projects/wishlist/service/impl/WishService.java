package projects.wishlist.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.wishlist.dto.wish.WishRequest;
import projects.wishlist.error.custom.UserNotFoundException;
import projects.wishlist.model.User;
import projects.wishlist.model.Wish;
import projects.wishlist.model.Wishlist;
import projects.wishlist.repository.UserRepository;
import projects.wishlist.repository.WishRepository;
import projects.wishlist.repository.WishlistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WishService implements projects.wishlist.service.WishService {

    @Autowired
    private WishRepository wishRepository;

    @Autowired

    private UserRepository userRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wish save(WishRequest wish){
        Optional<Wishlist> wishlist = wishlistRepository.findById(wish.wishlistId());
        if(wishlist.isPresent()){
            Wish newWish = Wish.builder()
                    .name(wish.name())
                    .image(wish.image())
                    .link(wish.link())
                    .description(wish.description())
                    .wishlist(wishlist.get())
                    .build();
            wishRepository.save(newWish);
            return newWish;
        }else {
            return null;
        }

    }


}
