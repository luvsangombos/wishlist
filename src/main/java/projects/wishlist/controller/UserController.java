package projects.wishlist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.wishlist.model.User;
import projects.wishlist.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(Authentication authentication) {
        User current = userService.findByUserName(authentication.getName());
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

}
