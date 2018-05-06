package net.rory.springserverapp.service;

import net.rory.springserverapp.dao.ReviewDao;
import net.rory.springserverapp.dao.SpecUserDao;
import net.rory.springserverapp.dao.UserDao;
import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.SpecUser;
import net.rory.springserverapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class SpecUserServiceImpl implements SpecUserService {

    @Autowired
    SpecUserDao specUserDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ReviewDao reviewDao;

    @Override
    @Transactional(readOnly = true)
    public SpecUser getSpecUserById(Long id) {
        return specUserDao.findOne(id);
    }

    @Override
    public void saveSpecUser(SpecUser specUser) {
        User user = userDao.findUserByEmail(specUser.getEmail());
        specUser.setIdUser(user.getIdUser());

        specUserDao.saveAndFlush(specUser);
    }

    @Override
    public void changeSpecUserInfo(SpecUser specUser) {
        User user = userDao.findUserByEmail(specUser.getEmail());
        specUser.setIdUser(user.getIdUser());

        specUserDao.save(specUser);
    }

    @Override
    public void addSpecReviews(Long idSpecUser, Long idReview) {
        SpecUser specUser = specUserDao.findOne(idSpecUser);
        Review review = reviewDao.findOne(idReview);
        List<Review> reviewList = new ArrayList<>();

        reviewList.add(review);
        specUser.setReviews(reviewList);

        review.setSpecUser(specUser);

        specUserDao.saveAndFlush(specUser);
    }
}
