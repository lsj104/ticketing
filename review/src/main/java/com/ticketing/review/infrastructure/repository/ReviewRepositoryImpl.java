package com.ticketing.review.infrastructure.repository;

import com.ticketing.review.domain.model.Review;
import com.ticketing.review.domain.repository.ReviewRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryImpl extends JpaRepository<Review, UUID>, ReviewRepository {

  boolean existsByUserIdAndPerformanceId(long userId, UUID performanceId);

}
