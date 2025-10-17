package projects.wishlist.dto.wish;

public record WishRequest(
        Integer wishlistId,
        String name,
        String description,
        String image,
        String link
) {
}
