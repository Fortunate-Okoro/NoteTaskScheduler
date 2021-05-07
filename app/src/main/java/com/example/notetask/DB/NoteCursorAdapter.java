package com.example.notetask.DB;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.notetask.R;

public class NoteCursorAdapter extends CursorAdapter {
    public NoteCursorAdapter(Context context, Cursor c) {
        super(context, c, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvTitle = (TextView) view.findViewById(R.id.note_title);
        TextView tvDate = (TextView) view.findViewById(R.id.date_time);

        String noteName = cursor.getString(
                cursor.getColumnIndexOrThrow("name"));
        tvTitle.setText(noteName);
        String noteDate = cursor.getString(
                cursor.getColumnIndexOrThrow("date"));
        tvTitle.setText(noteDate);
    }
}
