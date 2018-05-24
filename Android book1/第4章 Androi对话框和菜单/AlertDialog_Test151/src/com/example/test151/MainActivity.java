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
		super.onCreate(savedInstanceState);//�б���״̬
		setContentView(R.layout.main);//�б�������
		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setIcon(R.drawable.ic_launcher);
				alert.setTitle("ϵͳ��ʾ��");
				alert.setMessage("����ȡ����������ȷ����ť�ĶԻ���");
				//���ȡ����ť
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,
						"ȡ��",new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, 
										"�������ȡ����ť",Toast.LENGTH_SHORT).show();
							}
						});
				//���ȷ����ť
				alert.setButton(DialogInterface.BUTTON_POSITIVE,
						"ȷ��",new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, 
										"��������ȷ����ť",Toast.LENGTH_SHORT).show();
							}
						});
				//���������ť
				alert.setButton(DialogInterface.BUTTON_NEUTRAL,
						"����",new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
							}
						});
				alert.show();
			}
		});
		//���б�ĶԻ���
		Button button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[] items=new String[]{"��Ӿ","��ë��","����","�ܲ�","���"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("��ѡ����ϲ�����˶���");
				//����б���
				builder.setItems(items, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, 
								"��ѡ����"+items[which], Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();//�����Ի�����ʾ
			}
		});
	    //���ж�� ��ѡ�б��ȷ����ť���б�Ի���
		Button button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[] items=new String[]{"��׼","����","����","����","����"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("��ѡ��Ҫʹ�õ��龰ģʽ��");
				builder.setSingleChoiceItems(items, 0, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"��ѡ����"+items[which],Toast.LENGTH_SHORT ).show();
					}
				});
				builder.setPositiveButton("ȷ��", null);
				builder.create().show();
			}
		});
		//���ж��  ��ѡ�б��ȷ����ť���б�Ի���
		Button button4=(Button)findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��¼�����б��״̬
				checkedItems=new boolean[]{false,true,false,true};
				//���б������
				items=new String[]{"����","ʯ��","�㽶","����","����"};
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("��ѡ����ϲ����ˮ��");
				builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						checkedItems[which]=isChecked;
					}
				});
				builder.setPositiveButton("ȷ��", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String result="";//���ڱ���ѡ��Ľ��
						for(int i=0;i<checkedItems.length;i++){
							if(checkedItems[i]){
								result+=items[i]+"��";//����ѡ������ӵ�result
							}
						}
						//��result�в���ʱ��ͨ����Ϣ��ʾ����ʾѡ��Ľ��
						if(!"".equals(result)){
							result=result.substring(0,result.length()-1);
							Toast.makeText(MainActivity.this, 
									"��ѡ����["+result+"]",Toast.LENGTH_SHORT).show();
						}
					}
				});
				builder.create().show();
			}
		});
	}

	

}
