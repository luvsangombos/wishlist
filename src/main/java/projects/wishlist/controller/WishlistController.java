package projects.wishlist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.wishlist.dto.wishlist.WishlistRequest;
import projects.wishlist.model.User;
import projects.wishlist.model.Wishlist;
import projects.wishlist.service.WishlistService;
import projects.wishlist.service.impl.Helper;

@RestController
@RequestMapping("/api")
public class WishlistController {

    @Autowired
    private WishlistService service;
    @Autowired
    private Helper helper;

    @PostMapping(value = "/wishlist")
    public ResponseEntity<Wishlist> createNewWishList(Authentication authentication,@RequestBody WishlistRequest wishlist) {
        User current = helper.currentUser(authentication);
        System.out.println(wishlist.emoji());
        Wishlist saved = service.save(wishlist,current);
        return new ResponseEntity<Wishlist>(saved, HttpStatus.OK);
    }
}
