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
		//Ϊ��ť�󶨼����¼�
		bn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("�Զ������ͨ�Ի���");
				//װ��res/layout/denglu.xmls���沼��****
				TableLayout loginForm=(TableLayout)getLayoutInflater()
						.inflate(R.layout.denglu, null);
				builder.setView(loginForm);
				//Ϊ�Ի�������һ��ȷ����ť
				builder.setPositiveButton("��¼", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//�˴���ִ�е�¼����
					}
				});
				//Ϊ�Ի�������һ��ȡ����ť
				builder.setNegativeButton("ȡ��", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//ȡ����¼�������κ���
					}
				});
				//���� ��ʾ�Ի���
				builder.create().show();
			}
		});
	}

	

}
