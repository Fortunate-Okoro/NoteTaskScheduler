package com.example.notetask.DB;

import android.provider.BaseColumns;

public class NoteContract {
    public static final String DB_NAME = "noteTask.db";
    public static final int DB_VERSION = 1;

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NoteEntry.TABLE_NAME + " (" +
                    NoteEntry._ID + "INTEGER PRIMARY KEY," +
                    NoteEntry.COLUMN_NAME_TITLE + " TEXT," +
                    NoteEntry.COLUMN_NAME_IMAGE + " TEXT," +
                    NoteEntry.COLUMN_NAME_DESC + " TEXT," +
                    NoteEntry.COLUMN_NAME_DATE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + NoteEntry.TABLE_NAME;

    public static class NoteEntry implements BaseColumns{
        public static final String TABLE_NAME = "note";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_IMAGE = "image";
        public static final String COLUMN_NAME_DESC = "description";
        public static final String COLUMN_NAME_DATE = "fullDate";

    }
}
