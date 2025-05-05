package like_lion.pangjam.utility;

import like_lion.pangjam.domain.LocationReview;
import like_lion.pangjam.dto.locationReview.LocationReviewResponseDto;

public class LocationReviewConverter {
    public static LocationReviewResponseDto toDto(LocationReview locationReview) {
        return LocationReviewResponseDto.builder()
                .rating(locationReview.getRating())
                .content(locationReview.getContent())
                .nickname(locationReview.getNickname())
                .createdAt(locationReview.getCreatedAt().toString())
                .build();
    }
}
