package com.example.test124;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private LinearLayout mLayout;
	private ScrollView sView;
	private final Handler mHandler=new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//创建一个线性布局
		mLayout=(LinearLayout)this.findViewById(R.id.linearLayout);
		//创建一个scrollview对象
		sView=(ScrollView)this.findViewById(R.id.scrollView);
		Button mBtn=(Button)this.findViewById(R.id.button);
		mBtn.setOnClickListener(mClickListener);//添加单击事件监听
	}
	public boolean onKeyDown(int keyCode,KeyEvent event){
		Button b=(Button)this.getCurrentFocus();
		int count=mLayout.getChildCount();
		Button bm=(Button)mLayout.getChildAt(count-1);
		if(keyCode==KeyEvent.KEYCODE_DPAD_UP&&b.getId()==R.id.button){
			bm.requestFocus();
			return true;
		}
		else if(keyCode==KeyEvent.KEYCODE_DPAD_DOWN&&b.getId()==bm.getId()){
			this.findViewById(R.id.button).requestFocus();
			return true;
		}
		return false;
	}
	//button事件监听，当点击第一个按钮时增加一个button和一个textview
	private Button.OnClickListener mClickListener=new Button.OnClickListener(){
		private int index=1;
		public void onClick(View v){
			TextView tView=new TextView(MainActivity.this);
			tView.setText("文本框"+index);
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			mLayout.addView(tView,params);
			Button button=new Button(MainActivity.this);
			button.setText("anniu"+index);
			button.setId(index++);
			mLayout.addView(button,params);   
			mHandler.post(mScrollToButton);
		}
	};
	private  Runnable mScrollToButton=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int off=mLayout.getMeasuredHeight()-sView.getHeight();
			if(off>0){
				sView.scrollTo(0, off);			}
		}
	};

	
}

