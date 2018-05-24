package com.example.test119;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.main);
		setProgressBarVisibility(true);
		final ProgressBar progressHorizontal=(ProgressBar)
				findViewById(R.id.progressBar1);
		setProgress(progressHorizontal.getProgress()*100);
		setSecondaryProgress(progressHorizontal.getSecondaryProgress()*100);
		
		Button button=(Button)findViewById(R.id.decrease);
		button.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressHorizontal.incrementProgressBy(1);
				setProgress(progressHorizontal.getProgress()*100);
			}
		});
		Button button1=(Button)findViewById(R.id.increase);
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressHorizontal.incrementProgressBy(-1);
				setProgress(progressHorizontal.getProgress()*100);
			}
		});
		Button button2=(Button)findViewById(R.id.increase_secondary);
		button2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressHorizontal.incrementProgressBy(1);
				setProgress(progressHorizontal.getProgress()*100);
			}
		});
		Button button3=(Button)findViewById(R.id.decrease_secondary);
		button3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressHorizontal.incrementProgressBy(-1);
				setProgress(progressHorizontal.getProgress()*100);
			}
		});
	}

	
}
