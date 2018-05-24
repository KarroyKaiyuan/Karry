package com.example.test67;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends Activity {
    TabHost mTabHost;
	private Object textview1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTabHost=getTabHost();
		mTabHost.addTab(mTabHost.newTabSpec("tab_test1")
				.setIndicator("TAB1",getResources().getDrawable(R.drawable.b))
				.setContent(R.id.textview1));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2")
				.setIndicator("TAB2",getResources().getDrawable(R.drawable.b1))
				.setContent(R.id.textview2));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test3")
				.setIndicator("TAB3",getResources().getDrawable(R.drawable.b2))
				.setContent(R.id.textview3));
		mTabHost.setBackgroundColor(Color.argb(150,22,70,150));
		mTabHost.setBackgroundResource(R.drawable.bj1);
		mTabHost.setCurrentTab(0);
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				Dialog dialog=new AlertDialog.Builder(MainActivity.this)
				.setTitle("提示")
				.setMessage("当前选中："+tabId+"标签")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int whichButton) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				}).create();
				dialog.show();
			}
		});
		
	}

	
	private TabHost getTabHost() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
