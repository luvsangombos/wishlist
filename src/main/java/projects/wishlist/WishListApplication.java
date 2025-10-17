package projects.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class WishListApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishListApplication.class, args);
    }

}
