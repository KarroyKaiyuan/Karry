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

	String currentPath;//��¼��ǰ�ļ��б�ĸ�·��
	String rootPath="/";//��Ŀ¼
	String leavePath;//Ҷ���ļ�
	Dialog gmDialog;//���������Ի���
	ListView lv;//listview�ؼ���������
	
	public Dialog onCreateDialog(int id){//�����Ի���
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
	//ÿ�ε����Ի���ʱ���ص�����̬���¶Ի������ݵķ���
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
					String newName=et.getText().toString().trim();//��ȡ���ļ�����
					File xgf=new File(leavePath);//��ȡ�޸ĺ���ļ�·��
					String newPath=xgf.getParentFile().getPath()+"/"+newName;
					xgf.renameTo(new File(newPath));
					final File[] files=getFiles(currentPath);//��ȡ���ڵ��ļ�·��
					intoListView(files,lv);//�������ļ���ӵ�listview�б���
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
	        Button bgml=(Button)this.findViewById(R.id.bgml);//������Ŀ¼�ļ���ť
	        Button bsf=(Button)this.findViewById(R.id.bsf);//������Ŀ¼�ļ���ť
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
	
	//��ȡ��ǰĿ¼�µ��ļ��б�
	protected File[] getFiles(String filePath) {
		// TODO Auto-generated method stub
		File[] files=new File(filePath).listFiles();//��ȡ��ǰĿ¼�µ��ļ�
		return files;
	}
	//���ļ��б���ӵ�listview��
	protected void intoListView(final File[] files, final ListView lv) {
		// TODO Auto-generated method stub
		if(files!=null){
			if(files.length==0){//��ǰĿ¼Ϊ��
				File cf=new File(currentPath);//��ȡ��ǰ�ļ��б��·����Ӧ���ļ�
				cf=cf.getParentFile();//��ȡ��Ŀ¼�ļ�
				currentPath=cf.getPath();//��¼��ǰ�ļ��б�·��
				Toast.makeText(MainActivity.this, "���ļ�Ϊ�գ�", Toast.LENGTH_SHORT).show();
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
						ll.setOrientation(LinearLayout.VERTICAL);//��ֱ����
						ll.setPadding(5, 5, 5, 5);//����
						TextView tv=new TextView(MainActivity.this);//��ʼ��textview
						tv.setTextColor(Color.BLACK);
						tv.setText(files[arg0].getName());
						tv.setGravity(Gravity.LEFT);
						tv.setTextSize(18);
						ll.addView(tv);//lineralayout���textview
						return null;
					}
				};
				lv.setAdapter(ba);//����������
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
					File f=new File(files[arg2].getPath());//��ȡ��ǰ������ļ�����
					if(f.isDirectory()){//���ڷ�֧
						currentPath=files[arg2].getPath();
						File[] fs=getFiles(currentPath);//��ȡ��ǰ·�����������ļ�
						intoListView(fs, lv);//�����ļ��б�����listview��
					}
					else
					{
						leavePath=f.getPath();//�����Ի��򣬹��û���д�µ��ļ�����
						showDialog(0);
					}
					
				 }
				});
		}
	}
		else{
			File cf=new File(currentPath);//��ȡ��ǰ�ļ��б��·����Ӧ���ļ�
			cf=cf.getParentFile();//��ȡ��Ŀ¼�ļ�
			currentPath=cf.getPath();//��¼��ǰ�ļ��б�·��
			Toast.makeText(MainActivity.this, "���ļ���Ϊ�գ�", Toast.LENGTH_SHORT).show();
		}
	}
    
}
