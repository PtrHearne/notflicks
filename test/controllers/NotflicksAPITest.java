package controllers;


import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.User;
import models.Movie;
import models.Rating;


import java.util.List;

import static models.Fixtures.users;
import static models.Fixtures.movies;
//import static models.Fixtures.ratings;
/**
 * Created by peter hearne on 11/22/2015.
 */
public class NotflicksAPITest {

    private NotflicksAPI notflicks;

    @Before
    public void setup()
    {
        notflicks = new NotflicksAPI();
        for (User user : users)
        {
            notflicks.addUser(user.firstName, user.lastName, user.gender, user.age, user.occupation, user.email);
        }
        for (Movie movie:movies)
        {
           notflicks.addMovie(movie.title,movie.year,movie.url);
        }
     //   for (Rating rating:ratings)
       // {
         //   notflicks.addRating(rating.userId,rating.movieId,rating.score);
       // }
    }

    @After
    public void tearDown()
    {
        notflicks = null;
    }
    //@Test
    public void testAddUser(){


    }

    @Test
    public void testUser()
    {
        assertEquals(users.length, notflicks.getUsers().size());
        notflicks.addUser("homer", "simpson", "55", "male","genius","homer@simpson.com");
        assertEquals(users.length + 1, notflicks.getUsers().size());
        assertEquals (users[0], notflicks.getUserByEmail(users[0].email));
    }

    @Test
    public void testUsers()
    {
        assertEquals (users.length, notflicks.getUsers().size());
        for (User user: users)
        {
            User eachUser = notflicks.getUserByEmail(user.email);
            assertEquals (user, eachUser);
            assertNotSame(user, eachUser);
        }
    }

    @Test
    public void testRemoveUsers()
    {
        assertEquals(users.length, notflicks.getUsers().size());
        User marge = notflicks.getUserByEmail("marge@simpson.com");
        notflicks.removeUser(marge.id);
        assertEquals(users.length - 1, notflicks.getUsers().size());
    }


    @Test
    public void testMovie()
    {
        assertEquals(movies.length, notflicks.getMovies().size());
        Movie movie = notflicks.addMovie("movieFive", "2014", "URL");
        assertNotNull(notflicks.getMovie(movie.id));
        assertEquals(movies.length + 1, notflicks.getMovies().size());
        Movie returnedMovie = notflicks.getMovie(movie.id);
        assertEquals(movies[4],  returnedMovie);
        assertNotSame(movies[4], returnedMovie);


       }
    @Test
    public void testRating()
    {
        //assertNotNull(notflicks.getRatings().size());
       // assertNotNull(notflicks.getUserRatings().size());

      // assertEquals(users.ratings.length, notflicks.getRatings().size());
//        assertEquals(ratings.length, notflicks.getUserRatings().size());
       //Rating rating = notflicks.createRating(users[0].id, movies[1].id, 9);

//        assertEquals(ratings.length+1,notflicks.getRatings().size());

       // User marge = new User("marge",  "simpson", "female", "55","wife","marge@simpson.com");
       User marge = notflicks.addUser("marge",  "simpson", "female", "55","wife","marge@simpson.com");
        //System
        Rating Qrating = notflicks.createRating(marge.id, movies[1].id, 9);

        assertNotNull(notflicks.getRatings().size());
        assertNotNull(notflicks.getUserRatings().size());
        List<Rating> list = marge.getRatings();
        assertTrue(list.contains(Qrating));

    }





}


