package com.vsocrates.aftercare.myprofileandtreatment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.core.ContextVariable;
import org.codepond.android.wizardroid.core.WizardStep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyProfileSummary extends WizardStep implements View.OnClickListener{

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
    
    @ContextVariable
	private Date biopsyDate;
	@ContextVariable
    private Date surgeryDate;
    @ContextVariable
    private Date radiationTherapyDate;
    @ContextVariable
    private Date chemotherapyDate;
    @ContextVariable
    private Date geneticTestingDate;
    
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
    
    @ContextVariable
    private String primaryCare;
    @ContextVariable
    private String oncologist;
    @ContextVariable
    private String surgeon;
    @ContextVariable
    private String OBGYN;
    @ContextVariable
    private String radiologist;
    @ContextVariable
    private String cancerCareCenter;
    @ContextVariable
    private String SupportGroupContact;
	    

	    //You must have an empty constructor for every step
	    public MyProfileSummary() {
	    }

	    //Set your layout here
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.activity_my_profile_summary, container, false);
	        //Set listener for 'Next' button click
	        //Note that we are setting OnClickListener using getActivity() because
	        //the 'Next' button is actually part of the hosting activity's layout and
	        //not the step's layout
	        Button nextButton = (Button) getActivity().findViewById(R.id.next_button);
	        nextButton.setOnClickListener(this);
	        nextButton.setText("Finish");
	        
	        String myFormat = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
			
	        TextView cancerTypeTV = (TextView) v.findViewById(R.id.review_cancerType);
	        TextView cancerLocationTV = (TextView) v.findViewById(R.id.review_cancerLocation);
	        TextView estrogenReceptorTV = (TextView) v.findViewById(R.id.review_estrogenReceptor);
	        TextView progesteroneReceptorTV = (TextView) v.findViewById(R.id.review_progesteroneReceptor);
	        TextView her2LevelTV = (TextView) v.findViewById(R.id.review_her2Level);
	        
	        TextView biopsyDateTV = (TextView) v.findViewById(R.id.review_biopsyDate);
	        TextView surgeryDateTV = (TextView) v.findViewById(R.id.review_surgeryDate);
	        TextView radiationTherapyDateTV = (TextView) v.findViewById(R.id.review_radiationTherapyDate);
	        TextView chemotherapyDateTV = (TextView) v.findViewById(R.id.review_chemotherapyDate);
	        TextView geneticTestingDateTV = (TextView) v.findViewById(R.id.review_geneticTestingDate);
	        
	        TextView treatmentMedsTV = (TextView) v.findViewById(R.id.review_treatmentMedication);
	        TextView currentMedsTV = (TextView) v.findViewById(R.id.review_currentMedication);
	        TextView allergiesTV = (TextView) v.findViewById(R.id.review_allergies);
	        TextView pharmacyNameTV = (TextView) v.findViewById(R.id.review_pharmacyName);
	        TextView pharmacyLocationTV = (TextView) v.findViewById(R.id.review_pharmacyLocation);
	        
	        TextView primaryPhysicianTV = (TextView) v.findViewById(R.id.review_primaryCare);
	        TextView oncologistTV = (TextView) v.findViewById(R.id.review_oncologist);
	        TextView surgeonTV = (TextView) v.findViewById(R.id.review_surgeon);
	        TextView obgynTV = (TextView) v.findViewById(R.id.review_OBGYN);
	        TextView cancerCareCenterTV = (TextView) v.findViewById(R.id.review_cancerCareCenter);
	        TextView supportGroupContactTV = (TextView) v.findViewById(R.id.review_supportGroupContact);
	        
	        cancerTypeTV.setText(cancerType);
	        cancerLocationTV.setText(cancerLocation);
	        estrogenReceptorTV.setText(estrogenReceptor);
	        progesteroneReceptorTV.setText(progesteroneReceptor);
	        her2LevelTV.setText(her2Level);
	        
	        biopsyDateTV.setText("Biopsy Date: " + sdf.format(biopsyDate.getTime()));
	        surgeryDateTV.setText("Surgery Date: " + sdf.format(surgeryDate.getTime()));
	        radiationTherapyDateTV.setText("Radiation Therapy Date: " + sdf.format(radiationTherapyDate.getTime()));
	        chemotherapyDateTV.setText("Chemotherapy Date: " + sdf.format(chemotherapyDate.getTime()));
	        geneticTestingDateTV.setText("Genetic Testing Date: " + sdf.format(geneticTestingDate.getTime()));
	        
	        treatmentMedsTV.setText(treatmentMeds);
	        currentMedsTV.setText(currentMeds);
	        allergiesTV.setText(allergies);
	        pharmacyNameTV.setText(pharmacyName);
	        pharmacyLocationTV.setText(pharmacyLocation);
	        
	        primaryPhysicianTV.setText(primaryCare);
	        oncologistTV.setText(oncologist);
	        surgeonTV.setText(surgeon);
	        obgynTV.setText(OBGYN);
	        cancerCareCenterTV.setText(cancerCareCenter);
	        supportGroupContactTV.setText(SupportGroupContact);
	        
	        
	        
	        return v;
	    }

	    
	    public void onSendasAttachment(View view){
	    	
	    }
	    
	    public void onFinishForm (View view)
	    {
	    	
	    }
	    @Override
	    public void onClick(View view) {
	        //Do some work
	        //(Vimig) Sqllite database writing should be done at the end of the entire wizard, after all information is confirmed 
	        
	        //These model changes will persist to the next step.
	        //Just make sure that you have the model defined there as well.
	        
	        

	        //mForm.setFirstname(firstname.getText().toString());
	        //mForm.setLastname(lastname.getText().toString());

	        //And call done() to signal that the step is completed successfully
	        done();
	    }
}
