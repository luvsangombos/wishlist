package projects.wishlist.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import projects.wishlist.model.User;

@Service
public class Helper {

    @Autowired
    private UserService userService;
    public User currentUser(Authentication authentication){
        return userService.findByUserName(authentication.getName());
    }
}
