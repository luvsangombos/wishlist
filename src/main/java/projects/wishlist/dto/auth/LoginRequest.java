package projects.wishlist.dto.auth;

public record LoginRequest(
        String username,
        String password
) {
}
