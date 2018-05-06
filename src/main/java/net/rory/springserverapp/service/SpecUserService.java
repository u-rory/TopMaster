package net.rory.springserverapp.service;


import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.SpecUser;


public interface SpecUserService {
    SpecUser getSpecUserById(Long id);

    void saveSpecUser(SpecUser specUser);

    void changeSpecUserInfo(SpecUser specUser);

    void addSpecReviews(Long idSpecUser, Long idReview);
}
