package com.example.notetask.ui.main;

import android.content.Intent;
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

import com.example.notetask.R;
import com.example.notetask.taskscheduler.TaskSchedulerActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TaskFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

//        pageViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
//        int index = 1;
//        if (getArguments() != null) {
//            index = getArguments().getInt(ARG_SECTION_NUMBER);
        //       }
        //       pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        final ListView listView = view.findViewById(R.id.list_view_task);
        final TextView textView = view.findViewById(R.id.new_task);
        final ImageView imageView = view.findViewById(R.id.imageView);
//        setHasOptionsMenu(true);

        textView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taskIntent = new Intent(getActivity(), TaskSchedulerActivity.class);
                startActivity(taskIntent);
           //     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_note, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sortBy){
            //write your function
            Toast.makeText(getActivity(), "Sort By", Toast.LENGTH_LONG).show();
        }

        if (id == R.id.settings){
            //write your function
            Toast.makeText(getActivity(), "Settings", Toast.LENGTH_LONG).show();
        }

 /**       switch (item.getItemId()) {
            case R.id.sortBy:
                Toast.makeText(getActivity(), "Sort By Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings3:
                Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }**/
        return super.onOptionsItemSelected(item);

    }
}
