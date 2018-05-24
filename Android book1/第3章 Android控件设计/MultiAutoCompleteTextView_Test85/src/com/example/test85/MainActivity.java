package com.example.test85;

import javax.security.auth.PrivateCredentialPermission;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String[] COUNTRIES=new String[] 
    			{"Android test","Android view","Android multi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
        		android.R.layout.simple_dropdown_item_1line,COUNTRIES);
        MultiAutoCompleteTextView textView=(MultiAutoCompleteTextView)
        		findViewById(R.id.multiAutoCompleteTextView1);
        textView.setAdapter(adapter);
        textView.setThreshold(1);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        textView.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?>arg0,View arg1,int arg2,long arg3) {
				Log.v("textView.setOnItemClickListener",""+((TextView)arg1).getText());
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
