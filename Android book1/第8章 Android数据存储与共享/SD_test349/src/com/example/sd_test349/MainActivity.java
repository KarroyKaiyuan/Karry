package com.example.sd_test349;

import java.io.File;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String currentPath;//记录当前文件列表的父路径
	String rootPath="/";//根目录
	String leavePath;//叶子文件
	Dialog gmDialog;//声明改名对话框
	ListView lv;//listview控件对象声明
	
	public Dialog onCreateDialog(int id){//创建对话框
		Dialog result=null;
		switch(id){
		case 0:
			AlertDialog.Builder b=new AlertDialog.Builder(this);
			b.setItems(null, null);
			b.setCancelable(false);
			gmDialog=b.create();
			result=gmDialog;
			break;
		}
		return result;
	}
	//每次弹出对话框时被回调，动态更新对话框内容的方法
	public void onPrepareDialog(int id,final Dialog dialog){
		switch (id) {
		case 0:
			dialog.setContentView(R.layout.dialog);
			Button bok=(Button)findViewById(R.id.bOk);
			Button bcancel=(Button)findViewById(R.id.bCancle);
			final EditText et=(EditText)dialog.findViewById(R.id.et);
			bok.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String newName=et.getText().toString().trim();//获取新文件名称
					File xgf=new File(leavePath);//获取修改后的文件路径
					String newPath=xgf.getParentFile().getPath()+"/"+newName;
					xgf.renameTo(new File(newPath));
					final File[] files=getFiles(currentPath);//获取根节点文件路径
					intoListView(files,lv);//将各个文件添加到listview列表中
					dialog.cancel();
				}
			});
			bcancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			dialog.setCancelable(true);
			break;
		}
		}
		public void onCreate(Bundle savedInstanceState){
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        lv=(ListView)MainActivity.this.findViewById(R.id.lvwjlb);
	        Button bgml=(Button)this.findViewById(R.id.bgml);//搜索根目录文件按钮
	        Button bsf=(Button)this.findViewById(R.id.bsf);//搜索父目录文件按钮
	        bgml.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					currentPath=rootPath;
					final File[] files=getFiles(currentPath);
					intoListView(files,lv);
				}
			});
	        bsf.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if((currentPath!=null)&&(!currentPath.equals(rootPath))){
						File cf=new File(currentPath);
						cf=cf.getParentFile();
						currentPath=cf.getPath();
						intoListView(getFiles(currentPath), lv);
					}
				}
			});
		}
	
	//获取当前目录下的文件列表
	protected File[] getFiles(String filePath) {
		// TODO Auto-generated method stub
		File[] files=new File(filePath).listFiles();//获取当前目录下的文件
		return files;
	}
	//将文件列表添加到listview中
	protected void intoListView(final File[] files, final ListView lv) {
		// TODO Auto-generated method stub
		if(files!=null){
			if(files.length==0){//当前目录为空
				File cf=new File(currentPath);//获取当前文件列表的路径对应的文件
				cf=cf.getParentFile();//获取父目录文件
				currentPath=cf.getPath();//记录当前文件列表路径
				Toast.makeText(MainActivity.this, "该文件为空！", Toast.LENGTH_SHORT).show();
			}
			else{
				BaseAdapter ba=new BaseAdapter() {
					@Override
					public long getItemId(int position) {
						// TODO Auto-generated method stub
						return 0;
					}
					
					@Override
					public Object getItem(int position) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public int getCount() {
						// TODO Auto-generated method stub
						return files.length;
					}
					@Override
					public View getView(int arg0, View arg1, ViewGroup arg2) {
						// TODO Auto-generated method stub
						LinearLayout ll=new LinearLayout(MainActivity.this);
						ll.setOrientation(LinearLayout.VERTICAL);//竖直排列
						ll.setPadding(5, 5, 5, 5);//留白
						TextView tv=new TextView(MainActivity.this);//初始化textview
						tv.setTextColor(Color.BLACK);
						tv.setText(files[arg0].getName());
						tv.setGravity(Gravity.LEFT);
						tv.setTextSize(18);
						ll.addView(tv);//lineralayout添加textview
						return null;
					}
				};
				lv.setAdapter(ba);//设置适配器
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
					File f=new File(files[arg2].getPath());//获取当前点击的文件对象
					if(f.isDirectory()){//存在分支
						currentPath=files[arg2].getPath();
						File[] fs=getFiles(currentPath);//获取当前路径下所有子文件
						intoListView(fs, lv);//将子文件列表填入listview中
					}
					else
					{
						leavePath=f.getPath();//弹出对话框，供用户填写新的文件名称
						showDialog(0);
					}
					
				 }
				});
		}
	}
		else{
			File cf=new File(currentPath);//获取当前文件列表的路径对应的文件
			cf=cf.getParentFile();//获取父目录文件
			currentPath=cf.getPath();//记录当前文件列表路径
			Toast.makeText(MainActivity.this, "该文件夹为空！", Toast.LENGTH_SHORT).show();
		}
	}
    
}
