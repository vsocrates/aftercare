package com.vsocrates.aftercare.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

import org.codepond.android.wizardroid.ContextVariable;
import org.codepond.android.wizardroid.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import org.codepond.android.wizardroid.core.*;

public class CalendarAddAppointment extends Activity {
	
	@ContextVariable
	private String appointmentTitle;
	@ContextVariable
	private String appointmentLocation;
	@ContextVariable
	private Date appointmentStart;
	@ContextVariable
	private Date appointmentEnd;
	
	Calendar c = Calendar.getInstance();
	int mMinute, mHour, mDay, mMonth, mYear;
	
	DatePickerDialog.OnDateSetListener d;
	TimePickerDialog.OnTimeSetListener t1;
	TimePickerDialog.OnTimeSetListener t2;
	
	DatePickerDialog appointmentDatePicker;
	TimePickerDialog appointmentTime1Picker;
	TimePickerDialog appointmentTime2Picker;
	
	EditText appointmentTitleET;
	EditText appointmentLocationET;
	EditText appointmentDateET;
	EditText appointmentStartTimeET;
	EditText appointmentEndTimeET;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar_add_appointment);	
		
		appointmentTitleET = (EditText) findViewById(R.id.appointmentTitle);
		appointmentLocationET = (EditText) findViewById(R.id.appointmentLocation);

		d = new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				
				c.set(Calendar.YEAR, year);
				c.set(Calendar.MONTH, monthOfYear);
				c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				
				String myFormat = "MM/dd/yyyy";
				SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
				
				appointmentDateET.setText("Appointment Date: " + sdf.format(c.getTime()));
				appointmentStart = c.getTime();
			}
		};
		
		t1 = new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				
				c.set(Calendar.HOUR_OF_DAY, hourOfDay);
				c.set(Calendar.MINUTE, minute);
				
				String myFormat = "HH:mm";
				SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
				
				appointmentStartTimeET.setText("Appointment Start Time: " + sdf.format(c.getTime()));
				appointmentStart = c.getTime();
			}
		};
		
		t2 = new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				
				c.set(Calendar.HOUR_OF_DAY, hourOfDay);
				c.set(Calendar.MINUTE, minute);
				
				String myFormat = "HH:mm";
				SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
				
				appointmentEndTimeET.setText("Appointment End Time: " + sdf.format(c.getTime()));
				appointmentEnd = c.getTime();
			}
		};
		
		appointmentDateET = (EditText) findViewById(R.id.appointmentDate);
        appointmentDatePicker = new DatePickerDialog(this, d, 
        		c.get(Calendar.YEAR),
        		c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        appointmentDateET.setFocusable(false);
        appointmentDateET.setClickable(true);
        appointmentDateET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	appointmentDatePicker.show();            	
            }
        });
        
        appointmentStartTimeET = (EditText) findViewById(R.id.appointmentStartTime);
        appointmentTime1Picker = new TimePickerDialog(this, t1, 
        		c.get(Calendar.HOUR_OF_DAY), 
        		c.get(Calendar.MINUTE),
        		true);
        appointmentStartTimeET.setFocusable(false);
        appointmentStartTimeET.setClickable(true);
        appointmentStartTimeET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	appointmentTime1Picker.show();            	
            }
        });
        
        appointmentEndTimeET = (EditText) findViewById(R.id.appointmentEndTime);
        appointmentTime2Picker = new TimePickerDialog(this, t2, 
        		c.get(Calendar.HOUR_OF_DAY), 
        		c.get(Calendar.MINUTE),
        		true);
        appointmentEndTimeET.setFocusable(false);
        appointmentEndTimeET.setClickable(true);
        appointmentEndTimeET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	appointmentTime2Picker.show();            	
            }
        });
	}

	public void onClick(View view) {
        appointmentTitle = appointmentTitleET.getText().toString();
        appointmentLocation = appointmentLocationET.getText().toString();
    }
}
