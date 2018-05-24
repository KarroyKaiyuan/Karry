package com.example.test169;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private PendingIntent pendingIntent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button buttonStart=(Button)this.findViewById(R.id.startalarm);
		Button buttonCancel=(Button)this.findViewById(R.id.cancelalarm);
		buttonStart.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//创建一个Intent对象
				Intent myIntent=new Intent(MainActivity.this,AlarmService.class);
				//显示闹钟的PendingIntent对象
				pendingIntent=PendingIntent.getService(MainActivity.this, 0, myIntent, 0);
				//获取AlarmManager对象
				AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
				Calendar calendar=Calendar.getInstance();
				//设置闹钟的的分钟数
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.add(Calendar.SECOND, 10);
				alarmManager.set(AlarmManager.RTC_WAKEUP, 
						calendar.getTimeInMillis(), pendingIntent);
				//设置一个闹钟，并显示一个消息提示
				Toast.makeText(MainActivity.this, "开始警告", Toast.LENGTH_LONG).show();
			}
		});
		buttonCancel.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.cancel(pendingIntent);
				Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_LONG).show();
			}
		});
	}

	

}
