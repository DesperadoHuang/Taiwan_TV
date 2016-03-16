package com.taiwantv.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.taiwantv.model.Channel;

/**
 * Created by WilsonHuang-PC on 2016/3/16.
 */
public class VideoDAO {

    private SQLiteDatabase db;

    public VideoDAO(Context context) {
        this.db = VideoDbHelper.getDatabase(context);
    }

    public void insert(Channel channel) {
        ContentValues cv = new ContentValues();
        cv.put(VideoDbHelper.VideoEntry.COLUMN_VIDEO_NAME, channel.getName());
        cv.put(VideoDbHelper.VideoEntry.COLUMN_VIDEO_CATEGORY, channel.getCategory());
        cv.put(VideoDbHelper.VideoEntry.COLUMN_VIDEO_URL, channel.getVideoUrl());
        cv.put(VideoDbHelper.VideoEntry.COLUMN_CARD_IMAGE_URL, channel.getCardImageUrl());
        cv.put(VideoDbHelper.VideoEntry.COLUMN_BG_IMAGE_URL, channel.getBgImageUrl());
        db.insert(VideoDbHelper.VideoEntry.TABLE_NAME, null, cv);
    }
}
