package com.vsocrates.aftercare.personalinfo;

import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.R.layout;
import org.codepond.android.wizardroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

import org.codepond.android.wizardroid.core.*;

public class MyPersonalInfo extends WizardActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_personal_info);
		// Show the Up button in the action bar.
		//setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	/*	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
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
	*/
	@Override
    public void onSetup(WizardFlow flow) {
        flow = new WizardFlow.Builder()
                .setActivity(this)                      //First, set the hosting activity for the wizard
                .setContainerId(R.id.step_container)    //then set the layout container for the steps.
                .addStep(PersonalInfoStep1.class)                   //Add your steps in the order you want them
                .addStep(PersonalInfoStep2.class)  
                .addStep(PersonalInfoStep3.class)//to appear and eventually call create()
                .create();                              //to create the wizard flow.

        //Call the super method using the newly created flow
        super.onSetup(flow);
    }

    //Overriding this method is optional
    @Override
    public void onWizardDone() {
        //Do whatever you want to do once the Wizard is complete
        //in this case I just close the activity, which causes Android
        //to go back to the previous activity.
        finish();
    }

}
