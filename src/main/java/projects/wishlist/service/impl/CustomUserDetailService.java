package projects.wishlist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projects.wishlist.error.custom.UserNotFoundException;
import projects.wishlist.model.User;
import projects.wishlist.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);
        if(user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(),
                    user.get().getPassword(),
                    List.of(new SimpleGrantedAuthority(user.get().getRole().name()))
            );
        } else {
            throw new UserNotFoundException(username);
        }

    }


}
