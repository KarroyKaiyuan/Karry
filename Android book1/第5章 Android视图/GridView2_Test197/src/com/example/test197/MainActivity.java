package com.example.test197;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;//
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String texts[]=null;
	private int images[]=null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		images=new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
		texts=new String[]{"凯源1","凯源2","凯源3","凯源4"};
		GridView gridview=(GridView)findViewById(R.id.gridview);
		ArrayList<HashMap<String, Object>>IstImageItem=new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<4;i++){
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("itemImage", images);
			map.put("itemText", texts);
			IstImageItem.add(map);
		}
		SimpleAdapter saImageItems=new SimpleAdapter(this,
				IstImageItem,
				R.layout.items,
				new String[]{"itemImage","itemText"},
				new int[] {R.id.itemImage,R.id.itemText});
		gridview.setAdapter(saImageItems);
		gridview.setOnItemClickListener(new ItemClickListener());
	}
    class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long rowid) {
			// TODO Auto-generated method stub
			HashMap<String, Object>item=(HashMap<String, Object>)
					parent.getItemAtPosition(position);
			//获取数据源的属性值
			String itemText=(String)item.get("itemText");
			Object object=item.get("itemImage");
			Toast.makeText(MainActivity.this, itemText, Toast.LENGTH_LONG).show();
			//根据图片进行相应的跳转
			switch (images[position]) {
			case R.drawable.a1:
				//启动另一个Activity
				startActivity(new Intent(MainActivity.this,TestActivity1.class));
				finish();//结束此activity，可回收
				break;
			case R.drawable.a2:
				//启动另一个Activity
				startActivity(new Intent(MainActivity.this,TestActivity2.class));
				finish();//结束此activity，可回收
				break;
			case R.drawable.a3:
				//启动另一个Activity
				startActivity(new Intent(MainActivity.this,TestActivity3.class));
				finish();//结束此activity，可回收
				break;
			}
		}
    	
    }
	

}
