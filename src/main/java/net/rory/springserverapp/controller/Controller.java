package net.rory.springserverapp.controller;


import net.rory.springserverapp.model.Review;
import net.rory.springserverapp.model.SpecUser;
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

    @RequestMapping(value = "/getAllReviews", method = RequestMethod.GET)
    public List<Review> getAllReviews() throws IOException {
        return reviewService.getAllReviews();
    }

    @RequestMapping(value = "/getSpecUser/{id}", method = RequestMethod.GET)
    public SpecUser getSpecUser(@PathVariable(value = "id") Long id) throws IOException {
        return specUserService.getSpecUserById(id);
    }
}
