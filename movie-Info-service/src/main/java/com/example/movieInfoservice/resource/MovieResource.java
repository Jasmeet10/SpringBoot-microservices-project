package com.example.movieInfoservice.resource;

import com.example.movieInfoservice.models.Movie;
import com.example.movieInfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +
                "?api_key=" + "829adf69e4e30886f446f291b193e530", MovieSummary.class);
        return new Movie(movieId,movieSummary.getTitle());
        //return new Movie(movieId ,"test name");
    }
}
