package net.rory.springserverapp.dao;


import net.rory.springserverapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review, Long>{
    @Query("SELECT r FROM Review r WHERE r.status = 1")
    List<Review> loadReviews();
}
