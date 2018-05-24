package com.example.viewfactory_test268;

import java.util.ArrayList;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	//定义一常量，用于显示每屏现实的应用程序数
	public static final int NUMBER_PER_SCREEN=12;
	//代表应用程序的内部类
	public static class DataItem{
		//应用程序名称‘和图标
		public String dataName;
		public Drawable drawable;
	}
	//保存系统所有应用程序的list'集合
	private ArrayList<DataItem> items=new ArrayList<DataItem>();
	//记录当前正在显示第几屏的程序
	private int screenNo=-1;
	private int screenCount;
	ViewSwitcher switcher;
	//创建layoutInflater对象
	LayoutInflater inflater;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        inflater=LayoutInflater.from(MainActivity.this);
        //创建一个包含40个元素的list集合，用于模拟包含40个的应用程序·
        for(int i=0;i<40;i++){
        	String label=""+i;
        	Drawable drawable=getResources().getDrawable(R.drawable.ic_launcher);
        	DataItem item=new DataItem();
        	item.dataName=label;
        	item.drawable=drawable;
        	items.add(item);
        }
        //计算应用程序所占用的总屏数，若应用程序的数量可以整除NUMBER_PER_SCREEN，其结果就是总屏幕数
        //若不能整除，则总屏数是结果加1
        screenCount=items.size()%NUMBER_PER_SCREEN==0?
        		items.size()/NUMBER_PER_SCREEN:
        	items.size()/NUMBER_PER_SCREEN+1;
        switcher=(ViewSwitcher)findViewById(R.id.viewSwitcher1);
        switcher.setFactory(new ViewFactory() {
			//实际上就是返回一个GridView组件
			@Override
			public View makeView() {
				// 加载R.layout.alidelistview组件，实际上就是一个GridView组件
				return inflater.inflate(R.layout.slidelistview, null);
			}
		});
        //页面加载时先显示第一屏
        next(null);
        
		}
    
    
    
	public  void next(View v) {
		// TODO Auto-generated method stub
		if(screenNo<screenCount-1){
			screenNo++;
			//为ViewSwitcher的组件显示过程设置动画
			switcher.setInAnimation(this,R.anim.slide_in_right);
			//为ViewSwitcher的组件隐藏过程设置动画
			switcher.setOutAnimation(this,R.anim.slide_out_left);
			//控制下一屏将要显示的Gridview对应的adapter
			((GridView)switcher.getNextView()).setAdapter(adapter);
			//点击右边按钮，显示下一屏，也可通过收拾检测显示下一屏
			switcher.showNext();
		}
	}
	
	public void prev(View v){
		// TODO Auto-generated method stub
		if(screenNo>0){
			screenNo--;
			//为ViewSwitcher的组件显示过程设置动画
			switcher.setInAnimation(this,android.R.anim.slide_in_left);
			//为ViewSwitcher的组件隐藏过程设置动画
			switcher.setOutAnimation(this,android.R.anim.slide_out_right);
			//控制下一屏将要显示的Gridview对应的adapter
			((GridView)switcher.getNextView()).setAdapter(adapter);
			//点击右边按钮，显示下一屏，也可通过收拾检测显示下一屏
			switcher.showPrevious();
		}
	}
	
	
	
	//该BaseAdapter负责为每屏显示的GridView提供列表项
	private BaseAdapter adapter=new BaseAdapter() {
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			//如果已经到了最后一屏并且应用程序的数量不能整除NUMBER_PER_SCREEN
			if(screenNo==screenCount-1&&items.size()%NUMBER_PER_SCREEN!=0)
			{
				//最后一屏显示的程序数量为对NUMBER_PER_SCREEN求余
				return items.size()%NUMBER_PER_SCREEN;
			}
			//否则每屏显示的数量为NUMBER_PER_SCREEN
			return NUMBER_PER_SCREEN;
		}
		@Override
		public DataItem getItem(int position) {
			// TODO Auto-generated method stub
			//根据screenNo计算第position个列表项的数据
			return items.get(screenNo*NUMBER_PER_SCREEN+position);
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view=convertView;
			if(convertView==null){
				//加载R.layout.laelicon布局文件
				view=inflater.inflate(R.layout.labelicon, null);
			}
			//获取布局文件中的imageview组件，并为之设置图标
			ImageView imageView=(ImageView)view.findViewById(R.id.imageview);
			imageView.setImageDrawable(getItem(position).drawable);
			//获取布局文件中的textview组件，并为之设置文本
			TextView textView=(TextView)view.findViewById(R.id.textview);
			textView.setText(getItem(position).dataName);
			return view;
		}
	};
	
	
    }
    
    

