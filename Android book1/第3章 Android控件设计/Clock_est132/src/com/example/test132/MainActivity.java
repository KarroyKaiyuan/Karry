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

	//����һ��������Ϊ�б���Ϣ��
	protected static final int GUINOTIFIER=0x1234;
	//��������widget�������
	private TextView mTextView;
	public AnalogClock mAnalogClock;
	//������ʱ����صı���
	public Calendar mCalendar;
	public int mMinutes;
	public int mHour;
	//�����ؼ�Handler��Thread����
	public Handler mHandler;
	public Thread mTHThread;
	private Thread mClockThread; 
	
	//��һ�ε��û    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTextView=(TextView)this.findViewById(R.id.textView1);
		mAnalogClock=(AnalogClock)findViewById(R.id.analogClock1);
		//ʹ��Handler�����������߳������ݵ���Ϣ������Textview
		mHandler=new Handler(){
			public void handleMessage(Message msg){
				//������Ϣ�ķ���
				switch (msg.what) {
				case MainActivity.GUINOTIFIER:
					//���ﴦ��ҪTextview����showʱ����¼�
					mTextView.setText(mHour+":"+mMinutes);
					break;
				}
				super.handleMessage(msg);
			}
		};
		//ͨ�������߳�������ȡ��ϵͳʱ��
		mClockThread=new LooperThread();
		mClockThread.start();
	}
	//��дһ��Threadclass�����������ϵͳʱ��
	class LooperThread extends Thread{
		public void run(){
			super.run();
			try{
				do{
					//���ϵͳʱ��
					long time=System.currentTimeMillis();
					final Calendar mCalendar=Calendar.getInstance();
					mCalendar.setTimeInMillis(time);
					mHour=mCalendar.get(Calendar.HOUR);
					mMinutes=mCalendar.get(Calendar.MINUTE);
					//�������߳���Ϣ1��
					Thread.sleep(1000);
					//��Ҫ�ؼ����򣺻�ȡʱ��󷢳���Ϣ��Handler
					Message m=new Message();
					m.what=MainActivity.GUINOTIFIER;
					MainActivity.this.mHandler.sendMessage(m);	
				}
				while(MainActivity.LooperThread.interrupted()==false);
				//��ϵͳ�����ж���Ϣʱֹͣ��ѭ��
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	
}
