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
	private String[] item={"��","��","��","Դ"};
	private GridView gridView;
	private SimpleAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//ͨ��ID���ҵ�main.xml�е�TextView�ؼ�
		text=(TextView)findViewById(R.id.text);
		//ͨ��Id���ҵ�main.xml�е�GridView
		gridView=(GridView)findViewById(R.id.gridView);
		//����һ��ArrayList�б� �ڲ��洢����HashMap�б�
		ArrayList<HashMap<String, Object>>listItems=
				new ArrayList<HashMap<String,Object>>();
		//��������Ϣ�ֱ�洢��ArrayList
		int len=item.length;
		for(int i=0;i<len;i++){
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("image", image[i]);
			map.put("item", item[i]);
			listItems.add(map);
		}
		//HashMap�е�key��Ϣ��Ҫ��Grid_item.xml�е���Ϣ����Ӧ
		String[] from={"image","item"};
		//grid_item.xml�ж�Ӧ��imageView�ؼ���TextView�ؼ�
		int[] to={R.id.item_imageView1,R.id.item_textView1};
		//����һ��������
		adapter=new SimpleAdapter(this, listItems, R.layout.item, from, to);
		//��gridview��������
		gridView.setAdapter(adapter);
		//����gridview�ļ�����
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
					String str="��"+item[position]+"Դ";
					updateText(str);
				}
			});
		}
		
		private void updateText(String string) {
			// TODO Auto-generated method stub
			//���ı���Ϣ���ø�Textview�ؼ���ʾ����
			text.setText(string);
	}

	

}
