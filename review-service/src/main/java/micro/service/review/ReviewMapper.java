package micro.service.review;

import micro.service.review.Review;
import micro.service.review.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review entityToApi(ReviewEntity entity);

    @Mapping(target = "reviewId", ignore = true)
    ReviewEntity apiToEntity(Review api);

    List<Review> entityListToApiList(List<ReviewEntity> entities);
}
