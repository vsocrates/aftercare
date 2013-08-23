package com.vsocrates.aftercare.myprofileandtreatment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.core.ContextVariable;
import org.codepond.android.wizardroid.core.WizardStep;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MyProfileStep2 extends WizardStep implements View.OnClickListener {

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
    
	
    Calendar c = Calendar.getInstance();
    int mDay, mMonth, mYear;
    DatePickerDialog.OnDateSetListener d;
    

    DatePickerDialog biopsyDatePicker;
    DatePickerDialog surgeryDatePicker;    
    DatePickerDialog radiationDatePicker;
    DatePickerDialog chemoDatePicker;
    DatePickerDialog geneticDatePicker;
    
    EditText biopsyDateEt;
    EditText surgeryDateEt;
    EditText radiationTherapyDateEt;
    EditText chemotherapyDateEt;
    EditText geneticTestingDateEt;
    
    int dateDialogId;
    int DATE_DIALOG_ID = 0;
	    //You must have an empty constructor for every step
	    public MyProfileStep2() {
	    }

	    //Set your layout here
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.activity_my_profile_step2, container, false);
	        //Set listener for 'Next' button click
	        //Note that we are setting OnClickListener using getActivity() because
	        //the 'Next' button is actually part of the hosting activity's layout and
	        //not the step's layout
	        
	        
	        Button nextButton = (Button) getActivity().findViewById(R.id.next_button);
	        nextButton.setOnClickListener(this);
	        nextButton.setText("Next");   
	        
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
					
					if (DATE_DIALOG_ID == 1)
						{
							biopsyDateEt.setText("Biopsy Date: " + sdf.format(c.getTime()));
							biopsyDate = c.getTime();
						}
					else if (DATE_DIALOG_ID == 2)
					{
						surgeryDateEt.setText("Surgery Date: " + sdf.format(c.getTime()));
						surgeryDate = c.getTime();
					}
					else if (DATE_DIALOG_ID == 3)
					{
						radiationTherapyDateEt.setText("Radiation Therapy Date: " + sdf.format(c.getTime()));
						radiationTherapyDate = c.getTime();
						
					}
					else if (DATE_DIALOG_ID == 4)
					{
						chemotherapyDateEt.setText("Chemotherapy Date: " + sdf.format(c.getTime()));
						chemotherapyDate = c.getTime();
					}
					else if (DATE_DIALOG_ID ==  5)
					{
						geneticTestingDateEt.setText("Genetic Testing Date: " + sdf.format(c.getTime()));
						geneticTestingDate = c.getTime();
					}
					else
					{
						throw new IllegalArgumentException();
					}
					
		                
				}
			};
	        
	        biopsyDateEt = (EditText) v.findViewById(R.id.biopsyDate);
	        biopsyDatePicker = new DatePickerDialog(getActivity(), d, c.get(Calendar.YEAR),
	        		c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH));

	        biopsyDateEt.setFocusable(false);
	        biopsyDateEt.setClickable(true);
	        biopsyDateEt.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                
	            	biopsyDatePicker.show();
	            	DATE_DIALOG_ID = 1;
	            	
	            }
	        });
	        
	        surgeryDateEt = (EditText) v.findViewById(R.id.surgeryDate);
	        surgeryDatePicker = new DatePickerDialog(getActivity(), d, c.get(Calendar.YEAR),
	        		c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH));
	        
	        surgeryDateEt.setFocusable(false);
	        surgeryDateEt.setClickable(true);
	        surgeryDateEt.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                
	            	surgeryDatePicker.show();
	            	DATE_DIALOG_ID = 2;
	            }
	        });
	        
	        radiationTherapyDateEt = (EditText) v.findViewById(R.id.radiationDate);
	        radiationDatePicker = new DatePickerDialog(getActivity(), d, c.get(Calendar.YEAR),
	        		c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH));
	        radiationTherapyDateEt.setFocusable(false);
	        radiationTherapyDateEt.setClickable(true);
	        radiationTherapyDateEt.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                
	            	radiationDatePicker.show();
	            	DATE_DIALOG_ID = 3;
	            }
	        });
	        
	        chemotherapyDateEt = (EditText) v.findViewById(R.id.chemotherapyDate);
	        chemoDatePicker = new DatePickerDialog(getActivity(), d, c.get(Calendar.YEAR),
	        		c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH));
	        chemotherapyDateEt.setFocusable(false);
	        chemotherapyDateEt.setClickable(true);
	        chemotherapyDateEt.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                
	            	chemoDatePicker.show();
	            	DATE_DIALOG_ID = 4;
	            }
	        });
	        
	        geneticTestingDateEt = (EditText) v.findViewById(R.id.geneticTestDate);
	        geneticDatePicker = new DatePickerDialog(getActivity(), d, c.get(Calendar.YEAR),
	        		c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH));
	        geneticTestingDateEt.setFocusable(false);
	        geneticTestingDateEt.setClickable(true);
	        geneticTestingDateEt.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                
	            	geneticDatePicker.show();
	            	DATE_DIALOG_ID = 5;
	            }
	        });
	        
	       return v;
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
