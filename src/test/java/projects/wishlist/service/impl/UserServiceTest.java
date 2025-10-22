package projects.wishlist.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import projects.wishlist.error.custom.UserNotFoundException;
import projects.wishlist.model.User;
import projects.wishlist.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findByUsername_shouldReturnUser_whenExists() {
        User user = new User();
        user.setUsername("test");
        when(userRepository.findUserByUsername("test")).thenReturn(Optional.of(user));

        User result = userService.findByUserName("test");

        assertNotNull(result);
        assertEquals("test", result.getUsername());
    }

    @Test
    void findByUsername_shouldThrow_whenUserNotFound() {
        when(userRepository.findUserByUsername("Invalid")).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.findByUserName("Invalid"));
    }
}