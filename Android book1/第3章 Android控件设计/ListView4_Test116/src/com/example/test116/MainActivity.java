package com.example.test116;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private Button button1;
	private Button button2;
	private ListView listView1;
	final private List dataList=new ArrayList();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView1=(ListView)this.findViewById(R.id.listView1);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		dataList.add("我是苹果，序号为：1");
		dataList.add("我是苹果，序号为：2");
		dataList.add("我是苹果，序号为：3");
		dataList.add("我是苹果，序号为：4");
		dataList.add("我是苹果，序号为：5");
		dataList.add("我是苹果，序号为：6");
		dataList.add("我是苹果，序号为：7");
		dataList.add("我是苹果，序号为：8");
		dataList.add("我是苹果，序号为：9");
		dataList.add("我是苹果，序号为：10");
		final ArrayAdapter adapter=new ArrayAdapter(
				this, android.R.layout.simple_list_item_1,dataList);
		listView1.setAdapter(adapter);
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				dataList.add(0,"");
				adapter.notifyDataSetChanged();
				Log.v("!", "dataList size()="+dataList.size());
			}
		});
		button2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dataList.remove(0);
				adapter.notifyDataSetChanged();
				Log.v("!", "dataList size()="+dataList.size());
			}
		});
		
		}

	

}
