package com.example.startwarsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.startwarsapps.Films.FilmAdapter;
import com.example.startwarsapps.Films.FilmModels;
import com.example.startwarsapps.Films.Results;
import com.example.startwarsapps.Rest.ApiClient;
import com.example.startwarsapps.Rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFilms;
    private ProgressBar progress;
    private ImageView cover;
    private TextView mainTitle;
    private LinearLayout footerMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvFilms = findViewById(R.id.rvFilms);
        progress = findViewById(R.id.progress);
        cover = findViewById(R.id.cover);
        mainTitle = findViewById(R.id.mainTitle);
        footerMain = findViewById(R.id.footerMain);

        loadFilms(rvFilms);
    }

    private void loadFilms(final RecyclerView rv) {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<FilmModels> filmModelsCall = apiInterface.loadFilms();
        filmModelsCall.enqueue(new Callback<FilmModels>() {
            @Override
            public void onResponse(Call<FilmModels> call, Response<FilmModels> response) {
                if (response.body() != null) {
                    progress.setVisibility(View.GONE);
                    rvFilms.setVisibility(View.VISIBLE);
                    cover.setVisibility(View.VISIBLE);
                    mainTitle.setVisibility(View.VISIBLE);
                    footerMain.setVisibility(View.VISIBLE);
                    ArrayList<Results> results = response.body().getResults();
                    rv.setAdapter(new FilmAdapter(results));
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setItemAnimator(new DefaultItemAnimator());
                }
            }

            @Override
            public void onFailure(Call<FilmModels> call, Throwable t) {
                Log.d( "onFailure: ", t.getMessage());
                Toast.makeText(getApplicationContext(), "Error : Terjadi suatu masalah", Toast.LENGTH_LONG).show();
            }
        });
    }


}