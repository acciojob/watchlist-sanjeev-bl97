package com.driver;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String,Movie> m;
    Map<String,Director> d;
    Map<String, ArrayList<String>> md;

    public MovieRepository() {
         m = new HashMap<>();
         d = new HashMap<>();
        md = new HashMap<>();
    }

    public void addMovie(Movie movie){
        m.put(movie.getName(), movie);
    }


    public void addDirector(Director director){
        d.put(director.getName(), director);
    }


    public void addMovieDirectorPair(String movieName, String directorName){


        if(m.containsKey(movieName) && d.containsKey(directorName)){
        ArrayList<String> movieList = md.get(directorName);
        if(movieList == null)
            movieList = new ArrayList<>();
        movieList.add(movieName);

        md.put(directorName, movieList);
        }
    }


    public Movie getMovieByName(String movieName){
        return m.get(movieName);
    }


    public Director getDirectorByName(String directorName){
        return d.get(directorName);
    }


    public  List<String> getMoviesByDirectorName(String directorName){
        return md.get(directorName);

    }


    public List<String> findAllMovies(){
        List<String> movieList = new ArrayList<>();

        for(String e : m.keySet())
            movieList.add(e);

        return movieList;

    }

    public void deleteDirectorByName(String directorName){

        if(d.containsKey(directorName))
            d.remove(directorName);

        if(md.containsKey(directorName)){
        List<String> movieList = md.get(directorName);

        for(String movie : movieList)
            if(m.containsKey(movie))
                m.remove(movie);

        md.remove(directorName);
        }



    }

    public void deleteAllDirectors(){

        for(String director : d.keySet()){
            deleteDirectorByName(director);
        }

    }
}
