package com.example.recommendation_service;

import com.example.recommendation_service.Recommendation;
import com.example.recommendation_service.RecommendationDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    Recommendation documentToApi(RecommendationDocument doc);

    RecommendationDocument apiToDocument(Recommendation api);

    List<Recommendation> documentListToApiList(List<RecommendationDocument> docs);
}
