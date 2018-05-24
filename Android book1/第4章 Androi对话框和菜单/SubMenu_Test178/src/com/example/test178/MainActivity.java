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
	//初始化菜单
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0,1,Menu.NONE,"蓝牙发送").setIcon(android.R.drawable.ic_menu_send);
		//添加子菜单
		SubMenu subMenu=menu.addSubMenu(0,2,Menu.NONE,"重要程度>>")
				.setIcon(android.R.drawable.ic_menu_share);
		//添加子菜单
		subMenu.add(2,201,1,"*****");
		subMenu.add(2,201,1,"***");
		subMenu.add(2,201,1,"*");
		menu.add(0,3,Menu.NONE,"重命名").setIcon(android.R.drawable.ic_menu_edit);
		menu.add(0,3,Menu.NONE,"删除").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return true;
	}
	//根据菜单执行相应的内容
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case 1:
			Toast.makeText(getApplicationContext(),
					"蓝牙发送....", Toast.LENGTH_SHORT).show();
			return true;
		case 201:
			Toast.makeText(getApplicationContext(),
					"非常重要：*****", Toast.LENGTH_SHORT).show();
			return true;
		case 202:
			Toast.makeText(getApplicationContext(),
					"重要：***", Toast.LENGTH_SHORT).show();
			return true;
		case 203:
			Toast.makeText(getApplicationContext(),
					"普通：*", Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			Toast.makeText(getApplicationContext(),
					"重命名....", Toast.LENGTH_SHORT).show();
			return true;
		case 4:
			Toast.makeText(getApplicationContext(),
					"删除....", Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
		
	}
	

}
