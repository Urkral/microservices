package micro.service.review;

import micro.service.review.Review;
import micro.service.review.ReviewEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review entityToApi(ReviewEntity entity);

    ReviewEntity apiToEntity(Review api);

    List<Review> entityListToApiList(List<ReviewEntity> entities);
}
