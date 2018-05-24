package com.example.sharedpreferences_2_344;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView worldReadTV;
	private TextView worldWriteTV;
	private TextView worldReadWriteTV;
	private SharedPreferences worldReadSP;
	private SharedPreferences worldWriteSP;
	private SharedPreferences worldReadWriteSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context otherContext=null;
        try {
			otherContext=createPackageContext("com.example.sharedpreferences_1_342", MODE_PRIVATE);
		} catch (NameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
        worldReadSP=otherContext.getSharedPreferences("worldRead", MODE_WORLD_READABLE);
        worldWriteSP=getSharedPreferences("worldWrite", MODE_WORLD_WRITEABLE);
        worldReadWriteSP=getSharedPreferences("worldReadWrite", MODE_WORLD_READABLE+MODE_WORLD_WRITEABLE);
        worldReadTV=(TextView)findViewById(R.id.worldRead);
        worldWriteTV=(TextView)findViewById(R.id.worldWrite);
        worldReadWriteTV=(TextView)findViewById(R.id.worldReadWrite);
        worldReadTV.setText("全局可读："+worldReadSP.getString("key", "null"));
        worldWriteTV.setText("全局可写："+worldWriteSP.getString("key", "null"));
        worldReadWriteTV.setText("全局可读可写："+worldReadWriteSP.getString("key", "null"));
    }


    
    
}
