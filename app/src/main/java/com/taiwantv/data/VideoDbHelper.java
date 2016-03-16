package com.taiwantv.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by WilsonHuang-PC on 2016/3/8.
 */
public class VideoDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "video_info.db";

    private static final String SQL_CREATE_VIDEO_TABLE =
            "CREATE TABLE " + VideoEntry.TABLE_NAME + " (" +
                    VideoEntry._ID + " INTEGER PRIMARY KEY," +
                    VideoEntry.COLUMN_VIDEO_NAME + " TEXT NOT NULL," +
                    VideoEntry.COLUMN_VIDEO_URL + " TEXT," +
                    VideoEntry.COLUMN_VIDEO_CATEGORY + " TEXT," +
                    VideoEntry.COLUMN_BG_IMAGE_URL + " TEXT," +
                    VideoEntry.COLUMN_CARD_IMAGE_URL + " TEXT" +
                    " );";

    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + VideoEntry.TABLE_NAME;

    private static SQLiteDatabase sqLiteDatabase;

    public static SQLiteDatabase getDatabase(Context context) {
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            sqLiteDatabase = new VideoDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION).getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public VideoDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_VIDEO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public static final class VideoEntry implements BaseColumns {
        public static final String TABLE_NAME = "video_info";
        public static final String COLUMN_VIDEO_NAME = "video_name";
        public static final String COLUMN_VIDEO_URL = "video_url";
        public static final String COLUMN_VIDEO_CATEGORY = "video_category";
        public static final String COLUMN_BG_IMAGE_URL = "bg_image_url";
        public static final String COLUMN_CARD_IMAGE_URL = "card_image_url";
    }
}
