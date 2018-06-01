package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.ReviewDao;
import net.rory.springserverapp.dto.ReviewDto;
import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.ReviewsParameter;
import net.rory.springserverapp.model.Spec;
import net.rory.springserverapp.model.SpecUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDao reviewDao;

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviewList = reviewDao.loadReviews();

        List<ReviewDto> reviewDtoList = new ArrayList<>();

        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getSpecUser() == null) {
                reviewDtoList.add(new ReviewDto(reviewList.get(i).getIdReview(),
                        reviewList.get(i).getUser(),
                        reviewList.get(i).getSurname(),
                        reviewList.get(i).getName(),
                        reviewList.get(i).getOtchestvo(),
                        reviewList.get(i).getSpecName(),
                        reviewList.get(i).getCity(),
                        reviewList.get(i).getAddress(),
                        reviewList.get(i).getOnCall(),
                        reviewList.get(i).getDatetime(),
                        reviewList.get(i).getContent(),
                        reviewList.get(i).getReviewsParameters(),
                        reviewList.get(i).getStatus()));
            }
            else {
                reviewDtoList.add(new ReviewDto(reviewList.get(i).getIdReview(),
                        reviewList.get(i).getUser(),
                        reviewList.get(i).getSurname(),
                        reviewList.get(i).getName(),
                        reviewList.get(i).getOtchestvo(),
                        reviewList.get(i).getSpecName(),
                        reviewList.get(i).getCity(),
                        reviewList.get(i).getAddress(),
                        reviewList.get(i).getOnCall(),
                        reviewList.get(i).getDatetime(),
                        reviewList.get(i).getContent(),
                        reviewList.get(i).getReviewsParameters(),
                        reviewList.get(i).getStatus(),
                        reviewList.get(i).getSpecUser().getIdUser()));
            }
        }

        return reviewDtoList;
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
    public void deleteReview(Long id) {
        reviewDao.delete(id);
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
