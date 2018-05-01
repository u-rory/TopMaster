package net.rory.springserverapp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.rory.springserverapp.model.Parameter;
import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.SpecUser;
import net.rory.springserverapp.model.User;
import net.rory.springserverapp.service.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private SpecUserService specUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private ParameterService parameterService;

    @RequestMapping(value = "/getAllReviews", method = RequestMethod.GET)
    public List<Review> getAllReviews() throws IOException {
        return reviewService.getAllReviews();
    }

    @RequestMapping(value = "/getAllReviewsMod", method = RequestMethod.GET)
    public List<Review> getAllReviewsMod() throws IOException {
        return reviewService.getAllReviewsMod();
    }

    @RequestMapping(value = "/getSpecUser/{id}", method = RequestMethod.GET)
    public SpecUser getSpecUser(@PathVariable(value = "id") Long id) throws IOException {
        SpecUser specUser = specUserService.getSpecUserById(id);
        return specUser;
    }

    @RequestMapping(value = "/getAllParameters", method = RequestMethod.GET)
    public List<Parameter> getAllParameters() throws IOException {
        return parameterService.getAllParameters();
    }

    @RequestMapping(value = "/getUserReviews/{id}", method = RequestMethod.GET)
    public List<Review> getUserReviews(@PathVariable(value = "id") Long id) throws IOException {
        return reviewService.getUserReviewsById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestParam("User") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(str, User.class);
        Long userToCheck = userService.getUser(user.getSurname(),
                    user.getName(), user.getEmail());
        if (userToCheck == 0) {
            userService.saveUser(user);
        }
        return userService.loadUserByEmail(user.getEmail());
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public void saveReview(@RequestParam("Review") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Review review = objectMapper.readValue(str, Review.class);
        reviewService.saveReview(review);
    }

    @RequestMapping(value = "/saveSpecUser", method = RequestMethod.POST)
    public void saveSpecUser(@RequestParam("SpecUser") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SpecUser specUser = objectMapper.readValue(str, SpecUser.class);
        specUserService.saveSpecUser(specUser);
    }

    @RequestMapping(value = "/updateSpecUser", method = RequestMethod.POST)
    public void updateSpecUser(@RequestParam("SpecUser") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SpecUser specUser = objectMapper.readValue(str, SpecUser.class);
        specUserService.changeSpecUserInfo(specUser);
    }

    @RequestMapping(value = "/publishReview", method = RequestMethod.POST)
    public void publishReview(@RequestParam("Review") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Review review = objectMapper.readValue(str, Review.class);
        review.setStatus(1);
        reviewService.saveReview(review);
    }

}
