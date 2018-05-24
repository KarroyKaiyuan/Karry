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
		new AlertDialog.Builder(this).setTitle("����С��ʶ")
		.setMessage("��ο��ֹ���").setPositiveButton("ȷ��", null).show();
		TabHost tabHost=this.getTabHost();
		LayoutInflater.from(this).inflate(R.layout.main, tabHost.getTabContentView(),true);
		TabSpec tabFood=tabHost.newTabSpec("food").
				setIndicator("��ʳ",this.getResources().getDrawable(R.drawable.a1))
				.setContent(R.id.tabFood);
		tabHost.addTab(tabFood);
		
		TabSpec tabCloths=tabHost.newTabSpec("food").
				setIndicator("��ů",this.getResources().getDrawable(R.drawable.a2))
				.setContent(R.id.tabCloths);
		tabHost.addTab(tabCloths);
		
		TabSpec tabOutside=tabHost.newTabSpec("food").
				setIndicator("����",this.getResources().getDrawable(R.drawable.a3))
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
			tv.setText("1.�������"+"\n"+"2.��С��"+"\n"+"3.ѩ��"+"\n"+"4.����"+"\n"+"5.Լ��"+"\n");
		}
		 if(tabId.equals("cloths")){
			TextView tv2=(TextView)this.findViewById(R.id.textView2);
			tv2.setText("1.���"+"\n"+"2.��С"+"\n"+"3.ѩ��"+"\n"+"4.����"+"\n");
		}
		 else if(tabId.equals("outside")){
			TextView tv3=(TextView)findViewById(R.id.textView3);
			tv3.setText("1.�������"+"\n"+"2.��С��"+"\n"+"3.ѩ��"+"\n");
		}
	}


	

}
