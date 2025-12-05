package com.example.recommendation_service;

import com.example.recommendation_service.Recommendation;
import com.example.recommendation_service.RecommendationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    Recommendation entityToApi(RecommendationEntity entity);

    RecommendationEntity apiToEntity(Recommendation api);

    List<Recommendation> entityListToApiList(List<RecommendationEntity> entities);
}
