package com.example.test155;

import android.os.Bundle;
import android.app.AlertDialog.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn=(Button)findViewById(R.id.bn);
		final Builder builder=new AlertDialog.Builder(this);
		//为按钮绑定监听事件
		bn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("自定义的普通对话框");
				//装载res/layout/denglu.xmls界面布局****
				TableLayout loginForm=(TableLayout)getLayoutInflater()
						.inflate(R.layout.denglu, null);
				builder.setView(loginForm);
				//为对话框设置一个确定按钮
				builder.setPositiveButton("登录", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//此处可执行登录处理
					}
				});
				//为对话框设置一个取消按钮
				builder.setNegativeButton("取消", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//取消登录，不做任何事
					}
				});
				//创建 显示对话框
				builder.create().show();
			}
		});
	}

	

}
