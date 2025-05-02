package like_lion.pangjam.utility;

import like_lion.pangjam.domain.Location;
import like_lion.pangjam.domain.LocationReview;
import like_lion.pangjam.dto.location.LocationResponseDto;
import like_lion.pangjam.repository.LocationReviewRepository;

import java.util.List;

public class LocationConverter {

    private static LocationReviewRepository locationReviewRepository;

    public static LocationResponseDto toLocationResponseDTO(List<Location> locations) {
        List<LocationResponseDto.LocationInfo> locationInfos = locations.stream()
                .map(LocationResponseDto.LocationInfo::from)
                .toList();

        return new LocationResponseDto(locationInfos);
    }

    public static LocationResponseDto.Detail toDetailDTO(Location location) {
        List<LocationReview> locationReviews = locationReviewRepository.findTop5ByLocation_LocationIdOrderByCreatedAtDesc(location.getLocationId());
        return LocationResponseDto.Detail.from(location,locationReviews);
    }
}