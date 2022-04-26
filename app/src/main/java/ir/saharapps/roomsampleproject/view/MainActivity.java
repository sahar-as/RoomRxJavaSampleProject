package ir.saharapps.roomsampleproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

import ir.saharapps.roomsampleproject.R;
import ir.saharapps.roomsampleproject.models.Movie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Room does not allow to operate database operation on main thread

    @Override
    protected void onResume() {
        super.onResume();



//        mDataSource.open();
//
//        movies = mDataSource.getAllMovies();
//
//        adapter = new MovieAdapter(movies,this);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        mRecyclerView.setAdapter(adapter);
    }
}