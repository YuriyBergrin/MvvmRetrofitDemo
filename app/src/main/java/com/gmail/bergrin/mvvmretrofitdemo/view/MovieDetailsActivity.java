package com.gmail.bergrin.mvvmretrofitdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gmail.bergrin.mvvmretrofitdemo.R;
import com.gmail.bergrin.mvvmretrofitdemo.model.Result;

public class MovieDetailsActivity extends AppCompatActivity {

    private Result result;
    private ImageView posterImageView;
    private String posterPath;
    private TextView titleTextView;
    private TextView voteCountTextView;
    private TextView overviewTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        posterImageView = findViewById(R.id.posterImageView);
        titleTextView = findViewById(R.id.titleTextView);
        voteCountTextView = findViewById(R.id.voteCountTextView);
        overviewTextView = findViewById(R.id.overviewTextView);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movieData")) {
            result = intent.getParcelableExtra("movieData");
            Toast.makeText(this, result.getOriginalTitle(), Toast.LENGTH_SHORT).show();
            posterPath = result.getPosterPath();
            String imagePath = getString(R.string.image_path) + posterPath;
            Glide.with(this)
                    .load(imagePath)
                    .placeholder(R.drawable.progress_circle)
                    .into(posterImageView);

            titleTextView.setText(result.getOriginalTitle());
            voteCountTextView.setText(result.getVoteCount().toString());
            overviewTextView.setText(result.getOverview());
        }
    }
}