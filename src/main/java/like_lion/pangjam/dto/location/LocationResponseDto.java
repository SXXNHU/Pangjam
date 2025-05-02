package like_lion.pangjam.dto.location;
import java.util.List;

import like_lion.pangjam.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LocationResponseDto {

    private List<LocationInfo> locations;

    @Getter @Builder
    public static class LocationInfo
    {
        private int locationId;
        private String name;
        private String category;
        private double averageRating;
        private String phone;

        public static LocationResponseDto.LocationInfo from(Location location) {
            return LocationResponseDto.LocationInfo.builder()
                    .locationId(location.getLocationId())
                    .name(location.getName())
                    .category(location.getCategory())
                    .averageRating(location.getAverageRating())
                    .phone(location.getPhone())
                    .build();
        }
    }

    //상세정보 : 이름, 주소, 거리, 평균 평점, 카테고리, 번호
    @Getter @Builder
    public static class Detail
    {
        private int locationId;
        private String name;
        private String address;
        private String distance;
        private double averageRating;
        private String category;
        private String phone;

        private List<Reviews> review;

        @Getter @Builder
        public static class Reviews{
            private String nickname;
            private String content;
            private Double rating;
            private String createdAt;
        }

    }
}
