package projects.wishlist.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import projects.wishlist.dto.auth.JwtResponse;
import projects.wishlist.dto.auth.LoginRequest;
import projects.wishlist.dto.auth.SignUpResponse;
import projects.wishlist.dto.user.CompleteProfileDto;
import projects.wishlist.model.User;
import projects.wishlist.service.UserService;
import projects.wishlist.service.impl.CustomUserDetailService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Operation(summary = "Get user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "returns user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(Authentication authentication) {
        User current = userService.findByUserName(authentication.getName());
        return new ResponseEntity<>(current, HttpStatus.OK);
    }


    @Operation(summary = "Complete user profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "returns user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("/user/{username}/complete")
    public ResponseEntity<User> completeProfile(@RequestBody CompleteProfileDto profile, @PathVariable String username) {
        User updated = userService.update(username, profile);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
