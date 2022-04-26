package ir.saharapps.roomsampleproject.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import ir.saharapps.roomsampleproject.models.Movie;

//design and developed by Sahar Asadian

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMovie(Movie movie);

    @Query("SELECT * FROM movie")
    Flowable<List<Movie>> getAllMovies();
}
