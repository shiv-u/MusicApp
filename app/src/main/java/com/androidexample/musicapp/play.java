package com.androidexample.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class play extends AppCompatActivity {

    private String artist, song;
    private int thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        artist = bundle.getString("artist_name");
        song = bundle.getString("song_name");
        thumbnail = bundle.getInt("thumbnail");

        TextView artistText = findViewById(R.id.artist_name);
        artistText.setText(artist);

        TextView songText = findViewById(R.id.song_name);
        songText.setText(song);

        ImageView imageView = findViewById(R.id.pic);
        Glide.with(this)
                .asBitmap()
                .apply(new RequestOptions()
                        .fitCenter()
                        .override(380, 380)
                )
                .load(thumbnail)
                .into(imageView);


    }
}
