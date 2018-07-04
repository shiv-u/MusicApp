package com.androidexample.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class rockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Music> music = new ArrayList<>();
        music.add(new Music(R.drawable.thebeatles, "Hey Jude", "The Beatles"));
        music.add(new Music(R.drawable.jimi, "Purple Haze", "Jimi Hendrix"));
        music.add(new Music(R.drawable.david, "Under Pressure", "David Bowie"));
        music.add(new Music(R.drawable.mad, "Music", "Madonna"));
        music.add(new Music(R.drawable.rock, "Heart Break Hotel", "Elvis Presley"));
        music.add(new Music(R.drawable.david, "Life On Mars", "David Bowie"));
        music.add(new Music(R.drawable.thebeatles, "Yesterday", "The Beatles"));


        ListView listView = findViewById(R.id.list);
        MusicAdapter musicAdapter = new MusicAdapter(this, music);

        listView.setAdapter(musicAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(rockActivity.this, play.class);
                intent.putExtra("artist_name", music.get(position).getmArtistName());
                intent.putExtra("song_name", music.get(position).getmSongName());
                intent.putExtra("thumbnail", music.get(position).getmThumbNail());
                startActivity(intent);

            }
        });


    }
}
