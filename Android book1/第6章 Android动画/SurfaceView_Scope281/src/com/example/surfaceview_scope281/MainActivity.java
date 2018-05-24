package com.example.surfaceview_scope281;

import java.util.Timer;
import java.util.TimerTask;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private SurfaceHolder holder;
	private Paint paint;
	final int HEIGHT=320;
	final int WIDTH=320;
	final int X_OFFSET=5;
	private int cx=X_OFFSET;
	//ʵ�ʵ�y���λ��
	int centerY=HEIGHT/2;
	Timer timer=new Timer();
	TimerTask task=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final SurfaceView surface=(SurfaceView)findViewById(R.id.show);
        //��ʼ��SurfaceHolder����
        holder=surface.getHolder();
        paint=new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        Button sin=(Button)findViewById(R.id.sin);
        Button cos=(Button)findViewById(R.id.cos);
        OnClickListener listener=(new OnClickListener() {
			
			public void onClick(final View source) {
				// TODO Auto-generated method stub
				drawBack(holder);
				cx=X_OFFSET;
				if(task!=null)
				{task.cancel();}
				task=new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int cy=source.getId()==R.id.sin?
								centerY-(int)(100*Math.sin((cx-5)*2*Math.PI/300))
								:centerY-(int)(100*Math.cos((cx-5)*2*Math.PI/300));
						Canvas canvas=holder.lockCanvas(new Rect(cx,cy-4,cx+4,cy+4));
						canvas.drawPoint(cx,cy,paint);
						cx++;
						if(cx>WIDTH){
							task.cancel();
							task=null;
						}
						holder.unlockCanvasAndPost(canvas);
					}
				};
				timer.schedule(task, 0,30);
			}
		});
        sin.setOnClickListener(listener);
        cos.setOnClickListener(listener);
        
        holder.addCallback(new Callback() {
        	public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){
        		drawBack(holder);
        	}
        	public void surfaceCreated(final SurfaceHolder myHolder){
        		
        	}
			@Override
			public void surfaceDestroyed(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				timer.cancel();
			}
		});
    }
	private void drawBack(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Canvas canvas=holder.lockCanvas();
		//���ư�ɫ����
		canvas.drawColor(Color.WHITE);
		Paint p=new Paint();
		p.setColor(Color.BLACK);
		p.setStrokeWidth(2);
		//����������
		canvas.drawLine(X_OFFSET, centerY, WIDTH, centerY, p);
		canvas.drawLine(X_OFFSET, 40, X_OFFSET, HEIGHT, p);
		holder.unlockCanvasAndPost(canvas);
		holder.lockCanvas(new Rect(0,0,0,0));
		holder.unlockCanvasAndPost(canvas);
	}


   
}
