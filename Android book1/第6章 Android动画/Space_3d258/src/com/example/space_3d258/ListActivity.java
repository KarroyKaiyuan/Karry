package com.example.space_3d258;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.WebView.FindListener;
import android.widget.ListView;
public class ListActivity extends Activity {
	@Override
	 public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView list=(ListView)findViewById(R.id.list);
		WindowManager windowManager=(WindowManager)getSystemService(WINDOW_SERVICE);
		Display display=windowManager.getDefaultDisplay();
		int screenWidth=display.getWidth();
		int screenHeight=display.getHeight();
		list.setAnimation(new MainActivity(screenWidth/2, screenHeight/2, 3500));
	}
	
}
