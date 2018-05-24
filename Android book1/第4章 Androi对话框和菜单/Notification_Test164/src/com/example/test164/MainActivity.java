package com.example.test164;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final int NOTIFYID_1=123;
	final int NOTIFYID_2=124;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//获取通知管理器，用于发送通知
		final NotificationManager notificationManager=(NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		Button button1=(Button)findViewById(R.id.button1);
		//为显示通知按钮添加单击事件监听器
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Notification notify=new Notification();//创建对象
				
				notify.icon=R.drawable.ic_launcher;
				notify.tickerText="显示第一个通知";
				notify.when=System.currentTimeMillis();//设置发送时间
				//设置默认声音 默认震动 默认闪光灯
				notify.defaults=Notification.DEFAULT_ALL;
				//设置事件信息
				notify.setLatestEventInfo(MainActivity.this,
						"无题", "每天进步一点点", null);
				//通过通知管理器发送通知
				notificationManager.notify(NOTIFYID_1,notify);
				//添加第二个通知
				Notification notify1=new Notification(R.drawable.a3,
						"显示第三个通知",System.currentTimeMillis());
				notify1.flags|=Notification.FLAG_AUTO_CANCEL;
				//打开应用程序后图标消失
				Intent intent=new Intent(MainActivity.this,ContentActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(
						MainActivity.this, 0, intent, 0);
				//设置时间信息
				notify1.setLatestEventInfo(MainActivity.this,
						"通知", "查看详细内容", pendingIntent);
				//通过通知管理器发送通知
				notificationManager.notify(NOTIFYID_2,notify);
			}
		});
		Button button2=(Button)findViewById(R.id.button2);
		//获取删除通知按钮 为该按钮添加单击事件监听器
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				notificationManager.cancelAll();
			}
		});
	}

	

}
