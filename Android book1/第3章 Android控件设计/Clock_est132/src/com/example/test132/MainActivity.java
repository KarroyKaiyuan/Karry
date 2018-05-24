package com.example.test132;

import java.util.Calendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.widget.AnalogClock;
import android.widget.TextView;
import java.util.Calendar;
import java.lang.Thread;

public class MainActivity extends Activity {

	//申明一个常数作为判别信息用
	protected static final int GUINOTIFIER=0x1234;
	//申明两个widget对象变量
	private TextView mTextView;
	public AnalogClock mAnalogClock;
	//申明与时间相关的变量
	public Calendar mCalendar;
	public int mMinutes;
	public int mHour;
	//申明关键Handler和Thread变量
	public Handler mHandler;
	public Thread mTHThread;
	private Thread mClockThread; 
	
	//第一次调用活动    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTextView=(TextView)this.findViewById(R.id.textView1);
		mAnalogClock=(AnalogClock)findViewById(R.id.analogClock1);
		//痛过Handler来接受运行线程所传递的信息并更新Textview
		mHandler=new Handler(){
			public void handleMessage(Message msg){
				//处理信息的方法
				switch (msg.what) {
				case MainActivity.GUINOTIFIER:
					//这里处理要Textview对象show时间的事件
					mTextView.setText(mHour+":"+mMinutes);
					break;
				}
				super.handleMessage(msg);
			}
		};
		//通过运行线程来持续取得系统时间
		mClockThread=new LooperThread();
		mClockThread.start();
	}
	//改写一个Threadclass用来持续或得系统时间
	class LooperThread extends Thread{
		public void run(){
			super.run();
			try{
				do{
					//或得系统时间
					long time=System.currentTimeMillis();
					final Calendar mCalendar=Calendar.getInstance();
					mCalendar.setTimeInMillis(time);
					mHour=mCalendar.get(Calendar.HOUR);
					mMinutes=mCalendar.get(Calendar.MINUTE);
					//让运行线程休息1秒
					Thread.sleep(1000);
					//重要关键程序：获取时间后发出信息给Handler
					Message m=new Message();
					m.what=MainActivity.GUINOTIFIER;
					MainActivity.this.mHandler.sendMessage(m);	
				}
				while(MainActivity.LooperThread.interrupted()==false);
				//当系统发出中断信息时停止本循环
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	
}
