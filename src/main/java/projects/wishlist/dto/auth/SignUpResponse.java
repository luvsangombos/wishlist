package projects.wishlist.dto.auth;

import org.springframework.http.HttpStatus;

public record SignUpResponse(
        HttpStatus code,
        String message
) {
}
