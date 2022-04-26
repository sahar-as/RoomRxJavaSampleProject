package ir.saharapps.roomsampleproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ir.saharapps.roomsampleproject.R;
import ir.saharapps.roomsampleproject.db.ApplicationDataSource;
import ir.saharapps.roomsampleproject.models.Movie;

//design and developed by Sahar Asadian

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

        //Run first time for adding data to the database
//        Completable.fromCallable(new Callable<Void>() {
//            @Override
//            public Void call()  {
//                try {
//                    MovieDataProvider movieDataProvider = new MovieDataProvider();
//                    for(Movie movie : movieDataProvider.moviesList){
//                        mDataSource.insertMovie(movie);
//                    }
//                }catch (Exception e){
//                    Log.d("TAG", "call: 999999 " + e.getMessage());
//                }
//                return null;
//            }
//        })
//                .subscribeOn(Schedulers.newThread())
//                .subscribe();
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}