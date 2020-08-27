package com.example.startwarsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.startwarsapps.Films.Results;

public class DetailActivity extends AppCompatActivity {

    private TextView txtDescription, txtDirector, txtProducer, txtRelease,txtDetailTitle;
    private ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtDescription = findViewById(R.id.txtDescription);
        txtDirector = findViewById(R.id.txtDirector);
        txtProducer = findViewById(R.id.txtProducer);
        txtRelease = findViewById(R.id.txtRelease);
        txtDetailTitle = findViewById(R.id.txtDetailTitle);
        btnBack = findViewById(R.id.btnBack);

        Results data = getIntent().getParcelableExtra("film");
        setTitle(data.getTitle());

        txtDetailTitle.setText(data.getTitle());
        txtDescription.setText(data.getOpeningCrawl());
        txtDirector.setText(data.getDirector());
        txtProducer.setText(data.getProducer());
        txtRelease.setText(data.getReleaseDate());


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onBackPressed();
            }
        });
    }



}