package ir.saharapps.roomsampleproject.db;

import android.content.Context;
import android.util.Log;

import java.util.List;

import ir.saharapps.roomsampleproject.models.Movie;
import ir.saharapps.roomsampleproject.models.MovieDescription;

public class ApplicationDataSource {
    private static final String TAG = "ApplicationDataSource";

    public final MovieDao movieDao;
    public final MovieDescriptionDao movieDescriptionDao;

    public ApplicationDataSource(Context context) {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context);
        movieDao = movieDatabase.mMovieDao();
        movieDescriptionDao = movieDatabase.mMovieDescriptionDao();
    }

    public void insertMovie(Movie movie){
        long rowId = movieDao.insertMovie(movie);
        List<MovieDescription> descriptions = movie.getDescription();
        if(descriptions != null){
            for (MovieDescription description : descriptions) {
                description.setMovieId(rowId);
            }
            movieDescriptionDao.insertDescription(descriptions);
        }
        Log.d(TAG, "insertMovie: row id is: " + rowId);
    }
}
