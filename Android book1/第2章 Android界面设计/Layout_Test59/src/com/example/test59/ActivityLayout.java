package com.example.test59;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityLayout  extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layoutMain=new LinearLayout(this);
		layoutMain.setOrientation(LinearLayout.HORIZONTAL);
		setContentView(layoutMain);
		LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		RelativeLayout layoutLeft=(RelativeLayout)inflater.inflate(R.layout.left, null);
		RelativeLayout layoutRight=(RelativeLayout)inflater.inflate(R.layout.right, null);
		
		RelativeLayout.LayoutParams relParam=new RelativeLayout.LayoutParams
				(RelativeLayout.LayoutParams.WRAP_CONTENT, 
						RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutMain.addView(layoutLeft,100,100);
		layoutMain.addView(layoutRight,relParam);
		
		
		
	}
	

}
