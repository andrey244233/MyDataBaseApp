package com.example.home_pc.mydatabaseapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class CatsContract {

    public static final class CatsEntry implements BaseColumns {


        public final static String CONTENT_AUTHORITY = "com.example.home_pc.mydatabaseapp";
        public final static Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public final static String PATH_CATS = "cats";
        public final static Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_CATS);

        public static final String TABLE_NAME = "cats";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";

        public final static String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATS;

    }

}
