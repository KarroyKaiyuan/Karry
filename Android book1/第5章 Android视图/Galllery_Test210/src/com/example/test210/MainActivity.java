package com.example.test210;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private int[] imageId=new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,
			R.drawable.a4,R.drawable.a5};
	private ImageSwitcher imageSwitcher;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Gallery gallery=(Gallery)findViewById(R.id.gallery1);//获取组件
		imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher1);
		//设置动画效果
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				this, android.R.anim.fade_in));
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				this, android.R.anim.fade_out));//设置淡出动画
		imageSwitcher.setFactory(new ViewFactory(){

			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				//实例化一个imageView类的对象
				ImageView imageView=new ImageView(MainActivity.this);
				//设置保持纵横比居中缩放图像
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageView;
			}});
		//使用baseAdapter指定要显示的内容分
		BaseAdapter adapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ImageView imageView;//声明一个对象
				if(convertView==null){
					imageView=new ImageView(MainActivity.this);//实例化对象
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);//设置缩放方式
					imageView.setPadding(5, 0, 5, 0);//shezhi内边距
				}else
				{imageView=(ImageView)convertView;}
				imageView.setImageResource(imageId[position]);//为imageview设置要显示的图片
				return imageView;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageId.length;
			}
		};
		gallery.setAdapter(adapter);//将适配器与gallery相关联
		gallery.setSelection(imageId.length/2);//让中间的图片选中
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				imageSwitcher.setImageResource(imageId[position]);//显示选中的图片
				
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		
		
	}

	

}
