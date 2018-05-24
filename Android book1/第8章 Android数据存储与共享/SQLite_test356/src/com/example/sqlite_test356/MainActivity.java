package com.example.sqlite_test356;

import java.util.jar.Attributes.Name;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	

    public static final String DB_NAME = "DBTest";
	private E_OpenHelper OpenHelper;
	 Button btnInsert;
	 Button btnDelete;
	 Button btnUpdate;
     Button btnSelect;
	 TextView tvShoContent;
	 EditText etName;
	 EditText etSex;
	 SQLiteDatabase db=null;
	 
	 View.OnClickListener btnInsertListener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			InsertTb();
		}
	};
	View.OnClickListener btnDeleteListener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DeleteTb();
		}
	};
	View.OnClickListener btnIUpdataListener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			UpdataTb();
		}
	};
	View.OnClickListener btnSelectListener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SelectTb();
		}
	};
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        OpenHelper=new E_OpenHelper(this, DB_NAME ,null, 1);
        btnInsert=(Button)findViewById(R.id.main_btn_insert);
        btnDelete=(Button)findViewById(R.id.main_btn_delete);
        btnUpdate=(Button)findViewById(R.id.main_btn_update);
        btnSelect=(Button)findViewById(R.id.main_btn_select);
        tvShoContent=(TextView)findViewById(R.id.main_tv_showContent);
        etName=(EditText)findViewById(R.id.main_et_name);
        etSex=(EditText)findViewById(R.id.main_et_sex);
        btnInsert.setOnClickListener(btnInsertListener);
        btnInsert.setOnClickListener(btnDeleteListener);
        btnInsert.setOnClickListener(btnIUpdataListener);
        btnInsert.setOnClickListener(btnSelectListener);
    }

	protected void InsertTb() {
		// TODO Auto-generated method stub
		int flag=-1;
		db=OpenHelper.getWritableDatabase();
		String strName=etName.getText().toString();
		String strSex=etSex.getText().toString();
		String sql=" insert into TestUsers(name,sex) values('"+strName+"',+'"+strSex+"') ";
		try{
			db.execSQL(sql);
		}catch(SQLException e){
			Log.i("err", "insert failed");
			flag=0;
			Toast.makeText(MainActivity.this, "插入失败！", Toast.LENGTH_SHORT).show();
		}
		db.close();
		if(flag==-1){
			Toast.makeText(MainActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
		}
	}

	protected void DeleteTb() {
		// TODO Auto-generated method stub
		int flag=-1;
		db=OpenHelper.getWritableDatabase();
		String sql="delete from TestUsers where id=2";
		try{
			db.execSQL(sql);
		}catch(SQLException e){
			Log.i("err", "delete failed");
			flag=0;
			Toast.makeText(MainActivity.this, "删除失败！", Toast.LENGTH_SHORT).show();
		}
		db.close();
		if(flag==-1){
			Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
		}
	}

	protected void UpdataTb() {
		// TODO Auto-generated method stub
		int flag=-1;
		db=OpenHelper.getWritableDatabase();
		String Name=etName.getText().toString();
		String sql=" TestUsers set name='anhong',sex='men' where name='"+ Name +"'";
		
		try{
			db.execSQL(sql);
		}catch(SQLException e){
			Log.i("err", "update failed");
			flag=0;
			Toast.makeText(MainActivity.this, "更新失败！", Toast.LENGTH_SHORT).show();
		}
		db.close();
		if(flag==-1){
			Toast.makeText(MainActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
		}
	}

	protected void SelectTb() {
		// TODO Auto-generated method stub
		db=OpenHelper.getReadableDatabase();
		String sql="select sex from TextUsers where name=?";
		Cursor cursor=db.rawQuery(sql, new String[]{
				etName.getText().toString()
		});
		int count=cursor.getCount();
		String []Sex=new String[count];
		int i=0;
		if(cursor.getCount()>0){
			//取多条记录
			int sexIndex=cursor.getColumnIndex("sex");
			for(cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()){
				Sex[i]=cursor.getString(sexIndex);
				i++;
			}
		}
		for (int j=0;j<count;j++){
			tvShoContent.append("");
			tvShoContent.append(Sex[j]);
		}
	}


    
}
