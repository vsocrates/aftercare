package com.vsocrates.aftercare.personalinfo;

import org.codepond.android.wizardroid.R;


import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.codepond.android.wizardroid.core.*;

public class PersonalInfoStep1 extends WizardStep implements View.OnClickListener{

	    @ContextVariable
	    private String firstname;
	    @ContextVariable
	    private String lastname;
	    @ContextVariable
	    private String dateOfBirth;
	    @ContextVariable
	    private String dateOfDiagnosis;
	    @ContextVariable
	    private String ageOfDiagnosis;
	    

	    //You must have an empty constructor for every step
	    public PersonalInfoStep1() {
	    }

	    //Set your layout here
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.activity_personal_info_step1, container, false);
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
	        EditText firstnameEt = (EditText) getActivity().findViewById(R.id.firstnameField);
	        EditText lastnameEt = (EditText) getActivity().findViewById(R.id.lastnameField);
	        EditText dateOfBirthEt = (EditText) getActivity().findViewById(R.id.dateofBirth);
	        EditText dateOfDiagnosisEt = (EditText) getActivity().findViewById(R.id.dateofDiagnosis);
	        EditText ageOfDiagnosisEt = (EditText) getActivity().findViewById(R.id.ageOfDiagnosis);
	        
	        //These model changes will persist to the next step.
	        //Just make sure that you have the model defined there as well.
	        firstname = firstnameEt.getText().toString();
	        lastname = lastnameEt.getText().toString();
	        dateOfBirth = dateOfBirthEt.getText().toString();
	        dateOfDiagnosis = dateOfDiagnosisEt.getText().toString();
	        ageOfDiagnosis = ageOfDiagnosisEt.getText().toString();
	        
	        

	        //mForm.setFirstname(firstname.getText().toString());
	        //mForm.setLastname(lastname.getText().toString());

	        //And call done() to signal that the step is completed successfully
	        done();
	    }
}
