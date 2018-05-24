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
		//��ʾ�б�
		simpleShowList();
		//Ϊ�����б���ע�������Ĳ˵�
		this.registerForContextMenu(getListView());
	}

	private void simpleShowList() {
		// TODO Auto-generated method stub
		//ģ���ļ��б�����Ŀ�п���ʵ�ʶ�ȡ�ļ��б�
		String[] files=new String[]{
				"��վ����֪ͨ.doc","��ҵԤ�㱨��.xml","�ͻ�˵����.ppt","��ҵ��������Ƭ.avi"
		};
		//����������simple array adapter
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,files);
		//����б�
		this.setListAdapter(adapter);
		
	}
	//����ContextMenu������menu��һ����ʾʱ����
	public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
		 menu.setHeaderTitle("�ļ�����");
		 //���contextmenu�˵���
		 menu.add(0,1,Menu.NONE,"��������");
		 menu.add(0,2,Menu.NONE,"���Ϊ��Ҫ");
		 menu.add(0,3,Menu.NONE,"������");
		 menu.add(0,4,Menu.NONE,"ɾ��");
		
	}
	public boolean onCreateItemSelected(MenuItem item){
		//�õ���ǰѡ�е�item��Ϣ
		switch(item.getItemId()){
		case 1:
			Toast.makeText(getApplicationContext(),
					"�����ļ�",Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(),
					"���Ϊ��Ҫ*",Toast.LENGTH_SHORT).show();
			break;
		case 3:
			Toast.makeText(getApplicationContext(),
					"������",Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(getApplicationContext(),
					"ɾ��",Toast.LENGTH_SHORT).show();
			break;
			default:
				return super.onContextItemSelected(item);
		}
		return true;
		
	}
	

}
