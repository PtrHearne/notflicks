package models;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static models.Fixtures.users;
/**
 * Created by Owner on 11/22/2015.
 */
public class UserTest
{
    User homer = new User ("homer", "simpson", "male", "55","genius","homer@simpson.com");

    @Test
    public void testCreate()
    {
        assertEquals ("homer",               homer.firstName);
        assertEquals ("simpson",             homer.lastName);
        assertEquals ("55",                  homer.age);
        assertEquals ("male",                homer.gender);
        assertEquals ("genius",              homer.occupation);
        assertEquals ("homer@simpson.com",   homer.email);
    }

    @Test
    public void testIds()
    {
        Set<Long> ids = new HashSet<>();
        for (User user : users)
        {
            ids.add(user.id);
        }
        assertEquals (users.length, ids.size());
    }

   /* @Test
    public void testToString()
    {
        assertEquals ("User{" + homer.id + ", homer, simpson, male, 55,genius}", homer.toString());
    }
*/
    @Test
    public void testEquals()
    {
        User homer2 = new User ("homer", "simpson", "male", "55","genius","homer@simpson.com");
        User bart   = new User ("bart", "simpson", "male", "9","student","bart@simpson.com");

        assertEquals(homer, homer);
        assertEquals(homer, homer2);
        assertNotEquals(homer, bart);
    }

}
