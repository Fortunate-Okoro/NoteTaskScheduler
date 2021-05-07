package com.example.notetask.notecreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.notetask.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.content.Intent.ACTION_OPEN_DOCUMENT;

public class NoteCreatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_creator);

        final EditText noteTitle = findViewById(R.id.note_title);
        final EditText noteDescription = findViewById(R.id.note_description);
        final ImageView placeHolder = findViewById(R.id.placeHolder);
        final Button chooseImage = findViewById(R.id.chooseImage);
        final Button saveImage = findViewById(R.id.saveImage);
        final TextView fullDate = findViewById(R.id.date);

        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveText();
            }
        });

        boolean iskitkat = false;
        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser();
            }
        });

    }

    private void saveText() {
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("Text File", MODE_APPEND));
            final EditText textTitle = findViewById(R.id.note_title);
            final EditText textDescription = findViewById(R.id.note_description);
            String title = textTitle.getText().toString();
            String description = textDescription.getText().toString();
            out.write(title);
            out.write(description);
            Toast.makeText(this, "The contexts are saved in the file.", Toast.LENGTH_LONG).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception:" + t.toString(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "Save not implemented yet.", Toast.LENGTH_LONG).show();
    }

    public void showFileChooser(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            boolean isKitKat = true;
            startActivityForResult(Intent.createChooser(intent, "Select File"), 1);

            Toast.makeText(this, "Files choosen are here.", Toast.LENGTH_LONG).show();
        }

    }


}