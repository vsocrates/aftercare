package com.vsocrates.aftercare.myprofileandtreatment;

import org.codepond.android.wizardroid.R;
import org.codepond.android.wizardroid.core.ContextVariable;
import org.codepond.android.wizardroid.core.WizardStep;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MyProfileStep4 extends WizardStep implements View.OnClickListener{

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
	    
	    EditText primaryCareEt;
	    EditText oncologistEt;
	    EditText surgeonEt;
	    EditText OBGYNEt;
	    EditText radiologistEt;
	    EditText cancerCareCenterEt;
	    EditText supportGroupContactEt;
	    
	    String name;
	    String number;
	    String emailAddress;
	    String idFromPicker;
	    Uri contactData;
	    ContentResolver cr;
	    Cursor curPhone;
	    Cursor curEmail;
	    
	    private static final int CONTACT_PICKER_RESULT_PRIMARY = 1001;
	    private static final int CONTACT_PICKER_RESULT_ONCOLOGIST = 1002;
	    private static final int CONTACT_PICKER_RESULT_SURGEON = 1003;
	    private static final int CONTACT_PICKER_RESULT_OBGYN = 1004;
	    private static final int CONTACT_PICKER_RESULT_RADIOLOGIST = 1005;
	    private static final int CONTACT_PICKER_RESULT_CARE_CENTER = 1006;
	    private static final int CONTACT_PICKER_RESULT_SUPPORT_GROUP = 1007;
	    public static final String DEBUG_TAG = "tewtstestsetsetst";
	    
	    //You must have an empty constructor for every step
	    public MyProfileStep4() {
	    }

	    //Set your layout here
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.activity_my_profile_step4, container, false);
	        //Set listener for 'Next' button click
	        //Note that we are setting OnClickListener using getActivity() because
	        //the 'Next' button is actually part of the hosting activity's layout and
	        //not the step's layout
	        Button nextButton = (Button) getActivity().findViewById(R.id.next_button);
	        nextButton.setOnClickListener(this);
	        nextButton.setText("Next");
 
	        primaryCareEt = (EditText) v.findViewById(R.id.primaryCarePhysician);
	        primaryCareEt.setFocusable(false);
	        primaryCareEt.setClickable(true);
	        oncologistEt = (EditText) v.findViewById(R.id.oncologist);
	        oncologistEt.setFocusable(false);
	        oncologistEt.setClickable(true);
	        surgeonEt = (EditText) v.findViewById(R.id.surgeon);
	        surgeonEt.setFocusable(false);
	        surgeonEt.setClickable(true);
	        OBGYNEt = (EditText) v.findViewById(R.id.OBGYN);
	        OBGYNEt.setFocusable(false);
	        OBGYNEt.setClickable(true);
	        radiologistEt = (EditText) v.findViewById(R.id.radiologist);
	        radiologistEt.setFocusable(false);
	        radiologistEt.setClickable(true);
	        cancerCareCenterEt = (EditText) v.findViewById(R.id.cancerCareCenter);
	        cancerCareCenterEt.setFocusable(false);
	        cancerCareCenterEt.setClickable(true);
	        supportGroupContactEt = (EditText) v.findViewById(R.id.supportGroupContact);
	        supportGroupContactEt.setFocusable(false);
	        supportGroupContactEt.setClickable(true);
	        
	        primaryCareEt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent contactPickerIntent1 = new Intent(Intent.ACTION_PICK,  
							ContactsContract.Contacts.CONTENT_URI);  
		            startActivityForResult(contactPickerIntent1, CONTACT_PICKER_RESULT_PRIMARY);
		            
				}
			});
	        
	        oncologistEt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent contactPickerIntent2 = new Intent(Intent.ACTION_PICK,  
							ContactsContract.Contacts.CONTENT_URI);  
		            startActivityForResult(contactPickerIntent2, CONTACT_PICKER_RESULT_ONCOLOGIST);  	
				}
			});
	        
	        surgeonEt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent contactPickerIntent3 = new Intent(Intent.ACTION_PICK,  
							ContactsContract.Contacts.CONTENT_URI);  
		            startActivityForResult(contactPickerIntent3, CONTACT_PICKER_RESULT_SURGEON);  	
				}
			});
	        
	       OBGYNEt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent contactPickerIntent4 = new Intent(Intent.ACTION_PICK,  
	                    ContactsContract.Contacts.CONTENT_URI);  
	            startActivityForResult(contactPickerIntent4, CONTACT_PICKER_RESULT_OBGYN);
			}
		});
	       
	       radiologistEt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent contactPickerIntent5 = new Intent(Intent.ACTION_PICK,  
						ContactsContract.Contacts.CONTENT_URI);  
	            startActivityForResult(contactPickerIntent5, CONTACT_PICKER_RESULT_RADIOLOGIST);

			}
		});
	       
	    cancerCareCenterEt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent contactPickerIntent6 = new Intent(Intent.ACTION_PICK,  
						ContactsContract.Contacts.CONTENT_URI);  
	            startActivityForResult(contactPickerIntent6, CONTACT_PICKER_RESULT_CARE_CENTER);
			}
		});
	    
	    supportGroupContactEt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent contactPickerIntent7 = new Intent(Intent.ACTION_PICK,  
						ContactsContract.Contacts.CONTENT_URI);  
	            startActivityForResult(contactPickerIntent7, CONTACT_PICKER_RESULT_SUPPORT_GROUP);
	            
	            
			}
		});
	        
	    

	        return v;
	    }
	    
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data)
	    {
	    	super.onActivityResult(requestCode, resultCode, data);
	    	
	    	if (resultCode == Activity.RESULT_OK)
	    	{
	    		switch(requestCode)
	    		{
	    		
	    		case CONTACT_PICKER_RESULT_PRIMARY:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
	    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			           }
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    			  
	    		  
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close(); 
	    		  }      
	    		        primaryCareEt.setText(number + emailAddress);
	    		        
	    		        number = null;
	    		        emailAddress = null;
	    		        contactData = null;
	    		        idFromPicker = null;
	    		  
	    	        break;
	    	        

	    		case CONTACT_PICKER_RESULT_ONCOLOGIST:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
		    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			}
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close();      
	    		  }
	    		        oncologistEt.setText(number + emailAddress);
	    		        

	    		        number = null;
	    		        emailAddress = null;
	    		        contactData = null;
	    		        idFromPicker = null;
	    		        
	    	        break;
	    	        

	    		case CONTACT_PICKER_RESULT_SURGEON:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
		    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			}
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close();      
	    		  }
	    		        surgeonEt.setText(number + emailAddress);
	    		        

	    		        number = null;
	    		        emailAddress = null;
	    		        contactData = null;
	    		        idFromPicker = null;
	    		        
	    	        break;

	    		case CONTACT_PICKER_RESULT_OBGYN:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
		    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			}
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close();      
	    		  }
	    		        OBGYNEt.setText(number + emailAddress);
	    		        

	    		        number = null;
	    		        emailAddress = null;
	    		        contactData = null;
	    		        idFromPicker = null;
	    		        
	    	        break;

	    		case CONTACT_PICKER_RESULT_RADIOLOGIST:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
		    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			}
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close();      
	    		  }
	    		        radiologistEt.setText(number + emailAddress);

	    		        number = null;
	    		        emailAddress = null;
	    		        contactData = null;
	    		        idFromPicker = null;
	    		        
	    	        break;

	    		case CONTACT_PICKER_RESULT_CARE_CENTER:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
		    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			}
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close();      
	    		
	    		        cancerCareCenterEt.setText(number + emailAddress);

	    		        number = null;
	    		        emailAddress = null;
	    		        contactData = null;
	    		        idFromPicker = null;
	    		  }
	    	        break;

	    		case CONTACT_PICKER_RESULT_SUPPORT_GROUP:
	    			contactData = data.getData(); 
	    			idFromPicker = contactData.getLastPathSegment();
	    			cr = getActivity().getContentResolver();
	    			curPhone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	    						ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{idFromPicker}, null);
	    			if (curPhone.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER) > 0) {
		    			
	    			if (curPhone.moveToNext()) {
	    				int phoneIdx = curPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);  
	    			    number = curPhone.getString(phoneIdx);  
	    			    Log.v(DEBUG_TAG, "Got phone number: " + number);  
	    		        } 
	    		        curPhone.close();
	    			}
	    		    
	    		  curEmail = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID +" = ?",
	    				  		 new String[]{idFromPicker}, null);
	    		  if (curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS) > 0) {
	    		  if (curEmail.moveToNext()) {
	    				int emailIdx = curEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);  
	    			    emailAddress = curEmail.getString(emailIdx);  
	    			    Log.v(DEBUG_TAG, "Got email: " + emailAddress);  
	    		        } 
	    		        curEmail.close();     
	    		        
	    		    }
	    		  supportGroupContactEt.setText(number + emailAddress);

  		        number = null;
  		        emailAddress = null;
  		        contactData = null;
  		        idFromPicker = null;
	    	        break;
	    		
	    		
	    		}   
	                    		
	    			
	    	}
	    	
	    	
	    	}
	    	
	    
	    
	    @Override
	    public void onClick(View view) {
	        //Do some work
	        //(Vimig) Sqllite database writing should be done at the end of the entire wizard, after all information is confirmed 
	        
	        //These model changes will persist to the next step.
	        //Just make sure that you have the model defined there as well.
	        primaryCare = primaryCareEt.getText().toString();
	        oncologist = oncologistEt.getText().toString();
	        surgeon = surgeonEt.getText().toString();
	        OBGYN = OBGYNEt.getText().toString();
	        radiologist = cancerCareCenterEt.getText().toString();
	        cancerCareCenter = cancerCareCenterEt.getText().toString();
	        SupportGroupContact = supportGroupContactEt.getText().toString();
	        

	        //mForm.setFirstname(firstname.getText().toString());
	        //mForm.setLastname(lastname.getText().toString());

	        //And call done() to signal that the step is completed successfully
	        done();
	    }
}
