package net.rory.springserverapp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.rory.springserverapp.model.Parameter;
import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.SpecUser;
import net.rory.springserverapp.model.User;
import net.rory.springserverapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
        return specUserService.getSpecUserById(id);
    }

    @RequestMapping(value = "/getAllParameters", method = RequestMethod.GET)
    public List<Parameter> getAllParameters() throws IOException {
        return parameterService.getAllParameters();
    }

    @RequestMapping(value = "/getUserReviews/{id}", method = RequestMethod.GET)
    public List<Review> getUserReviews(@PathVariable(value = "id") Long id) throws IOException {
        return reviewService.getUserReviewsById(id);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public void saveUser(@RequestParam("User") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(str, User.class);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public void saveReview(@RequestParam("Review") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Review review = objectMapper.readValue(str, Review.class);

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        review.setDatetime(formatForDateNow.format(dateNow));
        review.setStatus(0);
        reviewService.saveReview(review);
    }

    @RequestMapping(value = "/saveSpecUser", method = RequestMethod.POST)
    public void saveSpecUser(@RequestParam("SpecUser") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SpecUser specUser = objectMapper.readValue(str, SpecUser.class);
        specUserService.saveSpecUser(specUser);
    }

}
