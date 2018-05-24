package com.example.test111;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private List cityList=new ArrayList();
	private ListView listView;
	private Button button1;
	private Button button2;
	private Button button3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView=(ListView)this.findViewById(R.id.listView1);
		button1=(Button)this.findViewById(R.id.button1);
		button2=(Button)this.findViewById(R.id.button2);
		button3=(Button)this.findViewById(R.id.button3);
		final boolean[] isCheckedArray=new boolean[8];
		isCheckedArray[0]=false;
		isCheckedArray[1]=false;
		isCheckedArray[2]=false;
		isCheckedArray[3]=false;
		isCheckedArray[4]=false;
		isCheckedArray[5]=false;
		isCheckedArray[6]=true;
		isCheckedArray[7]=false;//����Ĭ��ֵ�Ƿ�ѡ��
		cityList.add("ƻ��");cityList.add("�㽶");cityList.add("ѩ��");cityList.add("â��");
		cityList.add("����");cityList.add("����");cityList.add("����");cityList.add("����");
		ArrayAdapter adapter=new ArrayAdapter(this, 
				android.R.layout.simple_list_item_multiple_choice,cityList);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("----------", ""+((TextView)arg1).getText());
			}
		});
		//����ʼֵ
		for(int i=0;i<isCheckedArray.length;i++){
			listView.setItemChecked(i, isCheckedArray[i]);
		}
		//ȫѡ
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.v("������ȫѡ", "����ȫѡ");
				for(int i=0;i<isCheckedArray.length;i++){
					listView.setItemChecked(i, true);
				}
			}
		});
		//��ѡ
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.v("�����˷�ѡ", "������ѡ");
				SparseBooleanArray spareBooleanArrayRef=listView.getCheckedItemPositions();
				for(int i=0;i<spareBooleanArrayRef.size();i++){
					if(spareBooleanArrayRef.get(i)==true){
						listView.setItemChecked(i, false);
					}else{
						listView.setItemChecked(i, false);					}
				}
			}
		});
		//ȡֵ
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.v("������ȡֵ", "����ȡֵ");
				SparseBooleanArray spareBooleanArrayRef=listView.getCheckedItemPositions();
				for(int i=0;i<spareBooleanArrayRef.size();i++){
					if(spareBooleanArrayRef.get(i)==true){
						listView.setItemChecked(i, false);
						Log.v("ֵΪ��", ""+listView.getAdapter().getItemId(i)
								     +""+listView.getAdapter().getItemId(i));
					}
				}
			}			
		});
	
	}

}	
	


