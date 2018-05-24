package com.example.test219;

import java.util.ArrayList;

import android.os.Bundle;
import android.R.bool;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	private ViewPager mViewPager;
	private PagerTitleStrip mPagerTitleStrip;
	private int[] pics={R.drawable.a7,R.drawable.a8,R.drawable.a9};
	final ArrayList<View>views=new ArrayList<View>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mViewPager=(ViewPager)findViewById(R.id.viewpager);
		mPagerTitleStrip=(PagerTitleStrip)findViewById(R.id.pagertitle);
		LinearLayout.LayoutParams mpParams=new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		//将要分页显示的view装入到数组中
		for(int i=0;i<pics.length;i++){
			ImageView iv=new ImageView(this);
			iv.setLayoutParams(mpParams);
			iv.setImageResource(pics[i]);
			views.add(iv);
		}
		//每个页面的title数据
		final ArrayList<String> titles=new ArrayList<String>();
		titles.add("tab1");titles.add("tab2");titles.add("tab3");
		//填充viewpager的数据适配器
		PagerAdapter mPagerAdapter=new PagerAdapter() {
			
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}
			public void destroyItem(View container,int position,Object object){
				((ViewPager)container).removeView(views.get(position));
			}
			public CharSequence getPageTitle(int position){
				return titles.get(position);
			}
			public Object instantiateItem(View container,int position){
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
	}
	public boolean onCreatOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
