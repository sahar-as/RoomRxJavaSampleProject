package ir.saharapps.roomsampleproject.db;

import java.util.ArrayList;
import java.util.List;

import ir.saharapps.roomsampleproject.R;
import ir.saharapps.roomsampleproject.models.Movie;
import ir.saharapps.roomsampleproject.models.MovieDescription;

//design and developed by Sahar Asadian

public class MovieDataProvider {
    public List<Movie> moviesList =new ArrayList<>();
    private List<MovieDescription> movieDescriptionList = new ArrayList<>();

    public MovieDataProvider() {
        addingToList();
    }

    public void addingToList(){

        movieDescriptionList.add(new MovieDescription("A 13-year-old girl named Meilin turns into a giant red panda whenever she gets too excited."));
        movieDescriptionList.add(new MovieDescription("Mei Lee is a 13-year-old girl who is torn between being her mother's obedient daughter and the chaos of her youth. As if that were not enough, when she gets too excited, she turns into a big red panda."));
        Movie firstMovie = new Movie("Turning Red", 7.0, "Domee Shi", R.drawable.movie1);
        firstMovie.setDescription(movieDescriptionList);
        moviesList.add(firstMovie);

        Movie secondMovie = new Movie("The Batman", 8.1, "Matt Reeves",R.drawable.movie2);
        moviesList.add(secondMovie);

        movieDescriptionList.clear();
        movieDescriptionList.add(new MovieDescription("Ex-con artist Jimmy McGill turns into a small-time attorney and goes through a series of trials and tragedies, as he transforms into his alter ego Saul Goodman, a morally challenged criminal lawyer."));
        movieDescriptionList.add(new MovieDescription("The trials and tribulations of criminal lawyer Jimmy McGill in the time before he established his strip-mall law office in Albuquerque, New Mexico as Saul Goodman."));
        Movie thirdMovie = new Movie("Better Call Saul", 8.8, "Vince Gilligan",R.drawable.movie3);
        thirdMovie.setDescription(movieDescriptionList);
        moviesList.add(thirdMovie);

        movieDescriptionList.clear();
        movieDescriptionList.add(new MovieDescription("A Colombian teenage girl has to face the frustration of being the only member of her family without magical powers."));
        movieDescriptionList.add(new MovieDescription("The Madrigals are an extraordinary family who live hidden in the mountains of Colombia in a charmed place called the Encanto. The magic of the Encanto has blessed every child in the family with a unique gift -- every child except Mirabel. However, she soon may be the Madrigals last hope when she discovers that the magic surrounding the Encanto is now in danger."));
        Movie forthMovie = new Movie("Encanto", 7.3, "Jared Bush",R.drawable.movie4);
        forthMovie.setDescription(movieDescriptionList);
        moviesList.add(forthMovie);

    }



}
