package com.gmail.bergrin.mvvmretrofitdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gmail.bergrin.mvvmretrofitdemo.R;
import com.gmail.bergrin.mvvmretrofitdemo.databinding.ActivityMovieDetailsBinding;
import com.gmail.bergrin.mvvmretrofitdemo.model.Result;

public class MovieDetailsActivity extends AppCompatActivity {

    private Result result;
    private ActivityMovieDetailsBinding activityMovieDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        activityMovieDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movieData")) {
            result = intent.getParcelableExtra("movieData");

            activityMovieDetailsBinding.setResult(result);

        }
    }
}