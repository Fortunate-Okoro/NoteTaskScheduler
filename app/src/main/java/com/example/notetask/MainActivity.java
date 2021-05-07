package com.example.notetask;

import android.os.Bundle;

import com.example.notetask.ui.main.NoteFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.notetask.ui.main.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionToolbar = (Toolbar) findViewById(R.id.toolbar);
        actionToolbar.inflateMenu(R.menu.menu_note);

        setUpVariables();

    }

    private void setUpVariables(){
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        PagerAdapter sectionsPagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                invalidateOptionsMenu();
            }

            @Override
            public void onPageSelected(int position) {
//                if (position == 0){
//                    MainActivity.this.setTitle("NOTE");
//                    toolbar.getMenu().clear();
//                    toolbar.inflateMenu(R.menu.menu_note);
//                } else if (position == 1){
//                    MainActivity.this.setTitle("TASK");
//                    toolbar.getMenu().clear();
//                    toolbar.inflateMenu(R.menu.menu_task);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}