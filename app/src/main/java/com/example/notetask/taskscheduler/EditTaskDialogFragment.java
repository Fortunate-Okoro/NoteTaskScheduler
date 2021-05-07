package com.example.notetask.taskscheduler;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.notetask.R;

import java.text.DateFormat;
import java.util.Calendar;

public class EditTaskDialogFragment extends DialogFragment {
    private EditText etVenue;
    private EditText etFullDate;
    private EditText etStartTime;
    private EditText etEndTime;

    public EditTaskDialogFragment(){

    }

    public static EditTaskDialogFragment newInstance(String title){
        EditTaskDialogFragment fragment = new EditTaskDialogFragment();
        Bundle args = new Bundle();
        args.putString("Edit Task", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_task_dialog_fragment, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etVenue = (EditText) view.findViewById(R.id.etVenue);
        etFullDate = (EditText) view.findViewById(R.id.etFullDate);
        etStartTime = (EditText) view.findViewById(R.id.etStartTime);
        etEndTime = (EditText) view.findViewById(R.id.etEndTime);

        String title = getArguments().getString("Edit Task", "Enter Task");
        getDialog().setTitle(title);

        etVenue.requestFocus();
        etFullDate.requestFocus();
        etStartTime.requestFocus();
        etEndTime.requestFocus();

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        );
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, false);
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            //Do something with time set
        }

        public void showTimePickerDialog(View v){
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getFragmentManager(), "timePicker");
        }
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day );
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        }

        public void showDatePickerDialog(View v){
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getFragmentManager(), "datePicker");
        }

    }
}
