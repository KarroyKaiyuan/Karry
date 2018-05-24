package com.example.frameanimation_test235;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	private Button button1,button2;
	private RadioGroup radioGroup;
	private RadioButton radioButton1,radioButton2;
	private SeekBar seekBar;
	private ImageView imageView1;
	private AnimationDrawable animationDrawable;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1=(Button)this.findViewById(R.id.button1);
        button2=(Button)this.findViewById(R.id.button2);
        radioGroup=(RadioGroup)this.findViewById(R.id.radioGroup1);
        radioButton1=(RadioButton)this.findViewById(R.id.radioButton1);
        radioButton2=(RadioButton)this.findViewById(R.id.radioButton2);
        seekBar=(SeekBar)this.findViewById(R.id.seekBar1);
        imageView1=(ImageView)this.findViewById(R.id.imageView1);
        //通过imageview对象拿到背景显示的AnimationDrawable
        animationDrawable=(AnimationDrawable)imageView1.getBackground();
        
        button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!animationDrawable.isRunning()){
					animationDrawable.start();
				}
			}
		});
       button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!animationDrawable.isRunning()){
					animationDrawable.stop();
				}
			}
		});
       radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkeId) {
			// TODO Auto-generated method stub
			if(checkeId==radioButton1.getId()){
				animationDrawable.setOneShot(true);//设置单次播放
				}
			else if(checkeId==radioButton2.getId()){
				animationDrawable.setOneShot(false);//设置循环播放
			}
			animationDrawable.stop();
			animationDrawable.start();
		}
	});
       //监听进度条修改的透明度
       seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser){
			animationDrawable.setAlpha(progress);//设置动画alpha的值
			imageView1.postInvalidate();//通知imageview刷新屏幕
		
			
		}
	});
    }

}
