package com.example.contenturi_test363;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

	private Button button1;
	private Button button2;

	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("insertAction",
						Uri.parse("content://com.example.contenturi_test363.www/insert"));
				Main.this.startActivity(intent);
			}
		});
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("deleteAction",
						Uri.parse("content://com.example.contenturi_test363.www/delete/999"));
				Main.this.startActivity(intent);
			}
		});
    }


}
