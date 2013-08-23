package com.vsocrates.aftercare.myprofileandtreatment;

import org.codepond.android.wizardroid.R;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.codepond.android.wizardroid.core.*;

public class MyProfileStep1 extends WizardStep implements View.OnClickListener{

	    @ContextVariable
	    private String cancerType;
	    @ContextVariable
	    private String cancerLocation;
	    @ContextVariable
	    private String estrogenReceptor;
	    @ContextVariable
	    private String progesteroneReceptor;
	    @ContextVariable
	    private String her2Level;
	    

	    //You must have an empty constructor for every step
	    public MyProfileStep1() {
	    }

	    //Set your layout here
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.activity_my_profile_step1, container, false);
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
	        EditText cancerTypeEt = (EditText) getActivity().findViewById(R.id.cancerType);
	        EditText cancerLocationEt = (EditText) getActivity().findViewById(R.id.cancerLocation);
	        EditText estrogenReceptorLevelEt = (EditText) getActivity().findViewById(R.id.estrogenReceptorLevel);
	        EditText progesteroneReceptorLevelEt = (EditText) getActivity().findViewById(R.id.progesteroneReceptorLevel);
	        EditText her2LevelEt = (EditText) getActivity().findViewById(R.id.her2Level);
	        
	        //These model changes will persist to the next step.
	        //Just make sure that you have the model defined there as well.
	        cancerType = cancerTypeEt.getText().toString();
	        cancerLocation = cancerLocationEt.getText().toString();
	        estrogenReceptor = estrogenReceptorLevelEt.getText().toString();
	        progesteroneReceptor = progesteroneReceptorLevelEt.getText().toString();
	        her2Level = her2LevelEt.getText().toString();
	        
	        

	        //mForm.setFirstname(firstname.getText().toString());
	        //mForm.setLastname(lastname.getText().toString());

	        //And call done() to signal that the step is completed successfully
	        done();
	    }
}
