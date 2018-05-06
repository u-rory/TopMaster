package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.ReviewDao;
import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.ReviewsParameter;
import net.rory.springserverapp.model.Spec;
import net.rory.springserverapp.model.SpecUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDao reviewDao;

    @Override
    public List<Review> getAllReviews() {
        return reviewDao.loadReviews();
    }

    @Override
    public List<Review> getSuitableReviews(String surname,
                                           String name,
                                           String otchestvo,
                                           String specName,
                                           String city,
                                           String address,
                                           Integer onCall) {
        return reviewDao.loadSuitableReviews(surname,
                name,
                otchestvo,
                specName,
                city,
                address,
                onCall);
    }

    @Override
    public void saveReview(Review review) {
        Date dateNow = new Date();
        review.setDatetime(dateNow);

        review.setStatus(0);

        List<ReviewsParameter> reviewsParameters = review.getReviewsParameters();

        for (int i = 0; i < reviewsParameters.size(); i++) {
            reviewsParameters.get(i).setReview(review);
        }

        review.setReviewsParameters(reviewsParameters);

        reviewDao.saveAndFlush(review);
    }

    @Override
    public void publishReview(Review review) {
        review.setStatus(1);

        reviewDao.save(review);
    }

    @Override
    public List<Review> getAllReviewsMod() {
        return reviewDao.loadReviewsMod();
    }

    @Override
    public List<Review> getUserReviewsById(Long id) {
        return reviewDao.loadUserReviews(id);
    }
}
