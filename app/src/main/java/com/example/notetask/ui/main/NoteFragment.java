package com.example.notetask.ui.main;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notetask.DB.Note;
import com.example.notetask.DB.NoteCursorAdapter;
import com.example.notetask.DB.NoteDbHelper;
import com.example.notetask.R;
import com.example.notetask.notecreator.NoteCreatorActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NoteFragment extends Fragment {
//    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        final ListView listView = view.findViewById(R.id.list_view_note);
        final TextView textView = view.findViewById(R.id.new_note);
        final ImageView imageView = view.findViewById(R.id.imageView);
//        setHasOptionsMenu(true);

        textView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taskIntent = new Intent(getActivity(), NoteCreatorActivity.class);
                startActivity(taskIntent);
             //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

 /**       SQLiteDatabase db = noteDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM note",
                null);
        final NoteCursorAdapter adapter = new NoteCursorAdapter(this, cursor);
        TextView tvTitle = (TextView) this.findViewById(R.id.note_title);
        TextView tvDate = (TextView) this.findViewById(R.id.date_time);**/


        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_note, menu);
        menu.findItem(R.id.settings).setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sortBy){
            //write your function
            Toast.makeText(getActivity(), "Sort By", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

        /**    if (id == R.id.settings){
         //write your function
         Toast.makeText(getActivity(), "Settings", Toast.LENGTH_LONG).show();
         }**/
        /**       switch (item.getItemId()) {
         case R.id.sortBy:
         Toast.makeText(getActivity(), "Sort By Clicked", Toast.LENGTH_SHORT).show();
         return true;
         case R.id.settings:
         Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT).show();
         return true;
         default:
         break;
         }**/
}