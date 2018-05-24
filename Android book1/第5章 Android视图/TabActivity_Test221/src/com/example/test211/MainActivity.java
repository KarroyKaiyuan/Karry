package com.example.test211;


import android.app.AlertDialog;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends TabActivity implements OnTabChangeListener {

	
	@Override
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main);
		new AlertDialog.Builder(this).setTitle("冬季小常识")
		.setMessage("如何快乐过冬").setPositiveButton("确定", null).show();
		TabHost tabHost=this.getTabHost();
		LayoutInflater.from(this).inflate(R.layout.main, tabHost.getTabContentView(),true);
		TabSpec tabFood=tabHost.newTabSpec("food").
				setIndicator("饮食",this.getResources().getDrawable(R.drawable.a1))
				.setContent(R.id.tabFood);
		tabHost.addTab(tabFood);
		
		TabSpec tabCloths=tabHost.newTabSpec("food").
				setIndicator("保暖",this.getResources().getDrawable(R.drawable.a2))
				.setContent(R.id.tabCloths);
		tabHost.addTab(tabCloths);
		
		TabSpec tabOutside=tabHost.newTabSpec("food").
				setIndicator("出行",this.getResources().getDrawable(R.drawable.a3))
				.setContent(R.id.tabOutside);
		tabHost.addTab(tabOutside);
		tabHost.setOnTabChangedListener(this);
		onTabChanged("food");
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		if(tabId.equals("food")){
			TextView tv=(TextView)findViewById(R.id.textView1);
			tv.setText("1.明天你好"+"\n"+"2.董小姐"+"\n"+"3.雪人"+"\n"+"4.夏秋"+"\n"+"5.约定"+"\n");
		}
		 if(tabId.equals("cloths")){
			TextView tv2=(TextView)this.findViewById(R.id.textView2);
			tv2.setText("1.你好"+"\n"+"2.董小"+"\n"+"3.雪人"+"\n"+"4.夏秋"+"\n");
		}
		 else if(tabId.equals("outside")){
			TextView tv3=(TextView)findViewById(R.id.textView3);
			tv3.setText("1.明天你好"+"\n"+"2.董小姐"+"\n"+"3.雪人"+"\n");
		}
	}


	

}
