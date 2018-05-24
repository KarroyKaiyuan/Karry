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
	//��ʼ���˵�
	public boolean onCreateOptionsMenu(Menu menu){
		//���ز˵�
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//���ݲ˵�ִ�е���Ӧ����
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.connect:
			Toast.makeText(getApplicationContext(), 
					"��������...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.disconnect:
			Toast.makeText(getApplicationContext(), 
					"�����Ͽ�...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.search:
			Toast.makeText(getApplicationContext(), 
					"Ѱ������...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.view:
			Toast.makeText(getApplicationContext(), 
					"�鿴...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.help:
			Toast.makeText(getApplicationContext(), 
					"����...", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.exit:
			Toast.makeText(getApplicationContext(), 
					"�˳�...", Toast.LENGTH_SHORT).show();
			return true;
			
			

		}
		return false;
		
	}
	

}
