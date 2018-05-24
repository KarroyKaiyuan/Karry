package com.example.text43;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.style.UpdateAppearance;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
    TheScreen mScreen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mScreen=new TheScreen(this);
		setContentView(mScreen);
	}

	@Override
	public void onDestroy(){
		// Inflate the menu; this adds items to the action bar if it is present.
		mScreen.stopDrawing();
		super.onDestroy();
	}
}

//自定义view 类
 class TheScreen extends View{
    private static final String TAG="Draw";
    private boolean drawing=false;
    private ArrayList<Circle>circles;
    private Paint mPaint;
    public static final int WIDTH=300;
    public static final int HEIGHT=300;
    public static final double PI=3.14159265;
    Paint mPaint2=new Paint();
	public TheScreen(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
        circles=new ArrayList<Circle>();
        circles.add(new Circle());
        circles.add(new Circle(20,30,10));
        mPaint=new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mPaint2.setStyle(Style.STROKE);
        mPaint2.setColor(Color.RED);
        mPaint2.setAntiAlias(true);
        drawing=true;
        new Thread(mRunnable).start();
	}
    private Runnable mRunnable=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(drawing)
			{
				try{
					update();
					postInvalidate();
					Thread.sleep(30);					
				}
				catch(InterruptedException e)
				{e.printStackTrace();}
			}
		}
	
	};
	
	public void stopDrawing() {
		// TODO Auto-generated method stub
		drawing=false;
	}
	public void onDraw(Canvas canvas)
	{
		canvas.drawRect(0, 0, WIDTH, HEIGHT, mPaint2);
		for(Circle circle:circles)
		{canvas.drawCircle(circle.x, circle.y, circle.radius, mPaint);}
	}

    private void update() {
		// TODO Auto-generated method stub
    	if(circles.size()>1)
    	{
    		for(int i1=0;i1<circles.size()-1;i1++)
    		{
    			for(int i2=0;i2<circles.size();i2++)
    				if(checkBumb(circles.get(i1),circles.get(i2)))
    				{circles.get(i1).changeDerection(circles.get(i2));}
    		}
    	}
    	for(Circle circle:circles) circle.updateLocate();		
	}
 
  private boolean checkBumb(Circle c1, Circle c2) {
		// TODO Auto-generated method stub
		return (c1.x-c2.x)*(c1.x-c2.x)+(c1.y-c2.y)*(c1.y-c2.y)
				<=(c1.radius+c2.radius)*(c1.radius+c2.radius);
	}

class Circle{

	public float x=50;
	public float y=70;
	public int radius=10;
	int speed=4;
	double angle=(new Random().nextFloat())*2*PI;
	public Circle(float x, float y,int r) {
		// TODO Auto-generated constructor stub
		this.x=x;this.y=y;radius=r;
	}

	public void updateLocate() {
		// TODO Auto-generated method stub
		x=x+(float)(speed*Math.cos(angle));
		y=y+(float)(speed*Math.sin(angle));
		if((x+radius)>=WIDTH)
		{
            if(angle>=0&&angle<=(PI/2)) angle=PI-angle;
            if(angle>=1.5&&angle<=(PI*2)) angle=3*PI-angle;
		}
		if(x-radius<=0)
		{
			if(angle>=PI&&angle<=1.5*PI) angle=3*PI-angle;
			if(angle>=PI/2&&angle<PI) angle=PI-angle;
		}
		if(y-radius<=0||y+radius>=HEIGHT) angle=2*PI-angle;
	}

	public void changeDerection(Circle other) {
		// TODO Auto-generated method stub
		double temp=this.angle;
		this.angle=other.angle;
		other.angle=temp;
	}

	public Circle() {
		// TODO Auto-generated constructor stub
	}
  }
 }