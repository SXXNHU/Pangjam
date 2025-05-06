package like_lion.pangjam.service;

import like_lion.pangjam.domain.Review;
import like_lion.pangjam.dto.review.ReviewRequestDto;
import like_lion.pangjam.dto.review.ReviewResponseDto;
import like_lion.pangjam.repository.ReviewRepository;
import like_lion.pangjam.utility.ReviewConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 생성
    public ReviewResponseDto createReview(ReviewRequestDto reviewRequestDto){

        Review review = ReviewConverter.toEntity(reviewRequestDto);
        Review savedReview = reviewRepository.save(review);

        return ReviewConverter.toReviewRequestDto(savedReview);
    }


    //리뷰 전체 조회
    public List<ReviewResponseDto> getReviews(int reviewId, Pageable pageable)
    {
        List<Review> reviews = reviewRepository.findAll();

        return reviews.stream()
                .map(ReviewConverter::toReviewRequestDto)
                .toList();
    }
}