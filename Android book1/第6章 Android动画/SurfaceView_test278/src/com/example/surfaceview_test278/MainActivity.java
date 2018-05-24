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

	private SurfaceHolder holder;//SurfaceHolder����ά��SurfaceView�ϻ��Ƶ�����
	private Paint paint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        paint=new Paint();
        //��ȡSurfaceViewʵ��
        SurfaceView surface=(SurfaceView)findViewById(R.id.surfaceView1);
        //��ʼ��SurfaceHolder�Ķ���
        holder=surface.getHolder();
        holder.addCallback(new Callback() {
        	//��surface��Ҫ������ʱ�ص��÷���
        	public void surfaceDestroyed(SurfaceHolder holder){
        		
        	}
        	//��������ʱ�ص��÷���
        	@Override
			public void surfaceCreated(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				//��������Surfaceview
        		Canvas canvas=holder.lockCanvas();
        		//��ȡ������Դ
        		Bitmap bitmap=BitmapFactory.decodeResource(
        				MainActivity.this.getResources(),R.drawable.a4);
        		//���Ʊ���
        		canvas.drawBitmap(bitmap,0,0,null);
        		//������ɣ��ͷ�Ļ���ύ�޸�
        		holder.unlockCanvasAndPost(canvas);
        		//���������Σ�����覴�lockCanvas���ڸ�
        		holder.lockCanvas(new Rect(0,0,0,0));
        		holder.unlockCanvasAndPost(canvas);
        		holder.lockCanvas(new Rect(0,0,0,0));
        		holder.unlockCanvasAndPost(canvas);
        	}
        	//��һ��surface�ĸ�ʽ���С�����ı�ʱ�ص��÷���
        	public void surfaceChanged(SurfaceHolder holder,int format,
        			int width,int height){
        		
        	}
			
		});
        surface.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				//ֻ�������¼�
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					int cx=(int)event.getX();
					int cy=(int)event.getY();
					//����SURfaceview�ľֲ�����ֻ���¾ֲ�����
					Canvas canvas=holder.lockCanvas(
							new Rect(cx-60,cy-60,cx+60,cy+60));
					//����canvas�ĵ�ǰ״̬
					canvas.save();
					//��ת����
					canvas.rotate(30,cx,cy);
					paint.setColor(Color.RED);
					//���ƺ�ɫ����
					canvas.drawRect(cx-40,cy-40,cx,cy,paint);
					//�ָ�canvas֮ǰ�ı���״̬
					canvas.restore();
					paint.setColor(Color.GREEN);
					//������ɫ�ķ���
					canvas.drawRect(cx,cy,cx+40,cy+40,paint);
					//������ɣ��ͷ�Ļ�����ύ�޸�
					holder.unlockCanvasAndPost(canvas);
				}
				return false;
			}
		});
    }
}
