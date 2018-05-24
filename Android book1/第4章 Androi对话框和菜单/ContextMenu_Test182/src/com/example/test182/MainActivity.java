package com.example.test182;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//显示列表
		simpleShowList();
		//为所有列表项注册上下文菜单
		this.registerForContextMenu(getListView());
	}

	private void simpleShowList() {
		// TODO Auto-generated method stub
		//模拟文件列表，在项目中可以实际读取文件列表
		String[] files=new String[]{
				"网站备案通知.doc","企业预算报表.xml","客户说明会.ppt","企业形象宣传片.avi"
		};
		//数据适配器simple array adapter
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,files);
		//填充列表
		this.setListAdapter(adapter);
		
	}
	//创建ContextMenu，会在menu第一次显示时调用
	public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
		 menu.setHeaderTitle("文件操作");
		 //添加contextmenu菜单项
		 menu.add(0,1,Menu.NONE,"蓝牙发送");
		 menu.add(0,2,Menu.NONE,"标记为重要");
		 menu.add(0,3,Menu.NONE,"重命名");
		 menu.add(0,4,Menu.NONE,"删除");
		
	}
	public boolean onCreateItemSelected(MenuItem item){
		//得到当前选中的item信息
		switch(item.getItemId()){
		case 1:
			Toast.makeText(getApplicationContext(),
					"发送文件",Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(),
					"标记为重要*",Toast.LENGTH_SHORT).show();
			break;
		case 3:
			Toast.makeText(getApplicationContext(),
					"重命名",Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(getApplicationContext(),
					"删除",Toast.LENGTH_SHORT).show();
			break;
			default:
				return super.onContextItemSelected(item);
		}
		return true;
		
	}
	

}
