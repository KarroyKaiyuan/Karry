package com.example.test109;

import java.util.ArrayList;

import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView listView1;
	private ArrayList cityList=new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView1=(ListView)this.findViewById(R.id.listView1);
		cityList.add("±±¾©");
		cityList.add("shanghai");
		cityList.add("tianjin");
		cityList.add("nanjin");
		ArrayAdapter  arrayAdapterRef=new ArrayAdapter(this,
				android.R.layout.simple_list_item_1,cityList);
		listView1.setAdapter(arrayAdapterRef);
		listView1.setOnItemClickListener(new OnItemClickListener() {
		
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("listView1.setOnItemClickListener",""+cityList.get(arg2));
			}
			
		});
	}

	

}
