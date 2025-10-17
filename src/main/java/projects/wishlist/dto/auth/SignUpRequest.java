package projects.wishlist.dto.auth;

import projects.wishlist.model.UserRole;

public record SignUpRequest(
        String username,
        String password,
        UserRole role
) {
}
