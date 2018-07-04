package com.androidexample.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class hipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Music> music = new ArrayList<>();
        music.add(new Music(R.drawable.eminem, "RapGod", "Eminem"));
        music.add(new Music(R.drawable.drake, "Scorpion", "Drake"));
        music.add(new Music(R.drawable.lamar, "RadioActive", "Kendrik Lamar"));
        music.add(new Music(R.drawable.snoop, "Beautiful", "Snoop Dog"));
        music.add(new Music(R.drawable.eminem, "Not Afraid", "Eminem"));
        music.add(new Music(R.drawable.west, "FourFiveSeconds", "Kayne West"));

        MusicAdapter musicAdapter = new MusicAdapter(this, music);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(hipActivity.this, play.class);
                intent.putExtra("artist_name", music.get(position).getmArtistName());
                intent.putExtra("song_name", music.get(position).getmSongName());
                intent.putExtra("thumbnail", music.get(position).getmThumbNail());
                startActivity(intent);

            }
        });


    }
}
