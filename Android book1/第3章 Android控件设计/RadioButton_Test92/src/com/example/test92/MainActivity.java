package com.example.test92;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button button1;
    private TextView textView1;
    private RadioGroup radioGroup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        radioGroup1=(RadioGroup)this.findViewById(R.id.radioGroup1);
        button1=(Button)this.findViewById(R.id.button1);
        textView1=(TextView)this.findViewById(R.id.textView1);
        
        radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				textView1.setText(((RadioGroup)MainActivity.this.findViewById(arg1))
						.getContext().toString());
			}
		});
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.v("!!", ((RadioButton)MainActivity.this.findViewById(
						radioGroup1.getCheckedRadioButtonId())).getTag().toString());
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
