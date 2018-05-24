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
		//��ȡ֪ͨ�����������ڷ���֪ͨ
		final NotificationManager notificationManager=(NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		Button button1=(Button)findViewById(R.id.button1);
		//Ϊ��ʾ֪ͨ��ť��ӵ����¼�������
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Notification notify=new Notification();//��������
				
				notify.icon=R.drawable.ic_launcher;
				notify.tickerText="��ʾ��һ��֪ͨ";
				notify.when=System.currentTimeMillis();//���÷���ʱ��
				//����Ĭ������ Ĭ���� Ĭ�������
				notify.defaults=Notification.DEFAULT_ALL;
				//�����¼���Ϣ
				notify.setLatestEventInfo(MainActivity.this,
						"����", "ÿ�����һ���", null);
				//ͨ��֪ͨ����������֪ͨ
				notificationManager.notify(NOTIFYID_1,notify);
				//��ӵڶ���֪ͨ
				Notification notify1=new Notification(R.drawable.a3,
						"��ʾ������֪ͨ",System.currentTimeMillis());
				notify1.flags|=Notification.FLAG_AUTO_CANCEL;
				//��Ӧ�ó����ͼ����ʧ
				Intent intent=new Intent(MainActivity.this,ContentActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(
						MainActivity.this, 0, intent, 0);
				//����ʱ����Ϣ
				notify1.setLatestEventInfo(MainActivity.this,
						"֪ͨ", "�鿴��ϸ����", pendingIntent);
				//ͨ��֪ͨ����������֪ͨ
				notificationManager.notify(NOTIFYID_2,notify);
			}
		});
		Button button2=(Button)findViewById(R.id.button2);
		//��ȡɾ��֪ͨ��ť Ϊ�ð�ť��ӵ����¼�������
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				notificationManager.cancelAll();
			}
		});
	}

	

}
