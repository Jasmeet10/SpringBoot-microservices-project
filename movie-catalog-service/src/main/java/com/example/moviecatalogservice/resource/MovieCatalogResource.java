package com.example.moviecatalogservice.resource;

import com.example.moviecatalogservice.models.CatalogItems;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItems> getCatalogItems(@PathVariable("userId") String userId){
            //get the ratings of the user
        UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingdata/user/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            // For each movie id, call movie info service and get details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId() ,Movie.class);

            //put them all together
            return new CatalogItems(movie.getName(),"Desc" , rating.getRating());
        }).collect(Collectors.toList());

       // return Collections.singletonList( new CatalogItems("test","test",4));
    }

}
