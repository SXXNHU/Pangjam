package like_lion.pangjam.utility;

import like_lion.pangjam.domain.Location;
import like_lion.pangjam.dto.location.LocationResponseDto;

import java.util.List;

    public class LocationConverter {
        public static LocationResponseDto toLocationResponseDTO(List<Location> locations) {
            List<LocationResponseDto.LocationInfo> locationInfos = locations.stream()
                    .map(LocationResponseDto.LocationInfo::from)
                    .toList();

            return new LocationResponseDto(locationInfos);
        }
    }


}
