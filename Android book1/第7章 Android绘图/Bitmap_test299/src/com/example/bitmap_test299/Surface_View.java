package com.example.bitmap_test299;

import java.io.InputStream;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Surface_View extends SurfaceView {
	//����surface�Ľ�ڣ��ṩ�˿���surface�Ĵ�С��ʽ������
	private SurfaceHolder surfaceHolder;
	private Canvas canvas=null;
	//x,y�û�������Ļʱ����
	private float x=0,y=0;
	private Bitmap bitmap=null;
	public Surface_View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//��ȡSurfaceHolder��
		surfaceHolder=this.getHolder();
		//������Ļ�ı��ֿ���״̬
		this.setKeepScreenOn(true);
		//��ȡ��Դ�ļ�res
		Resources res=getResources();
		//��ȡλͼ��Դ�ļ���������
		InputStream inputStream=res.openRawResource(R.drawable.a9);
		//�����ɻ��Ƶ�λͼ����
		BitmapDrawable bitmapDrawable=new BitmapDrawable(inputStream);
		//ͨ���ɻ���λͼ����õ�λͼ����
		bitmap=bitmapDrawable.getBitmap();
		
	}
	//����λͼ
	private void onDraw(){
		try{
			//��������
			canvas=surfaceHolder.lockCanvas();
			//����canvas��������Ϊ��ɫ
			canvas.drawColor(Color.GREEN);
			//�ڻ����ϻ�ͼ����λͼ�����������ڴ�����λ��
			canvas.drawBitmap(bitmap, x-bitmap.getWidth()/2,y-bitmap.getHeight()/2, null);
		}catch( Exception ex){}
		finally{
			if(canvas!=null) //������������ʾ����ͼƬ
			surfaceHolder.unlockCanvasAndPost(canvas);
			}
		}
	//�����¼�
	public boolean onTouchEvent(MotionEvent event){
		x=event.getX();
		y=event.getY();
		onDraw();
		return true;
	}
	}


