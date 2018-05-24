package com.example.rotate_test240;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView image;
	Button start;
	Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        image=(ImageView)this.findViewById(R.id.imageView1);
        start=(Button)findViewById(R.id.bt1);
        cancel=(Button)findViewById(R.id.bt2);
        //设置旋转动画
        final RotateAnimation animation=new RotateAnimation(0f,
        		360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(3000);
        //常用方法
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				image.setAnimation(animation);
				animation.startNow();
			}
		});
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				animation.cancel();
			}
		});
    }


   
}
