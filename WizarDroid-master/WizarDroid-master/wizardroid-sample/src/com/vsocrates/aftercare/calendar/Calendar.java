package com.vsocrates.aftercare.calendar;

import java.util.GregorianCalendar;

import org.codepond.android.wizardroid.ContextVariable;
import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.R.layout;
import org.codepond.android.wizardroid.R.menu;

import com.vsocrates.aftercare.BaseCamp;
import com.vsocrates.aftercare.calendar.Calendar;
import com.vsocrates.aftercare.main.MainActivity;
import com.vsocrates.aftercare.myprofileandtreatment.*;
import com.vsocrates.aftercare.personalinfo.*;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.net.Uri;
import android.content.ContentUris;


@SuppressLint("NewApi")
public class Calendar extends Activity {
	
	Button addAppointmentTextButton;
	Button viewCalendarTextButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		// Show the Up button in the action bar.
		setupActionBar();
		
		addAppointmentTextButton = (Button) findViewById(R.id.addAppointmentTextButton);
		viewCalendarTextButton = (Button) findViewById(R.id.viewCalendarTextButton);
		
	}
	
	public void addAppointmentClick(View v)
	{		
		/*Intent calIntent = new Intent(Intent.ACTION_INSERT);
		calIntent.setType("vnd.android.cursor.item/event");
		calIntent.putExtra(Events.TITLE, "Appointment");
		calIntent.putExtra(Events.EVENT_LOCATION, "Memorial");
		GregorianCalendar calDate = new GregorianCalendar(2012, 7, 15);
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
		     calDate.getTimeInMillis());
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
		     calDate.getTimeInMillis());
		startActivity(calIntent);*/
		
		Intent calIntent = new Intent(v.getContext(), CalendarAddAppointment.class);
		Calendar.this.startActivity(calIntent);
	}
	
	public void viewCalendarClick(View v)
	{
		long startMillis = 0;
		Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
		builder.appendPath("time");
		ContentUris.appendId(builder, startMillis);
		Intent calIntent2 = new Intent(Intent.ACTION_VIEW)
			.setData(builder.build());
		Calendar.this.startActivity(calIntent2);
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_personal_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
