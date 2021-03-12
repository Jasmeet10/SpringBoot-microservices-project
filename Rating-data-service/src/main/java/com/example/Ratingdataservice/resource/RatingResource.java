package com.example.Ratingdataservice.resource;

import com.example.Ratingdataservice.model.Rating;
import com.example.Ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId")String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getRatings(@PathVariable("userId")String userId){
      List<Rating> ratings = Arrays.asList(
              new Rating("1234",4),
              new Rating("3456", 5)
      );
              UserRating userRating = new UserRating();
                userRating.setUserRating(ratings);
        return userRating;
    }
}
