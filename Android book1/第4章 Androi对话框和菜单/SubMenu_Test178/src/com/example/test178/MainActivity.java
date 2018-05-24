package com.example.test178;

import android.os.Bundle;
import android.R.bool;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	//��ʼ���˵�
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0,1,Menu.NONE,"��������").setIcon(android.R.drawable.ic_menu_send);
		//����Ӳ˵�
		SubMenu subMenu=menu.addSubMenu(0,2,Menu.NONE,"��Ҫ�̶�>>")
				.setIcon(android.R.drawable.ic_menu_share);
		//����Ӳ˵�
		subMenu.add(2,201,1,"*****");
		subMenu.add(2,201,1,"***");
		subMenu.add(2,201,1,"*");
		menu.add(0,3,Menu.NONE,"������").setIcon(android.R.drawable.ic_menu_edit);
		menu.add(0,3,Menu.NONE,"ɾ��").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return true;
	}
	//���ݲ˵�ִ����Ӧ������
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case 1:
			Toast.makeText(getApplicationContext(),
					"��������....", Toast.LENGTH_SHORT).show();
			return true;
		case 201:
			Toast.makeText(getApplicationContext(),
					"�ǳ���Ҫ��*****", Toast.LENGTH_SHORT).show();
			return true;
		case 202:
			Toast.makeText(getApplicationContext(),
					"��Ҫ��***", Toast.LENGTH_SHORT).show();
			return true;
		case 203:
			Toast.makeText(getApplicationContext(),
					"��ͨ��*", Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			Toast.makeText(getApplicationContext(),
					"������....", Toast.LENGTH_SHORT).show();
			return true;
		case 4:
			Toast.makeText(getApplicationContext(),
					"ɾ��....", Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
		
	}
	

}
