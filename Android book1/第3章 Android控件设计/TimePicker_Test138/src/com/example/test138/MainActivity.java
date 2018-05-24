package com.example.test138;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends Activity {

	private DatePicker dataPicker1;
	private Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dataPicker1=(DatePicker)findViewById(R.id.datePicker1);
		//设置默认时间
		dataPicker1.updateDate(2016, 8, 6);
		button1=(Button)findViewById(R.id.button1);
		OnClicLisers cl=new OnClicLisers();
		button1.setOnClickListener(cl);
		
	}
	class OnClicLisers implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int y=dataPicker1.getYear();
			int m=dataPicker1.getMonth()+1;
			int d=dataPicker1.getDayOfMonth();
			System.out.println("y:"+y+"m:"+m+"d:"+d);
		}
		
	}
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

	

}
