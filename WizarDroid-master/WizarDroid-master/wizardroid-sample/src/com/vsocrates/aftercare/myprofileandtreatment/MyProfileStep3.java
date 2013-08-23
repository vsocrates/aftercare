package com.vsocrates.aftercare.myprofileandtreatment;

import org.codepond.android.wizardroid.R;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.codepond.android.wizardroid.core.*;

public class MyProfileStep3 extends WizardStep implements View.OnClickListener{

	    @ContextVariable
	    private String treatmentMeds;
	    @ContextVariable
	    private String currentMeds;
	    @ContextVariable
	    private String allergies;
	    @ContextVariable
	    private String pharmacyName;
	    @ContextVariable
	    private String pharmacyLocation;
	    

	    //You must have an empty constructor for every step
	    public MyProfileStep3() {
	    }

	    //Set your layout here
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.activity_my_profile_step3, container, false);
	        //Set listener for 'Next' button click
	        //Note that we are setting OnClickListener using getActivity() because
	        //the 'Next' button is actually part of the hosting activity's layout and
	        //not the step's layout
	        Button nextButton = (Button) getActivity().findViewById(R.id.next_button);
	        nextButton.setOnClickListener(this);
	        nextButton.setText("Next");

	        return v;
	    }

	    @Override
	    public void onClick(View view) {
	        //Do some work
	        //(Vimig) Sqllite database writing should be done at the end of the entire wizard, after all information is confirmed 
	        EditText treatmentMedsEt = (EditText) getActivity().findViewById(R.id.drugsDuringTreatment);
	        EditText currentMedsEt = (EditText) getActivity().findViewById(R.id.currentMedication);
	        EditText allergiesEt = (EditText) getActivity().findViewById(R.id.allergies);
	        EditText pharmacyNameEt = (EditText) getActivity().findViewById(R.id.pharmacyName);
	        EditText pharmacyLocationEt = (EditText) getActivity().findViewById(R.id.pharmacyLocation);
	        
	        //These model changes will persist to the next step.
	        //Just make sure that you have the model defined there as well.
	        treatmentMeds = treatmentMedsEt.getText().toString();
	        currentMeds = currentMedsEt.getText().toString();
	        allergies = allergiesEt.getText().toString();
	        pharmacyName = pharmacyNameEt.getText().toString();
	        pharmacyLocation = pharmacyLocationEt.getText().toString();
	        
	        

	        //mForm.setFirstname(firstname.getText().toString());
	        //mForm.setLastname(lastname.getText().toString());

	        //And call done() to signal that the step is completed successfully
	        done();
	    }
}
