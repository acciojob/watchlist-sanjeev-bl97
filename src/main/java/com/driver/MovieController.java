package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added Successfully", HttpStatus.ACCEPTED);


    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added Successfully", HttpStatus.ACCEPTED);


    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){

        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Director and Movie paired Successfully", HttpStatus.ACCEPTED);


    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        return new ResponseEntity<>(movieService.getMovieByName(movieName),HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
        return new ResponseEntity<>(movieService.getDirectorByName(directorName),HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(directorName),HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String directorName){

        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Successfully deleted all directors", HttpStatus.ACCEPTED);

    }




}
