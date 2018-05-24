package com.example.text77;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bLogin=(Button)this.findViewById(R.id.loginLog);
		Button bClear=(Button)this.findViewById(R.id.loginClear);
		final EditText eUid=(EditText)this.findViewById(R.id.EditTextuid);
		final EditText eMima=(EditText)this.findViewById(R.id.EditTextPwd);
		bLogin.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String strUid=eUid.getText().toString().trim();
						String strPwd=eMima.getText().toString().trim();
						if(strUid.equals("ell")&&strPwd.equals("112233"))
						{Toast.makeText(MainActivity.this, "恭喜您登录成功！",
								Toast.LENGTH_SHORT).show();}
						else
						{Toast.makeText(MainActivity.this, "请重新输入用户名和密码！！",
								Toast.LENGTH_SHORT).show();}
					}
				}
				
				);
		bClear.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						eUid.setText("");
						eMima.setText("");
					}
				}
				);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
