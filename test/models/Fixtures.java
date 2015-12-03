package models;


/**
 * Created by peter hearne on 11/22/2015.
 */
public class Fixtures
{
    public static User[] users =

            {
                    new User("marge",  "simpson", "female", "55","wife","marge@simpson.com"),
                    new User("lisa", "simpson", "female", "10","student","lisa@simpson.com"),
                    new User("bart", "simpson", "male", "9","student","bart@simpson.com"),
                    new User("maggie", "simpson", "female","1", "baby","maggie@simpson.com")
            };


    public static Movie[] movies =

        {
                new Movie("movieOne",  "1975", "URL"),
                new Movie("movieTwo", "1980", "URL"),
                new Movie("movieThree",  "1995", "URL"),
                new Movie("movieFour",  "2015", "URL"),
                new Movie("movieFive", "2014", "URL")
        };



}
