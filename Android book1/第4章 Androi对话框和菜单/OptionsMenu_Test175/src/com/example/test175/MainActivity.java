package com.example.test175;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	//初始化菜单
	public boolean onCreateOptionsMenu(Menu menu){
		//加载菜单
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//根据菜单执行的相应内容
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.connect:
			Toast.makeText(getApplicationContext(), 
					"蓝牙连接...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.disconnect:
			Toast.makeText(getApplicationContext(), 
					"蓝牙断开...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.search:
			Toast.makeText(getApplicationContext(), 
					"寻找蓝牙...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.view:
			Toast.makeText(getApplicationContext(), 
					"查看...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.help:
			Toast.makeText(getApplicationContext(), 
					"帮助...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.exit:
			Toast.makeText(getApplicationContext(), 
					"退出...", Toast.LENGTH_SHORT).show();
			return true;
			
			

		}
		return false;
		
	}
	

}
