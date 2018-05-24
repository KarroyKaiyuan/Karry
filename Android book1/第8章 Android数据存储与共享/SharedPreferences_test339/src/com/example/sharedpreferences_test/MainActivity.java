package com.example.sharedpreferences_test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText nameText;
	private EditText ageText;
	private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        nameText=(EditText)this.findViewById(R.id.name);
        ageText=(EditText)this.findViewById(R.id.age);
        resultText=(TextView)this.findViewById(R.id.showText);
        Button button=(Button)this.findViewById(R.id.button1);
        Button showButton=(Button)this.findViewById(R.id.button2);
        button.setOnClickListener(listener);
        showButton.setOnClickListener(listener);
        //回显
        SharedPreferences sharedPreferences=getSharedPreferences("ljq123", 
        		Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
        String nameValue=sharedPreferences.getString("name", "");
        int ageValue=sharedPreferences.getInt("age",1);
        nameText.setText(nameValue);
        ageText.setText(String.valueOf(ageValue));
        
        
    }
    private View.OnClickListener listener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button=(Button)v;
			//ljq123文件存放在/data/data/<package name>/shared_prefs目录下
			SharedPreferences sharedPreferences=getSharedPreferences("ljq123",
					Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
			switch (button.getId()) {
			case R.id.button1:
				String name=nameText.getText().toString();
				int age=Integer.parseInt(ageText.getText().toString());
				Editor editor=sharedPreferences.edit();
				editor.putString("name", name);
				editor.putInt("age", age);
				editor.commit();//提交修改
				Toast.makeText(MainActivity.this, "保存成功！", Toast.LENGTH_LONG).show();
				break;

			case R.id.button2:
				String nameValue=sharedPreferences.getString("name","");
				int ageValue=sharedPreferences.getInt("age", 1);
				resultText.setText("姓名:"+nameValue+",年龄："+ageValue);
				break;
			}
		}
	};

  
}
