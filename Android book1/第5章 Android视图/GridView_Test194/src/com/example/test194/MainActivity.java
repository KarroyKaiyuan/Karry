package com.example.test194;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView text=null;
	private int[] image={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
		};
	private String[] item={"我","爱","凯","源"};
	private GridView gridView;
	private SimpleAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//通过ID查找到main.xml中的TextView控件
		text=(TextView)findViewById(R.id.text);
		//通过Id查找到main.xml中的GridView
		gridView=(GridView)findViewById(R.id.gridView);
		//创建一个ArrayList列表 内部存储的是HashMap列表
		ArrayList<HashMap<String, Object>>listItems=
				new ArrayList<HashMap<String,Object>>();
		//将数组信息分别存储到ArrayList
		int len=item.length;
		for(int i=0;i<len;i++){
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("image", image[i]);
			map.put("item", item[i]);
			listItems.add(map);
		}
		//HashMap中的key信息，要与Grid_item.xml中的信息做对应
		String[] from={"image","item"};
		//grid_item.xml中对应的imageView控件和TextView控件
		int[] to={R.id.item_imageView1,R.id.item_textView1};
		//设置一个适配器
		adapter=new SimpleAdapter(this, listItems, R.layout.item, from, to);
		//对gridview进行适配
		gridView.setAdapter(adapter);
		//设置gridview的监听器
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
					String str="凯"+item[position]+"源";
					updateText(str);
				}
			});
		}
		
		private void updateText(String string) {
			// TODO Auto-generated method stub
			//将文本信息设置给Textview控件显示出来
			text.setText(string);
	}

	

}
