package ir.saharapps.roomsampleproject.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ir.saharapps.roomsampleproject.models.Movie;
import ir.saharapps.roomsampleproject.models.MovieDescription;

//design and developed by Sahar Asadian


@Database(entities = {Movie.class, MovieDescription.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "movie_info";
    // creating singleton instance of MovieDatabase class
    public static MovieDatabase instance = null;

    public static MovieDatabase getInstance(Context context){
        if(instance == null){
            synchronized (MovieDatabase.class){
                instance = Room.databaseBuilder(context.getApplicationContext(),
                                                MovieDatabase.class,
                                                DATABASE_NAME)
                                .build();
            }
        }
        return instance;
    }

    public abstract MovieDao mMovieDao();
    public abstract MovieDescriptionDao mMovieDescriptionDao();

}
