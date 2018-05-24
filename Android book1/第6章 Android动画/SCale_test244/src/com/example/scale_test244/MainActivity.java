package com.example.scale_test244;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {
	/**
	 * 第一次调用activity活动
	 */
	private ImageView imgView;
	private boolean bool=false;//声明一个boolean用来切换背面和正面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imgView=(ImageView)findViewById(R.id.imgView);
        imgView.setOnClickListener(new ImgViewListener());
    }
    class ImgViewListener implements OnClickListener{
    	public void onClick(View v){
    		//通过AnimationUtils得到动画配置文件（res/anim/back_scale.xml）
    	Animation animation=AnimationUtils.loadAnimation(MainActivity.this,
    			R.anim.back);
    			
			animation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				if(bool){
					imgView.setImageResource(R.drawable.a1);
					bool=false;
				}else{
					imgView.setImageResource(R.drawable.a10);
					bool=true;
				}
				////通过AnimationUtils得到动画配置文件（res/anim/front_scale.xml）
				//然后把动画交给Imageview
				imgView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,
						R.anim.front));
			}
		});
    	imgView.startAnimation(animation);
    	}
    }

  
    
}
