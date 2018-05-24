package com.example.test185;

import android.R.bool;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.widget.EditText;

public class MainActivity extends Activity {

	final int MENU_GENDER_MALE=0;
	final int MENU_GENDER_FEMALE=1;
	final int MENU_HOBBY1=2;
	final int MENU_HOBBY2=3;
	final int MENU_HOBBY3=4;
	final int MENU_OK=5;
	final int MENU_GENDER=6;
	final int MENU_HOBBY=7;
	final int GENDER_GROUP=0;
	final int HOBBY_GROUP=1;
	final int MAIN_GROUP=2;
	MenuItem[] miaHobby=new MenuItem[3];//���ò˵�����
	MenuItem male=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	//ͨ��onCreateOptionsMenuʵ�ֳ�ʼ���˵����ô����������˵���
	//�ֱ�Ϊ�Ա��Ӳ˵� �����Ӳ˵� ȷ���Ӳ˵�
	public boolean onCreateOptionsMenu(Menu menu){
		//�Ա�ѡ�˵����� �˵�����ž��ǵ�ѡ�˵�����
		SubMenu subMenuGender=menu.addSubMenu(MAIN_GROUP,MENU_GENDER,0,R.string.gender);
		subMenuGender.setIcon(R.drawable.a3);
		subMenuGender.setHeaderIcon(R.drawable.a3);
		male=subMenuGender.add(GENDER_GROUP,MENU_GENDER_MALE,0,R.string.male);
		male.setChecked(true);
		subMenuGender.add(GENDER_GROUP,MENU_GENDER_MALE,0,R.string.female);
		//����GENDER_GROUP���ǿ�ѡ��� �����
		subMenuGender.setGroupCheckable(GENDER_GROUP, true, true);
		//���ø�ѡ�˵�ѡ��
		SubMenu subMenuHobby=menu.addSubMenu(MAIN_GROUP,MENU_HOBBY,0,R.string.hobby);
		miaHobby[0]=subMenuHobby.add(HOBBY_GROUP,MENU_HOBBY1,0,R.string.hobby1);
		miaHobby[1]=subMenuHobby.add(HOBBY_GROUP,MENU_HOBBY2,0,R.string.hobby2);
		miaHobby[2]=subMenuHobby.add(HOBBY_GROUP,MENU_HOBBY3,0,R.string.hobby3);
		miaHobby[0].setCheckable(true);
		miaHobby[1].setCheckable(true);
		miaHobby[2].setCheckable(true);
		//ȷ���˵���
		MenuItem ok=menu.add(GENDER_GROUP+2,MENU_OK,0,R.string.ok);
		OnMenuItemClickListener lsn=new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				appendStateStr();
				return true;
			}
		};
		
		ok.setOnMenuItemClickListener(lsn);//��ȷ���˵�����Ӽ�������
		//��ȷ���˵�����ӿ�ݼ�
		ok.setAlphabeticShortcut('o');//�����ַ���ݼ�
		//Ҫע�⣬ͬʱ���ö��ʱֻ�����һ������������
		return true;
	}
	//��ѡ�͸�ѡ�˵�ѡ����״̬�仯��Ļص�����
	//����ѡ��˵�
	public boolean onOptionsItemSelected(MenuItem mi){
		switch(mi.getItemId()){
		case MENU_GENDER_MALE://��ѡ�˵���״̬���л�Ҫ����д�������
		case MENU_GENDER_FEMALE:
			mi.setChecked(true);
			appendStateStr();//����Ч��Ŀ�仯ʱ��¼���ı�����
			break;
		case MENU_HOBBY1:
		case MENU_HOBBY2:
		case MENU_HOBBY3:
			mi.setChecked(!mi.isChecked());
			appendStateStr();//����Ч��Ŀ�仯ʱ��¼���ı�����
			break;
		}
		return true;
	}
	//��ȡ��ǰѡ��״̬�ķ���
	private void appendStateStr() {
		// TODO Auto-generated method stub
		String result="����ѡ��Ϊ��";
		if(male.isChecked()){
			result=result+"��";
		}else{
			result=result+"Ů";
		}
		String hobbyStr="";
		for(MenuItem mi:miaHobby){
			if(mi.isChecked()){
				hobbyStr=hobbyStr+mi.getTitle()+"��";
			}
		}
		if(hobbyStr.length()>0){
			result=result+"������Ϊ��"+hobbyStr.substring(0,hobbyStr.length()-1)+".\n";
		}else{
			result=result+".\n";
		}
		EditText et=(EditText)MainActivity.this.findViewById(R.id.editText01);
		et.append(result);
	}

	

}
