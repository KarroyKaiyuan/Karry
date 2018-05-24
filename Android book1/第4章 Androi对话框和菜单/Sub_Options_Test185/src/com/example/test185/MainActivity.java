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
	MenuItem[] miaHobby=new MenuItem[3];//爱好菜单项组
	MenuItem male=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	//通过onCreateOptionsMenu实现初始化菜单，该处包括三个菜单项
	//分别为性别子菜单 爱好子菜单 确定子菜单
	public boolean onCreateOptionsMenu(Menu menu){
		//性别单选菜单项组 菜单若编号就是单选菜单项组
		SubMenu subMenuGender=menu.addSubMenu(MAIN_GROUP,MENU_GENDER,0,R.string.gender);
		subMenuGender.setIcon(R.drawable.a3);
		subMenuGender.setHeaderIcon(R.drawable.a3);
		male=subMenuGender.add(GENDER_GROUP,MENU_GENDER_MALE,0,R.string.male);
		male.setChecked(true);
		subMenuGender.add(GENDER_GROUP,MENU_GENDER_MALE,0,R.string.female);
		//设置GENDER_GROUP组是可选择的 互斥的
		subMenuGender.setGroupCheckable(GENDER_GROUP, true, true);
		//爱好复选菜单选项
		SubMenu subMenuHobby=menu.addSubMenu(MAIN_GROUP,MENU_HOBBY,0,R.string.hobby);
		miaHobby[0]=subMenuHobby.add(HOBBY_GROUP,MENU_HOBBY1,0,R.string.hobby1);
		miaHobby[1]=subMenuHobby.add(HOBBY_GROUP,MENU_HOBBY2,0,R.string.hobby2);
		miaHobby[2]=subMenuHobby.add(HOBBY_GROUP,MENU_HOBBY3,0,R.string.hobby3);
		miaHobby[0].setCheckable(true);
		miaHobby[1].setCheckable(true);
		miaHobby[2].setCheckable(true);
		//确定菜单项
		MenuItem ok=menu.add(GENDER_GROUP+2,MENU_OK,0,R.string.ok);
		OnMenuItemClickListener lsn=new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				appendStateStr();
				return true;
			}
		};
		
		ok.setOnMenuItemClickListener(lsn);//给确定菜单项添加监听器·
		//给确定菜单项添加快捷键
		ok.setAlphabeticShortcut('o');//设置字符快捷键
		//要注意，同时设置多次时只有最后一个设置起作用
		return true;
	}
	//单选和复选菜单选项中状态变化后的回调方法
	//其他选项菜单
	public boolean onOptionsItemSelected(MenuItem mi){
		switch(mi.getItemId()){
		case MENU_GENDER_MALE://单选菜单项状态的切换要自行写代码完成
		case MENU_GENDER_FEMALE:
			mi.setChecked(true);
			appendStateStr();//当有效项目变化时记录在文本区中
			break;
		case MENU_HOBBY1:
		case MENU_HOBBY2:
		case MENU_HOBBY3:
			mi.setChecked(!mi.isChecked());
			appendStateStr();//当有效项目变化时记录在文本区中
			break;
		}
		return true;
	}
	//获取当前选择状态的方法
	private void appendStateStr() {
		// TODO Auto-generated method stub
		String result="您的选择为：";
		if(male.isChecked()){
			result=result+"男";
		}else{
			result=result+"女";
		}
		String hobbyStr="";
		for(MenuItem mi:miaHobby){
			if(mi.isChecked()){
				hobbyStr=hobbyStr+mi.getTitle()+"、";
			}
		}
		if(hobbyStr.length()>0){
			result=result+"，爱好为："+hobbyStr.substring(0,hobbyStr.length()-1)+".\n";
		}else{
			result=result+".\n";
		}
		EditText et=(EditText)MainActivity.this.findViewById(R.id.editText01);
		et.append(result);
	}

	

}
