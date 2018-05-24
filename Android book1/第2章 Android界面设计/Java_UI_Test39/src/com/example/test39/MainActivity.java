package com.example.test39;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {
    public TextView text2;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FrameLayout frameLayout=new FrameLayout(this);
		frameLayout.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.ic_launcher));
		setContentView(frameLayout);
		
		TextView text1=new TextView(this);
		text1.setText("�ڴ����п���ui����");
		text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24);
		text1.setTextColor(Color.rgb(0,1,1));
		frameLayout.addView(text1);
		
		TextView text2=new TextView(this);
		text2.setText("���������Ϸ.....");
		text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24);
		text2.setTextColor(Color.rgb(1,0,1));
		
		LayoutParams params=new LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		params.gravity=Gravity.CENTER;
		
		text2.setLayoutParams(params);
		text2.setOnClickListener(new OnClickListener(){
		 @Override
		 public void onClick(View w){
			 new AlertDialog.Builder(MainActivity.this).setTitle("ϵͳ��ʾ")
					 .setMessage("��Ϸ�з��գ������������ȷ��Ҫ������")
					 .setPositiveButton("ȷ��",new DialogInterface.OnClickListener() 
					 {
						 @Override
						public void onClick(DialogInterface dialog, int which) {
						Log.i("3.2", "������Ϸ");}
					}).setNegativeButton("�˳�",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Log.i("3.2", "�˳���Ϸ");finish();}
					}).show();
		 } 
		});		
			 frameLayout.addView(text2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
