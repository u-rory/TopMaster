package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.ReviewDao;
import net.rory.springserverapp.dao.SpecDao;
import net.rory.springserverapp.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Autowired
    SpecDao specDao;

    @Override
    public List<Review> getAllReviews() {
        return reviewDao.loadReviews();
    }

    @Override
    public void saveReview(Review review) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        review.setDatetime(formatForDateNow.format(dateNow));
        review.setStatus(0);
        review.setSpec(specDao.findSpecByName(review.getSpec().getNameSpec()));
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
