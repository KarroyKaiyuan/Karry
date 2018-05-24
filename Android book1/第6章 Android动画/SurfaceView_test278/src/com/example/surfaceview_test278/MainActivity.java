package com.example.surfaceview_test278;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity {

	private SurfaceHolder holder;//SurfaceHolder负责维护SurfaceView上绘制的内容
	private Paint paint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        paint=new Paint();
        //获取SurfaceView实例
        SurfaceView surface=(SurfaceView)findViewById(R.id.surfaceView1);
        //初始化SurfaceHolder的对象
        holder=surface.getHolder();
        holder.addCallback(new Callback() {
        	//当surface将要被销毁时回调该方法
        	public void surfaceDestroyed(SurfaceHolder holder){
        		
        	}
        	//当被创建时回调该方法
        	@Override
			public void surfaceCreated(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				//锁定整个Surfaceview
        		Canvas canvas=holder.lockCanvas();
        		//获取背景资源
        		Bitmap bitmap=BitmapFactory.decodeResource(
        				MainActivity.this.getResources(),R.drawable.a4);
        		//绘制背景
        		canvas.drawBitmap(bitmap,0,0,null);
        		//绘制完成，释放幕布提交修改
        		holder.unlockCanvasAndPost(canvas);
        		//重新锁两次，避免瑕疵lockCanvas被遮改
        		holder.lockCanvas(new Rect(0,0,0,0));
        		holder.unlockCanvasAndPost(canvas);
        		holder.lockCanvas(new Rect(0,0,0,0));
        		holder.unlockCanvasAndPost(canvas);
        	}
        	//当一个surface的格式或大小发生改变时回调该方法
        	public void surfaceChanged(SurfaceHolder holder,int format,
        			int width,int height){
        		
        	}
			
		});
        surface.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				//只处理按下事件
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					int cx=(int)event.getX();
					int cy=(int)event.getY();
					//锁定SURfaceview的局部区域，只更新局部内容
					Canvas canvas=holder.lockCanvas(
							new Rect(cx-60,cy-60,cx+60,cy+60));
					//保存canvas的当前状态
					canvas.save();
					//旋转画布
					canvas.rotate(30,cx,cy);
					paint.setColor(Color.RED);
					//绘制红色方块
					canvas.drawRect(cx-40,cy-40,cx,cy,paint);
					//恢复canvas之前的保存状态
					canvas.restore();
					paint.setColor(Color.GREEN);
					//绘制绿色的方块
					canvas.drawRect(cx,cy,cx+40,cy+40,paint);
					//绘制完成，释放幕布，提交修改
					holder.unlockCanvasAndPost(canvas);
				}
				return false;
			}
		});
    }
}
