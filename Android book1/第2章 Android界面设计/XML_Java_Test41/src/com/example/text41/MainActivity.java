package com.example.text41;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.text.Layout;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private ImageView[] a=new  ImageView[3];
	private int[] aPath=new int[]
	{R.drawable.a01,R.drawable.a02,R.drawable.a03};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LinearLayout layout=(LinearLayout)findViewById(R.id.layout);
		for(int i=0;i<aPath.length;i++)
		{

			a[i]=new ImageView(this);
			a[i].setImageResource(aPath[i]);
			a[i].setPaddingRelative(5, 5, 5, 5);
			LayoutParams params=new LayoutParams(254,168);
			a[i].setLayoutParams(params);
			layout.addView(a[i]);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
