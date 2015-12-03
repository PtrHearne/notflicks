package controllers;

import com.google.common.base.Optional;
import models.Movie;
import models.Rating;
import models.User;

import utils.Serializer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peter hearne on 11/22/2015.
 *
 */


public class NotflicksAPI {

    private Serializer serializer;

    private Map<Long, User> userIndex = new HashMap<>();
    private Map<String, User> emailIndex = new HashMap<>();
    private Map<Long, Movie> movieIndex = new HashMap<>();
   // private Map<String, Long> titleIndex = new HashMap<>();
    private Map<Long,Rating> ratingIndex = new HashMap<>();
    private Map<Long,Rating> userRating = new HashMap<>();

    public NotflicksAPI()
    {}
    public NotflicksAPI(Serializer serializer)
    {
        this.serializer = serializer;
    }
    public void load() throws Exception
    {
        serializer.read();
        emailIndex      = (Map<String, User>)   serializer.pop();
        userIndex       = (Map<Long, User>)     serializer.pop();
        movieIndex      = (Map<Long,Movie>)     serializer.pop();
    }

    public void store() throws Exception
    {
        serializer.push(userIndex);
        serializer.push(emailIndex);
        serializer.push(movieIndex);
        serializer.write();
    }

    public Collection<User> getUsers() {
        return userIndex.values();
    }

    public Collection<Movie> getMovies() {
        return movieIndex.values();
    }
    public Collection<Rating> getRatings(){
        return ratingIndex.values();
    }
    public Collection<Rating> getUserRatings(){
        return userRating.values();
    }

    public void deleteUsers() {
        userIndex.clear();
        emailIndex.clear();
    }

    public User addUser(String firstName, String lastName, String age, String gender, String occupation, String email) {
        User user = new User(firstName, lastName, age, gender, occupation, email);
        userIndex.put(user.id, user);
        emailIndex.put(email, user);
        return user;
    }

    public User getUserByEmail(String email) {
        return emailIndex.get(email);
    }

    public User getUser(long id) {
        return userIndex.get(id);
    }

    public void removeUser(Long id) {
        User user = userIndex.remove(id);
        emailIndex.remove(user);
    }

    public Movie addMovie(String title, String year, String url) {
        Movie movie = new Movie(title, year, url);
        movieIndex.put(movie.id, movie);
       // titleIndex.put(title, movie.id);
        return movie;
    }

    public Movie getMovie(Long id) {
        Movie movie = movieIndex.get(id);
        movieIndex.get(movie);
        return movie;
    }
/*
    public Rating addRating(Long userId,Long movieId,int score){
        Rating rating = new Rating(userId,movieId,score);
        ratingIndex.put(rating.id,rating);
       // userRating.put (rating.userId,rating);
      return rating;
    }
*/
    public Rating createRating(Long id, Long movieId, int score)
    {
      Rating rating = new Rating (movieId,score);
      //  Rating rating = null;
        Optional<User> user = Optional.fromNullable(userIndex.get(id));
        if(user.isPresent()) {
            userIndex.get(id).getRatings().add(rating);
            System.out.println(score);
        }

        return rating;
    }

  //  public Rating getRating (Rating rating)
   // {
        //userRating.get(id);
    //    return userRating.get(rating);
   // }

}
