package com.example.contact_test371;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.os.Build;
import android.provider.ContactsContract.Contacts;

public class MainActivity extends Activity {

    private String[] columns=new String[]{
    		Contacts._ID,Contacts.DISPLAY_NAME};

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ContentResolver resolver=getContentResolver();
        Cursor cursor=resolver.query(Contacts.CONTENT_URI, columns,null,null,null);
        ContactAdapter adapter=new ContactAdapter(this,cursor);
        AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.edit);
        textView.setAdapter(adapter);
        
       
     }
 }


 


