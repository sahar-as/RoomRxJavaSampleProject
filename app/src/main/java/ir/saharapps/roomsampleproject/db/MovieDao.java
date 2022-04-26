package ir.saharapps.roomsampleproject.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ir.saharapps.roomsampleproject.models.Movie;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMovie(Movie movie);

    @Query("SELECT * FROM movie")
    List<Movie> getAllMovies();
}
