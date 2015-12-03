package models;
import models.User;
import com.google.common.base.Objects;
import utils.ToJsonString;



/**
 * Created by peter hearne on 11/22/2015.
 */
public class Rating {
  //  static Long counter = 0l;
  //  public Long id;
    public int score;
   //public Long userId;
    public Long movieId;

    public Rating()
    {}

    public Rating(Long movieId,int score) {
       // this.id = counter++;
        this.score = score;
      //  this.userId = userId;
        this.movieId = movieId;
    }

    @Override
    public String toString()
    {
        return new ToJsonString(getClass(), this).toString();
    }
/*   @Override
    public int hashCode()
    {
       return Objects.hashCode(this.id,this.userId,this.movieId ,this.score);
    }
    */
    @Override
    public boolean equals(final Object obj)
    {
        if (obj instanceof Rating)
        {
            final Rating other = (Rating) obj;
            return Objects.equal(score, other.score)
                  //  && Objects.equal(userId, other.userId)
                    && Objects.equal(movieId, other.movieId);
        }
        else
        {
            return false;
        }
    }

}
