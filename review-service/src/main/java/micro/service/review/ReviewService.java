package micro.service.review;

import micro.service.review.Review;
import micro.service.review.ReviewEntity;
import micro.service.review.ReviewMapper;
import micro.service.review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    public ReviewService(ReviewRepository repository, ReviewMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Review> getAllReviews() {
        return mapper.entityListToApiList(repository.findAll());
    }

    public Optional<Review> getReviewById(Long reviewId) {
        return repository.findById(reviewId)
                .map(mapper::entityToApi);
    }

    public List<Review> getReviewsByProductId(Long productId) {
        List<ReviewEntity> entities = repository.findByProductId(productId);
        return mapper.entityListToApiList(entities);
    }

    public Review createReview(Review review) {
        ReviewEntity entity = mapper.apiToEntity(review);
        // ignore client-sent reviewId, let DB assign if null
        entity.setReviewId(null);
        ReviewEntity saved = repository.save(entity);
        return mapper.entityToApi(saved);
    }

    public void deleteReview(Long reviewId) {
        repository.deleteById(reviewId);
    }

    public void deleteReviewsByProductId(Long productId) {
        repository.deleteByProductId(productId);
    }
}
