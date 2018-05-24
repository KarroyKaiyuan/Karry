package com.example.test140;

import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends Activity {

	private Chronometer chronometer=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		chronometer=(Chronometer)findViewById(R.id.chronometer1);
		chronometer.setFormat("¼ÆÊ±£º%s");
		
	}
	public void onStart(View v){
		chronometer.start();
	}
	public void onStop(View v){
		chronometer.stop();
	}
	public void onReset(View v){
		chronometer.setBase(SystemClock.elapsedRealtime());
	}

	

}
