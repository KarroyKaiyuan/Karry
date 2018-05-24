package com.example.translate_test249;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	Animation showAction,hideAction;
	LinearLayout menu;
	Button button;
	boolean menuShowed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        menu=(LinearLayout)findViewById(R.id.menu);
        button=(Button)findViewById(R.id.button);
        showAction=new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,
        		Animation.RELATIVE_TO_SELF,-1.0f,Animation.RELATIVE_TO_SELF,0.0f);
        showAction.setDuration(500);
        hideAction=new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,
        		Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,-1.0f);
        hideAction.setDuration(500);
        menuShowed=false;
        menu.setVisibility(View.GONE);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(menuShowed){
					menuShowed=false;
					menu.startAnimation(hideAction);
					menu.setVisibility(View.GONE);
				}
				else{
					menuShowed=true;
					menu.startAnimation(showAction);
					menu.setVisibility(View.VISIBLE);
				}
			}
		});
        
    }


   
    
}
