package net.rory.springserverapp.service;


import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.SpecUser;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    List<Review> getSuitableReviews(String surname,
                                    String name,
                                    String otchestvo,
                                    String specName,
                                    String city,
                                    String address,
                                    Integer onCall);

    void saveReview(Review review);

    void publishReview(Review review);

    List<Review> getAllReviewsMod();

    List<Review> getUserReviewsById(Long id);
}
