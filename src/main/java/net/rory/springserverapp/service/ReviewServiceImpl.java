package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.ReviewDao;
import net.rory.springserverapp.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Override
    public List<Review> getAllReviews() {
        return reviewDao.loadReviews();
    }

    @Override
    public void saveReview(Review review) {
        reviewDao.saveAndFlush(review);
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
