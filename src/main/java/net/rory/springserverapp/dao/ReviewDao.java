package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review, Long>{
    @Query("SELECT r FROM Review r WHERE r.status = 1 ORDER BY r.datetime")
    List<Review> loadReviews();

    @Query("SELECT r FROM Review r WHERE r.status = 0 ORDER BY r.datetime")
    List<Review> loadReviewsMod();

    @Query("SELECT r FROM Review r WHERE r.user.idUser = :id ORDER BY r.datetime")
    List<Review> loadUserReviews(@Param("id") Long id);

    @Query("SELECT r FROM Review r WHERE r.surname = :surname " +
            "AND r.name = :name " +
            "OR r.otchestvo = :otchestvo " +
            "AND r.specName = :specName " +
            "AND r.city = :city " +
            "OR r.address = :address " +
            "OR r.onCall = :onCall")
    List<Review> loadSuitableReviews(@Param("surname") String surname,
                                     @Param("name") String name,
                                     @Param("otchestvo") String otchestvo,
                                     @Param("specName") String specName,
                                     @Param("city") String city,
                                     @Param("address") String address,
                                     @Param("onCall") Integer onCall);

}
