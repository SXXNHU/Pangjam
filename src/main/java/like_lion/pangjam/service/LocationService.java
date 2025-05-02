package like_lion.pangjam.service;

import like_lion.pangjam.domain.Location;
import like_lion.pangjam.domain.LocationReview;
import like_lion.pangjam.dto.location.LocationResponseDto;
import like_lion.pangjam.repository.LocationRepository;
import like_lion.pangjam.repository.LocationReviewRepository;
import like_lion.pangjam.utility.LocationConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationReviewRepository locationReviewRepository;

    //전체 리스트 조회
    public LocationResponseDto getAllLocation(){
        List<Location> locations = locationRepository.findAll();
        return LocationConverter.toLocationResponseDTO(locations);
    }

    //상세정보 조회
    public LocationResponseDto.Detail getLocationDetail(int locationId){
        Location location = locationRepository.findById(locationId).orElse(null);

        List<LocationReview> locationReviews = locationReviewRepository.findTop5ByLocation_LocationIdOrderByCreatedAtDesc(locationId);

        return LocationResponseDto.Detail.from(location,locationReviews);
    }

    /*

    // 상세 정보 조회
    public LocationResponseDto getLocationDetail(int locationId){
        Location location = locationRepository.findById(locationId).orElse(null);

        List<LocationReview> locationReviews = locationReviewRepository.findTop3ByLocation_LocationIdOrderByCreatedAtDesc(locationId);

        //3번에 대한 Detail 전부 가져와서 넣어줘야지.


        return LocationResponseDto();
    }




    //utility 위치를 어디에 둘까요
    //반환값 변환 : List<Location> -> ResponseDto
    public LocationResponseDto convertToDto(List<Location> locations){

    }
     */
}
