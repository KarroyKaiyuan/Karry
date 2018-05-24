package com.example.alpha_test;

import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ImageView imageView;
	TextView textView;
	int image_alpha=255;
	Handler mHandler;//Handler对象用来给UI_Thread的messageQueue发送消息
	boolean isrung=false;//判断线程是否运行的变量
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        isrung=true;
        imageView=(ImageView)findViewById(R.id.imageView1);
        textView=(TextView)findViewById(R.id.textView1);
        imageView.setImageResource(R.drawable.a1);
        imageView.setAlpha(image_alpha);
        //开启一个线程让Alpha值自减
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(isrung){
					try{Thread.sleep(200);
					updateAlpha();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}).start();
        
        //接收消息后更新imageview视图
        mHandler=new Handler(){
        	public void handleMessage(Message msg) {
        		super.handleMessage(msg);
        		imageView.setAlpha(image_alpha);
        		textView.setText("现在的alpha值为："+Integer.toString(image_alpha));
        		imageView.invalidate();
			}
        };
    }
    //更新alpha
	protected void updateAlpha() {
		// TODO Auto-generated method stub
		if(image_alpha-7>=0){
			image_alpha-=7;
		}else{
			image_alpha=0;
			isrung=false;
		}
		
		mHandler.sendMessage(mHandler.obtainMessage());
	}
    
}
