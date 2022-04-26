package ir.saharapps.roomsampleproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ir.saharapps.roomsampleproject.R;
import ir.saharapps.roomsampleproject.db.ApplicationDataSource;
import ir.saharapps.roomsampleproject.db.MovieDataProvider;
import ir.saharapps.roomsampleproject.models.Movie;

public class MainActivity extends AppCompatActivity {

    ApplicationDataSource mDataSource;
    MovieAdapter adapter;
    RecyclerView mRecyclerView;
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataSource = new ApplicationDataSource(this);
        mRecyclerView = findViewById(R.id.rv_mainActivity_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    //Room does not allow to operate database operation on main thread

    @SuppressLint("CheckResult")
    @Override
    protected void onResume() {
        super.onResume();

        disposable = mDataSource.getAllMovieInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Movie>>() {
                    @Override
                    public void accept(List<Movie> movies) throws Exception {
                        adapter = new MovieAdapter(movies, MainActivity.this);
                        mRecyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                });

        Completable.fromCallable(new Callable<Void>() {
            @Override
            public Void call()  {
                try {
                    MovieDataProvider movieDataProvider = new MovieDataProvider();
                    for(Movie movie : movieDataProvider.moviesList){
                        Log.d("TAG", "call: 88888888888 " + movie.toString());
                        mDataSource.insertMovie(movie);
                    }
                }catch (Exception e){
                    Log.d("TAG", "call: 999999 " + e.getMessage());
                }
                return null;
            }
        })
                .subscribeOn(Schedulers.newThread())
                .subscribe();
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}