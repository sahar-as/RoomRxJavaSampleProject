package ir.saharapps.roomsampleproject.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.saharapps.roomsampleproject.R;
import ir.saharapps.roomsampleproject.models.Movie;

//Design and implemented by Sahar Asadian

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    List<Movie> mMovieList;
    Context mContext;

    public MovieAdapter(List<Movie> movieList, Context context) {
        mMovieList = movieList;
        mContext = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.imgMoviePicture.setImageResource(mMovieList.get(position).getImageUrl());
        holder.txtMovieName.setText(mMovieList.get(position).getName());
        holder.txtMovieImdb.setText("IMDb: " + Double.toString(mMovieList.get(position).getImdbRate()));
    }
    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        ImageView imgMoviePicture;
        TextView txtMovieName, txtMovieImdb;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imgMoviePicture = itemView.findViewById(R.id.img_movieItem_movieImage);
            txtMovieName = itemView.findViewById(R.id.txt_movieItem_movieName);
            txtMovieImdb = itemView.findViewById(R.id.txt_movieItem_movieImdb);
        }
    }
    //Design and implemented by Sahar Asadian

}
