package com.example.test89;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv=(TextView)this.findViewById(R.id.TextView1);
        final ImageButton but1=(ImageButton)this.findViewById(R.id.ImageButton1);
        final ImageButton but2=(ImageButton)this.findViewById(R.id.ImageButton2);
        
        but1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.setText("点击的第一个按钮");
				but1.setImageDrawable(getResources().getDrawable(R.drawable.a3));
				but2.setImageDrawable(getResources().getDrawable(R.drawable.a4));
			}
		});
       but2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.setText("点击的第2个按钮");
				but2.setImageDrawable(getResources().getDrawable(R.drawable.a4));
				but1.setImageDrawable(getResources().getDrawable(R.drawable.a1));
			}
		});
    
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
