package projects.wishlist.error.custom;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String msg
) {
}
