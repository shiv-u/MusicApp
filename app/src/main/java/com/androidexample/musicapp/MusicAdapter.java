package com.androidexample.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by shivu on 01-07-2018.
 */

public class MusicAdapter extends ArrayAdapter<Music> {

    MusicAdapter(Activity context, ArrayList<Music> music) {
        super(context, 0, music);


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.music_list, parent, false);
        }

        Music music = getItem(position);
        TextView artist = listItemView.findViewById(R.id.artist);

        artist.setText(music.getmArtistName());

        TextView song = listItemView.findViewById(R.id.song);
        song.setText(music.getmSongName());

        ImageView profile = listItemView.findViewById(R.id.img);
        Glide.with(getContext())
                .asBitmap()
                .apply(new RequestOptions()
                        .fitCenter()
                        .override(700, 500)
                )
                .load(music.getmThumbNail())
                .into(profile);


        return listItemView;


    }

}
