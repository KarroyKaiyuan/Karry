package com.example.sharedpreferences_1_342;


import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText worldReadET;
	private EditText worldWriteET;
	private EditText worldReadWriteET;
	private SharedPreferences worldReadSP;
	private SharedPreferences worldWriteSP;
	private SharedPreferences worldReadWriteSP;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        worldReadET=(EditText)findViewById(R.id.worldRead);
        worldWriteET=(EditText)findViewById(R.id.worldWrite);
        worldReadWriteET=(EditText)findViewById(R.id.worldReadWrite);
        worldReadSP=getSharedPreferences("worldRead",MODE_WORLD_READABLE);
        worldWriteSP=getSharedPreferences("worldWrite", MODE_WORLD_WRITEABLE);
        worldReadWriteSP=getSharedPreferences("worldReadWrite", MODE_WORLD_READABLE+MODE_WORLD_WRITEABLE);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String worldReadS=worldReadET.getText().toString();
				String worldWriteS=worldWriteET.getText().toString();
				String worldReadWriteS=worldReadWriteET.getText().toString();
				Editor worldReadE=worldReadSP.edit();
				Editor worldWriteE=worldWriteSP.edit();
				Editor worldReadWriteE=worldReadWriteSP.edit();
				worldReadE.putString("key", worldReadS);
				worldWriteE.putString("key", worldWriteS);
				worldReadWriteE.putString("key", worldReadWriteS);
				worldReadE.commit();
				worldWriteE.commit();
				worldReadWriteE.commit();
			}
		});
    }
}
