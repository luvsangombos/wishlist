package projects.wishlist.dto.user;

import java.time.LocalDate;

public record CompleteProfileDto(
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate dateOfBirth,
        String profileImg
) {
}
