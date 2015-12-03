package models;


import static com.google.common.base.MoreObjects.toStringHelper;
import com.google.common.base.Objects;
import utils.ToJsonString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peter hearne on 11/22/2015.
 */

public class User {
    static Long counter = 0l;
    public Long id;
    public String firstName;
    public String lastName;
    public String gender;
    public String age;
    public String occupation;
    public String email;

    public List<Rating> ratings = new ArrayList<>();

    public User(String firstName, String lastName, String gender, String age, String occupation, String email) {
        this.id         = counter++;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.email = email;
    }
   /* public Collections <ratings> getRatings(){

        return ratings.values();
    }
    */
    public List<Rating> getRatings(){
        return ratings;
    }

    public String toString() {
        return new ToJsonString(getClass(), this).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.lastName, this.firstName, this.gender, this.age, this.email);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof User) {
            final User other = (User) obj;
            return Objects.equal(firstName, other.firstName)
                    && Objects.equal(lastName, other.lastName)
                    && Objects.equal(gender, other.gender)
                    && Objects.equal(age, other.age)
                    && Objects.equal(occupation, other.occupation)
                    && Objects.equal(email, other.email)
                    && Objects.equal(ratings, other.ratings);
        } else {
            return false;
        }
    }
}