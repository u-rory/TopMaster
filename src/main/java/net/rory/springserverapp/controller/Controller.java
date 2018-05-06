package net.rory.springserverapp.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.Spec;
import net.rory.springserverapp.model.SpecUser;
import net.rory.springserverapp.model.User;
import net.rory.springserverapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private SpecUserService specUserService;

    @Autowired
    private UserService userService;

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

        reviewService.publishReview(review);
    }

    @RequestMapping(value = "/getSuitableReviews", method = RequestMethod.GET)
    public @ResponseBody List<Review> getSuitableReviews(
            @RequestParam("SpecUser") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SpecUser specUser = objectMapper.readValue(str, SpecUser.class);
        return reviewService.getSuitableReviews(specUser.getSurname(),
                specUser.getName(),
                specUser.getOtchestvo(),
                specUser.getSpecName(),
                specUser.getCity(),
                specUser.getAddress(),
                specUser.getOnCall());
    }

    @RequestMapping(value = "/addSpecReview", method = RequestMethod.POST)
    public void addSpecReview(@RequestParam("SpecReview") String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(str);
        JsonNode idSpecUser = rootNode.path("idSpecUser");
        JsonNode idReview = rootNode.path("idReview");

        specUserService.addSpecReviews(idSpecUser.asLong(), idReview.asLong());
    }
}
