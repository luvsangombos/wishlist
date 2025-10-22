package projects.wishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import projects.wishlist.config.security.JwtUtil;
import projects.wishlist.dto.auth.JwtResponse;
import projects.wishlist.dto.auth.LoginRequest;
import projects.wishlist.dto.auth.SignUpRequest;
import projects.wishlist.dto.auth.SignUpResponse;
import projects.wishlist.model.User;
import projects.wishlist.service.UserService;
import projects.wishlist.service.impl.CustomUserDetailService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;




    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/public")
    public ResponseEntity<String> waitTenSeconds() throws InterruptedException {
        Thread.sleep(3000);
        return ResponseEntity.ok("Successfully waited 10 seconds");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest request) {
        if (userService.existsByUsername(request.username())) {
            return ResponseEntity.badRequest().body(new SignUpResponse(HttpStatus.BAD_REQUEST, "Username is already in use"));
        }

        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();

        userService.save(user);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        UserDetails userDetails = customUserDetailService.loadUserByUsername(request.username());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );
            UserDetails userDetails = customUserDetailService.loadUserByUsername(request.username());
            String token = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
    }
}
