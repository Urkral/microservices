package micro.service.review;

import micro.service.review.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final List<Review> reviews = List.of(
            new Review(1L, 101L, "Ritchie", "Amazing product", "A fucking masterpiece and best thing created since drunk driving."),
            new Review(1L, 102L, "Boberito Estebanito", "Pretty good", "I gooned three times in a row in front of this product."),
            new Review(2L, 201L, "Collepat Kepat Prekupat Kupat Kepet Kupot", "Not bad", "Works fine on my DragonOS_Noble_R7.iso")
    );

    public List<Review> getAllReviews() {
        return reviews;
    }

    public Optional<Review> getReviewById(Long reviewId) {
        return reviews.stream()
                .filter(r -> r.getReviewId().equals(reviewId))
                .findFirst();
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviews.stream()
                .filter(r -> r.getProductId().equals(productId))
                .collect(Collectors.toList());
    }
}
