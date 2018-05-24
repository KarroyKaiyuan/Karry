package com.example.test135;

import android.os.Bundle;
import android.animation.TimeAnimator;
import android.animation.TimeAnimator.TimeListener;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	private TimePicker timePicker1;
	private Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		timePicker1=(TimePicker)findViewById(R.id.timePicker1);
		button1=(Button)findViewById(R.id.button1);
		OnChangeListener buc=new OnChangeListener();
		button1.setOnClickListener(buc);
		//是否用24小时制
		timePicker1.setIs24HourView(true);
		TimeListener times=new TimeListener();
		timePicker1.setOnTimeChangedListener(times);
	}
    
	class OnChangeListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int h=timePicker1.getCurrentHour();
			int m=timePicker1.getCurrentMinute();
			System.out.println("h:"+h+"m"+m);
		}
	}
	class TimeListener implements OnTimeChangedListener{

		@Override
		public void onTimeChanged(TimePicker view, 
				int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			System.out.println("h:"+hourOfDay+"m"+minute);
		}
	}
	public boolean OnCreatOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
