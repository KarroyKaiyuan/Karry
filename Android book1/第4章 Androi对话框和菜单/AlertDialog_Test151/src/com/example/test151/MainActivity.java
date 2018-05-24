package com.example.test151;

import android.os.Bundle;
import android.preference.DialogPreference;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private boolean[] checkedItems;
	private String[] items;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//列表项状态
		setContentView(R.layout.main);//列表项内容
		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setIcon(R.drawable.ic_launcher);
				alert.setTitle("系统提示：");
				alert.setMessage("带有取消、中立和确定按钮的对话框");
				//添加取消按钮
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,
						"取消",new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, 
										"您点击了取消按钮",Toast.LENGTH_SHORT).show();
							}
						});
				//添加确定按钮
				alert.setButton(DialogInterface.BUTTON_POSITIVE,
						"确定",new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, 
										"您单击了确定按钮",Toast.LENGTH_SHORT).show();
							}
						});
				//添加中立按钮
				alert.setButton(DialogInterface.BUTTON_NEUTRAL,
						"中立",new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
							}
						});
				alert.show();
			}
		});
		//带列表的对话框
		Button button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[] items=new String[]{"游泳","羽毛球","跳高","跑步","体操"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("请选择你喜欢的运动：");
				//添加列表项
				builder.setItems(items, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, 
								"您选择了"+items[which], Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();//创建对话框并显示
			}
		});
	    //带有多个 单选列表和确定按钮的列表对话框
		Button button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[] items=new String[]{"标准","无声","会议","户外","离线"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("请选择要使用的情景模式：");
				builder.setSingleChoiceItems(items, 0, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"您选择了"+items[which],Toast.LENGTH_SHORT ).show();
					}
				});
				builder.setPositiveButton("确定", null);
				builder.create().show();
			}
		});
		//带有多个  多选列表和确定按钮的列表对话框
		Button button4=(Button)findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//记录各个列表的状态
				checkedItems=new boolean[]{false,true,false,true};
				//各列表的内容
				items=new String[]{"桃子","石榴","香蕉","葡萄","橙子"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("请选择你喜欢的水果");
				builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						checkedItems[which]=isChecked;
					}
				});
				builder.setPositiveButton("确定", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String result="";//用于保存选择的结果
						for(int i=0;i<checkedItems.length;i++){
							if(checkedItems[i]){
								result+=items[i]+"、";//将所选内容添加到result
							}
						}
						//当result中不空时，通过消息提示框显示选择的结果
						if(!"".equals(result)){
							result=result.substring(0,result.length()-1);
							Toast.makeText(MainActivity.this, 
									"您选择了["+result+"]",Toast.LENGTH_SHORT).show();
						}
					}
				});
				builder.create().show();
			}
		});
	}

	

}
