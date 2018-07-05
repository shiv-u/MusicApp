package com.androidexample.musicapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class classicActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);


        final ArrayList<Music> classic = new ArrayList<>();
        classic.add(new Music(R.drawable.beethoven,"Symhony No.5","Beethoven" ));
        classic.add(new Music(R.drawable.mozart,"The Magic Flute","Mozart"));
        classic.add(new Music(R.drawable.chopin,"Preludes","Chopin"));
        classic.add(new Music(R.drawable.bach,"Air On The G String","Bach"));
        classic.add(new Music(R.drawable.mozart,"Requiem","Mozart"));
        classic.add(new Music(R.drawable.beethoven,"Symphony No.9","Beethoven"));

        MusicAdapter musicAdapter = new MusicAdapter(this,classic);

        listView = findViewById(R.id.list);

        listView.setAdapter(musicAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(classicActivity.this,play.class);
                intent.putExtra("artist_name",classic.get(position).getmArtistName());
                intent.putExtra("song_name",classic.get(position).getmSongName());
                intent.putExtra("thumbnail",classic.get(position).getmThumbNail());
                startActivity(intent);

            }
        });


    }

}


