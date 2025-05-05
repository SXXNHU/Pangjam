package like_lion.pangjam.repository;

import like_lion.pangjam.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.sampled.ReverbType;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
