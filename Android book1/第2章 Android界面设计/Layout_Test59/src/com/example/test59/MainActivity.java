package com.example.test59;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    OnClickListener listener0=null;
	OnClickListener listener1=null;
	OnClickListener listener2=null;
	OnClickListener listener3=null;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listener0=new OnClickListener() {		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent0=new Intent(MainActivity.this,ActivityFrameLayout.class);
				setTitle("FrameLayout");
				startActivity(intent0);
			}

			
		};
		listener1=new OnClickListener() {		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1=new Intent(MainActivity.this,ActivityRelativeLayout.class);
				
				startActivity(intent1);
			}

			
		};
		listener2=new OnClickListener() {		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setTitle("’‚ «‘⁄ActivityLayout");
				Intent intent2=new Intent(MainActivity.this,ActivityLayout.class);				
				startActivity(intent2);
			}

			
		};
		listener3=new OnClickListener() {		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent3=new Intent(MainActivity.this,ActivityTableLayout.class);
				setTitle("TableLayout");
				startActivity(intent3);
			}

		};
		setContentView(R.layout.main);
		
		button0=(Button)findViewById(R.id.button0);
		button0.setOnClickListener(listener0);
		button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(listener1);
		button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(listener2);
		button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener(listener3);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
