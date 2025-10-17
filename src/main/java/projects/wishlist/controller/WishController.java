package projects.wishlist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.wishlist.dto.wish.WishRequest;
import projects.wishlist.dto.wishlist.WishlistRequest;
import projects.wishlist.model.User;
import projects.wishlist.model.Wish;
import projects.wishlist.model.Wishlist;
import projects.wishlist.service.WishService;
import projects.wishlist.service.impl.Helper;

@RestController
@RequestMapping("/api")
public class WishController {

    @Autowired
    WishService service;

    @Autowired
    Helper helper;


    @PostMapping(value = "/wish")

    public ResponseEntity<Wish> createWish(@RequestBody WishRequest wish) {
        Wish newWish = service.save(wish);
        return new ResponseEntity<Wish>(newWish, HttpStatus.OK);
    }

}
