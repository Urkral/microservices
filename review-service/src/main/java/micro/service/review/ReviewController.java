package micro.service.review;

import micro.service.review.Review;
import micro.service.review.ReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // GET /reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // GET /reviews/{reviewId}
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /reviews/product/{productId}
    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    // POST /reviews -> create a review
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // DELETE /reviews/{reviewId} -> delete single review
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    // DELETE /reviews/product/{productId} -> delete all reviews for a product
    // (useful for composite’s "delete product" operation)
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteReviewsByProductId(@PathVariable Long productId) {
        reviewService.deleteReviewsByProductId(productId);
        return ResponseEntity.noContent().build();
    }
}
