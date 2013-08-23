package com.vsocrates.aftercare.personalinfo;

import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.R.layout;
import org.codepond.android.wizardroid.R.menu;
import org.codepond.android.wizardroid.core.ContextVariable;
import org.codepond.android.wizardroid.core.WizardStep;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class PersonalInfoStep3 extends WizardStep implements View.OnClickListener  {


	@ContextVariable
    private String caregiverfirstname;
    @ContextVariable
    private String caregiverlastname;
    @ContextVariable
    private String caregiverdateBirth;
    @ContextVariable
    private String caregiverdateDiagnosis;
    @ContextVariable
    private String caregiverAgeDianosis;
    

    //You must have an empty constructor for every step
    public PersonalInfoStep3() {
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_personal_info_step3, container, false);
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
        EditText caregiverfirstnameEt = (EditText) getActivity().findViewById(R.id.caregiverFirstName);
        EditText caregiverlastnameEt = (EditText) getActivity().findViewById(R.id.caregiverLastName);
        EditText caregiverdateBirthEt = (EditText) getActivity().findViewById(R.id.caregiverdateofBirth);
        EditText caregiverdateDiagnosisEt = (EditText) getActivity().findViewById(R.id.caregiverdateofDiagnosis);
        EditText caregiverAgeDiagnosisEt = (EditText) getActivity().findViewById(R.id.caregiverageOfDiagnosis);
        //These model changes will persist to the next step.
        //Just make sure that you have the model defined there as well.
        caregiverfirstname = caregiverfirstnameEt.getText().toString();
        caregiverlastname = caregiverlastnameEt.getText().toString();
        caregiverdateBirth = caregiverdateBirthEt.getText().toString();
        caregiverdateDiagnosis = caregiverdateDiagnosisEt.getText().toString();
        caregiverAgeDianosis = caregiverAgeDiagnosisEt.getText().toString();
        
        //mForm.setFirstname(firstname.getText().toString());
        //mForm.setLastname(lastname.getText().toString());

        //And call done() to signal that the step is completed successfully
        done();
    }
}
