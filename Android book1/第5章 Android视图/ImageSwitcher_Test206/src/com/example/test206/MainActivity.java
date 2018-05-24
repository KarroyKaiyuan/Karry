package com.example.test206;
import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements ViewFactory, OnTouchListener {

	private static final int Oxff000000 = 0;
	private ImageSwitcher mImageSwitcher;//
	private int[] imgIds;//ͼƬid����
	private int currentPosition;//��ǰѡ��ͼƬ��id
	private float downX;//���µ�x������
	private LinearLayout  linearLayout;//װ�ص�������
	private ImageView[] tips;//�������
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		imgIds=new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};
		mImageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher1);//ʵ����
		mImageSwitcher.setFactory(this);
		mImageSwitcher.setOnTouchListener(this);//ͨ��touch�¼����л�ͼƬ
		linearLayout=(LinearLayout)findViewById(R.id.viewGroup);
		tips=new ImageView[imgIds.length];
		for(int i=0;i<imgIds.length;i++){
			ImageView mImageView=new ImageView(this);
			tips[i]=mImageView;
			LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT) );
			layoutParams.rightMargin=3;
			layoutParams.leftMargin=3;
		}
		//����һ������GridView������
		currentPosition=getIntent().getIntExtra("position", 0);
		mImageSwitcher.setImageResource(imgIds[currentPosition]);
	}
    
	public View makeView(){
		final ImageView i=new ImageView(this);
		i.setBackgroundColor(Oxff000000);
		i.setScaleType(ImageView.ScaleType.CENTER_CROP);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		return i;
		
	}
	
	public boolean onTouch(View v,MotionEvent event){
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:{
			downX=event.getX();//��ָ���µ�x����
			break;
		}
		case MotionEvent.ACTION_UP:{
			float lastX=event.getX();
			if(lastX>downX){
				if(currentPosition>0){
					mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(getApplication(),
							R.anim.left_in));
					mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getApplication(),
							R.anim.right_out));
					currentPosition--;
					mImageSwitcher.setImageResource(imgIds[currentPosition%imgIds.length]);
				}else{
					Toast.makeText(getApplication(), "�Ѿ��ǵ�һ��", Toast.LENGTH_SHORT).show();
				}
			}
			
			if(lastX<downX){
				if(currentPosition<imgIds.length-1){
					mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(getApplication(),
							R.anim.left_in));
					mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getApplication(),
							R.anim.right_out));
					currentPosition++;
					mImageSwitcher.setImageResource(imgIds[currentPosition]);
				}else{
					Toast.makeText(getApplication(), "�Ѿ������һ��", Toast.LENGTH_SHORT).show();
				}
			}
		    }
		break;
		}
		return true;
		
	}

	

}
