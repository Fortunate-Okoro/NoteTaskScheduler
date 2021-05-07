package com.example.notetask.taskscheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.notetask.R;

public class TaskSchedulerActivity extends AppCompatActivity {
    public static String ALARM_TO_SET = "ALRMTOSEND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_scheduler);

        final LinearLayout linearLayout = findViewById(R.id.linearLayout);
        final Button setAlarm = findViewById(R.id.setAlarm);
        final Button editAlarm = findViewById(R.id.editTask);

        editAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                EditTaskDialogFragment editTaskDialogFragment = EditTaskDialogFragment.newInstance("Edit Task");
                editTaskDialogFragment.show(fm, "edit_task_dialog_fragment");
            }
        });

 /**       setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = 10 * 1000;

                Intent intentAlarm = new Intent(TaskSchedulerActivity.this, AlarmReciever.class);

                AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                PendingIntent pIntent = PendingIntent.getBroadcast(TaskSchedulerActivity.this, 0, intentAlarm, 0);
                alarm.setRepeating(AlarmManager.RTC_WAKEUP, time, time, pIntent);
            }
        });**/
    }
}