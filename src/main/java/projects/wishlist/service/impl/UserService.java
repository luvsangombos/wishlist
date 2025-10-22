package projects.wishlist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.wishlist.error.custom.UserNotFoundException;
import projects.wishlist.model.User;
import projects.wishlist.repository.FriendsRepository;
import projects.wishlist.repository.UserRepository;

import java.util.Optional;


@Service
public class UserService implements projects.wishlist.service.UserService {


    @Autowired
    private UserRepository userRepository;


    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.userRepository.existsUserByUsername(username);
    }

    @Override
    public User findByUserName(String username) {
        Optional<User> user = this.userRepository.findUserByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }else {
            throw new UserNotFoundException("User not found");
        }
    }


}
