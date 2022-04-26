package ir.saharapps.roomsampleproject.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ir.saharapps.roomsampleproject.models.MovieDescription;

@Dao
public interface MovieDescriptionDao {

    @Insert
    void insertDescription(List<MovieDescription> descriptions);

    @Query("SELECT * FROM movie_description WHERE movie_id = :movieId")
    List<MovieDescription> getMovieDescriptions(Long movieId);

}
