package com.vsocrates.aftercare;

import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.R.layout;
import org.codepond.android.wizardroid.R.menu;

import com.vsocrates.aftercare.main.MainActivity;
import com.vsocrates.aftercare.myprofileandtreatment.*;
import com.vsocrates.aftercare.personalinfo.*;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class BaseCamp extends Activity {
	
	ImageButton myPersonalInfoImageButton;
	ImageButton myProfileImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_camp);
		// Show the Up button in the action bar.
				setupActionBar();
				
	myPersonalInfoImageButton = (ImageButton) findViewById(R.id.personalInfoImageButton);
	myProfileImageButton = (ImageButton) findViewById(R.id.myProfileImageButton);

	
	}
	
	public void personalInfoClick(View v)
	{
		Intent basCampIntent1 = new Intent(v.getContext(), MyPersonalInfo.class);
		BaseCamp.this.startActivity(basCampIntent1);
	}
	
	
	
	public void myProfileClick(View v)
	{
		Intent basCampIntent2 = new Intent(v.getContext(), MyProfile.class);
		BaseCamp.this.startActivity(basCampIntent2);
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
		getMenuInflater().inflate(R.menu.base_camp, menu);
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

