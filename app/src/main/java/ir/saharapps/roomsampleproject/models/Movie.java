package ir.saharapps.roomsampleproject.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Movie {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

    @ColumnInfo(name = "imdb")
    private double imdbRate;
    private String creator;

    @ColumnInfo(name = "image")
    private int imageUrl;

    @Ignore
    private List<MovieDescription> description;

    public Movie(String name, double imdbRate, String creator, int imageUrl) {
        this.name = name;
        this.imdbRate = imdbRate;
        this.creator = creator;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImdbRate() {
        return imdbRate;
    }

    public void setImdbRate(double imdbRate) {
        this.imdbRate = imdbRate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MovieDescription> getDescription() {
        return description;
    }

    public void setDescription(List<MovieDescription> description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imdbRate=" + imdbRate +
                ", creator='" + creator + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
