package like_lion.pangjam.controller;

import like_lion.pangjam.dto.locationReview.LocationReviewRequestDto;
import like_lion.pangjam.dto.locationReview.LocationReviewResponseDto;
import like_lion.pangjam.service.LocationReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location_reviews")
@RequiredArgsConstructor
public class LocationReviewController {

    private final LocationReviewService locationReviewService;

    //리뷰 생성
    @PostMapping
    public ResponseEntity<LocationReviewResponseDto> createReview(@RequestBody LocationReviewRequestDto reviewRequestDto) {
        return ResponseEntity.ok(locationReviewService.createReview(reviewRequestDto));
    }

    //리뷰 전체 조회
    @GetMapping("/{locationId}")
    public ResponseEntity<List<LocationReviewResponseDto>> getLocationReviews(@PathVariable int locationId,
                                                                        @RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "15") int size) {
        Pageable pageable = PageRequest.of(page,size);
        List<LocationReviewResponseDto> locationReviews = locationReviewService.getLocationReviews(locationId, pageable );
        return ResponseEntity.ok(locationReviews);
    }

}
