package com.example.test103;

import android.os.Bundle;
import android.app.Activity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ToggleButton tb=(ToggleButton)this.findViewById(R.id.toggleButton1);
		tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				setBulbState(isChecked);
			}
		});
	}
	public void setBulbState(boolean state){
		//…Ë÷√Õº∆¨◊¥Ã¨
		ImageView iv=(ImageView)this.findViewById(R.id.imageView1);
		iv.setImageResource((state)?R.drawable.a2:R.drawable.a1);
		//…Ë÷√ToggleButton◊¥Ã¨
		ToggleButton tb=(ToggleButton)this.findViewById(R.id.toggleButton1);
		tb.setChecked(state);
	}

	
}
