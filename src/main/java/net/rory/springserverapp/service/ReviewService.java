package net.rory.springserverapp.service;


import net.rory.springserverapp.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    void saveReview(Review review);

    List<Review> getAllReviewsMod();

    List<Review> getUserReviewsById(Long id);
}
