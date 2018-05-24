package com.example.test114;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private List cityList=new ArrayList();
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView=(ListView)this.findViewById(R.id.listView1);
		final boolean[] isCheckedArray=new boolean[8];
		isCheckedArray[0]=false;
		isCheckedArray[1]=false;
		isCheckedArray[2]=false;
		isCheckedArray[3]=false;
		isCheckedArray[4]=false;
		isCheckedArray[5]=false;
		isCheckedArray[6]=true;
		isCheckedArray[7]=false;//设置默认值是否选上
		cityList.add("苹果");cityList.add("香蕉");cityList.add("雪梨");cityList.add("芒果");
		cityList.add("桃子");cityList.add("葡萄");cityList.add("甘蔗");cityList.add("西瓜");
		ArrayAdapter adapter=new ArrayAdapter(this, 
				android.R.layout.simple_list_item_multiple_choice,cityList);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("----------", ""+((TextView)arg1).getText());
			}
		});
		//赋初始值
		for(int i=0;i<isCheckedArray.length;i++){
			listView.setItemChecked(i, isCheckedArray[i]);
		}
	}

	

}
