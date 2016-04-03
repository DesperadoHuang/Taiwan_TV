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
                    VideoEntry.COLUMN_VIDEO_URL_1 + " TEXT," +
                    VideoEntry.COLUMN_VIDEO_URL_2 + " TEXT," +
                    VideoEntry.COLUMN_VIDEO_CATEGORY + " TEXT," +
                    VideoEntry.COLUMN_BG_IMAGE_URL + " TEXT," +
                    VideoEntry.COLUMN_CARD_IMAGE_URL + " TEXT," +
                    VideoEntry.COLUMN_STUDIO + " TEXT" +
                    " );";

    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + VideoEntry.TABLE_NAME;

    private static SQLiteDatabase sqLiteDatabase;

    public static SQLiteDatabase getDatabase(Context context) {
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            //getWritableDatabase()或getReadableDatabase()取得SQLiteDatabase實體，若資料庫不存在，系統會自動生成一個
            //getWritableDatabase()已讀寫的方式打開資料庫
            //getReadableDatabase()已唯讀的方式打開資料庫
            sqLiteDatabase = new VideoDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION).getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public VideoDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //初次生成資料庫時才會被呼叫，或onUpgrade()方法被資料庫版本變化時也會被呼叫
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_VIDEO_TABLE);
    }

    //在每次成功打開資料庫時，會第一個被執行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public static final class VideoEntry implements BaseColumns {
        public static final String TABLE_NAME = "video_info";
        public static final String COLUMN_VIDEO_NAME = "video_name";
        public static final String COLUMN_VIDEO_URL_1 = "video_url_1";
        public static final String COLUMN_VIDEO_URL_2 = "video_url_2";
        public static final String COLUMN_VIDEO_CATEGORY = "video_category";
        public static final String COLUMN_BG_IMAGE_URL = "bg_image_url";
        public static final String COLUMN_CARD_IMAGE_URL = "card_image_url";
        public static final String COLUMN_STUDIO = "video_studio";
    }
}
