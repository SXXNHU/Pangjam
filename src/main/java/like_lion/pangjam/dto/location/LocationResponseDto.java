package like_lion.pangjam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class LocationResponseDTO {

    private List<LocationInfo> locations;

    @Getter @AllArgsConstructor
    public static class LocationInfo
    {
        private int locationId;
        private String category;
        private String name;
        private double averageRating;
        private String phone;
    }

    //상세정보 : 이름, 주소, 거리, 평균 평점, 카테고리, 번호
    @Getter
    public static class Detail
    {
        private int locationId;
        private String name;
        private String address;
        private String distance;
        private double averageRating;
        private String category;
        private String phone;
    }
}
