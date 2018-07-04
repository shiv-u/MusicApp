package com.androidexample.musicapp;

/**
 * Created by shivu on 01-07-2018.
 */

public class Music {
    private int mThumbNail;
    private String mSongName, mArtistName;

    public Music(int mThumbNail, String mSongName, String mArtistName) {
        this.mThumbNail = mThumbNail;
        this.mSongName = mSongName;
        this.mArtistName = mArtistName;
    }

    public int getmThumbNail() {
        return mThumbNail;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }
}
