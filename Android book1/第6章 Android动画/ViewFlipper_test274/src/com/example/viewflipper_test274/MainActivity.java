package com.example.viewflipper_test274;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnTouchListener {

	private ViewFlipper viewFlipper;
	//���һ���ʱ��ָ���µ�X����
	private float touchDownX;
	//���һ���ʱ��ָ�ɿ���X����
	private float touchUpX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        viewFlipper.setOnTouchListener(this);
    }
     public boolean onTouch(View v,MotionEvent event){
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			touchDownX=event.getX();
			return true;
		}
		else if(event.getAction()==MotionEvent.ACTION_UP){
			touchUpX=event.getX();
			//�������ҿ���һ��view
			if(touchUpX-touchDownX>100){
				//����view�л��Ķ���
				viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
						android.R.anim.slide_in_left));
				viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
						android.R.anim.slide_out_right));
				//��ʾ��һ��view
				viewFlipper.showPrevious();
			}else if(touchDownX-touchUpX>100){
				viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
						R.anim.slide_in_right));
				viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
						R.anim.slide_out_left));
				//��ʾ��һ��view
				viewFlipper.showNext();
			}
			return true;
		}
    	 return false;
     }
}
