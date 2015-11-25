package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Owner on 11/22/2015.
 */
public class MovieTest {

    Movie movieFive = new Movie("movieFive","2014","URL");

    @Test
    public void testCreate()
    {
        assertEquals ("movieFive",      movieFive.title);
        assertEquals ("2014",           movieFive.year);
        assertEquals ("URL",            movieFive.url);
    }

    @Test
    public void testEquals()
    {
        Movie movieFive2 = new Movie("movieFive","2014","URL");
        Movie movieOne = new Movie("movieOne","1975","URL");

        assertSame(movieFive,movieFive);
        assertEquals(movieFive,movieFive2);
        assertNotEquals(movieFive,movieOne);
    }

}
