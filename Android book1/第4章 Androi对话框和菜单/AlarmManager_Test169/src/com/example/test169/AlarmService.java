package com.example.test169;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class AlarmService extends Service {
	private Intent intent;
	private int startId;

	public void onCreate(){
		Toast.makeText(this, "创建闹钟警告", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "绑定闹钟警告", Toast.LENGTH_LONG).show();
		return null;
	}
	public void onDestroy(){
		super.onDestroy();
		Toast.makeText(this, "删除闹钟警告", Toast.LENGTH_LONG).show();
	}
	public void onStart(){
		super.onStart(intent, startId);
		Toast.makeText(this, "开始闹钟警告", Toast.LENGTH_LONG).show();
	}
	
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "不绑定闹钟警告", Toast.LENGTH_LONG).show();
		return super.onUnbind(intent);
	}

}
