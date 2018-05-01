package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.User;
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
}
