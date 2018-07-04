package com.androidexample.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class popActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Music> music = new ArrayList<>();

        music.add(new Music(R.drawable.mj, "Thriller", "Michael Jackson"));
        music.add(new Music(R.drawable.ts, "Shake It Off", "Taylor Swift"));
        music.add(new Music(R.drawable.timber, "Can't Stop The Feeling", "Justin TimberLake"));
        music.add(new Music(R.drawable.mars, "Uptown Funk", "Bruno Mars"));
        music.add(new Music(R.drawable.katy, "Roar", "KatyPerry"));
        music.add(new Music(R.drawable.queen, "We Will Rock You", "Queen"));
        music.add(new Music(R.drawable.ed, "Shape Of You", "Ed Sheeran"));

        MusicAdapter musicAdapter = new MusicAdapter(this, music);

        listView = findViewById(R.id.list);
        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(popActivity.this, play.class);
                intent.putExtra("artist_name", music.get(position).getmArtistName());
                intent.putExtra("song_name", music.get(position).getmSongName());
                intent.putExtra("thumbnail", music.get(position).getmThumbNail());
                startActivity(intent);

            }
        });


    }

}
