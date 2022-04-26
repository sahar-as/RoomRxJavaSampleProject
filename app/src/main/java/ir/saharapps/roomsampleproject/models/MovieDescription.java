package ir.saharapps.roomsampleproject.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_description",
        primaryKeys = {"movie_id"},
        indices = {@Index("movie_id")},
        foreignKeys = @ForeignKey(entity = Movie.class,
        parentColumns = "id",
        childColumns = "movie_id"))
public class MovieDescription {

    @ColumnInfo(name = "movie_id")
    private long movieId;
    private String description;

    public MovieDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "MovieDescription{" +
                ", description='" + description + '\'' +
                '}';
    }
}
