package com.fs.drawview_double;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class drawView extends View {

	private int view_width=0;
	private int view_height=0;
	private float preX;
	private float preY;
	private Path path;
	public Paint paint=null;
	Bitmap cacheBitmap=null;//����һ���ڴ���ͼƬ����ͼƬ����Ϊ������
	Canvas cacheCanvas=null;//����cacheBitmap�ϵ�canvas����
    //���췽��
	public drawView(Context context, AttributeSet set) {
		super(context, set);
		// TODO Auto-generated constructor stub
		view_width=context.getResources().getDisplayMetrics().widthPixels;//��ȡ��Ļ�Ŀ��
		view_height=context.getResources().getDisplayMetrics().heightPixels;
		System.out.println(view_width+"*"+view_height);
		//����һ�����view��ͬ��С�Ļ�����
		cacheBitmap=Bitmap.createBitmap(view_width, view_height, Config.ARGB_8888);
		cacheCanvas=new Canvas();
		path=new Path();
		cacheCanvas.setBitmap(cacheBitmap);//��cachecanvas�ϻ���cacheBitmap
		paint=new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);//Ĭ�ϻ���Ϊ��ɫ
		//���û��ʷ��
		paint.setStyle(Paint.Style.STROKE);//������䷽ʽΪ���
		paint.setStrokeJoin(Paint.Join.ROUND);//���ñ�ˢ��ͼ����ʽ
		paint.setStrokeCap(Paint.Cap.ROUND);//����ת�䴦�����ӷ��
		paint.setStrokeWidth(1);//Ĭ�ϱʴ����Ϊ1����
		paint.setAntiAlias(true);//ʹ�ÿ���ݹ���
		paint.setDither(true);//ʹ�ö���Ч��
	}
		//��дonDraw��������
	public void onDraw(Canvas canvas){
		canvas.drawColor(0xFFFFFFFF);//������ɫ
		Paint bmpPaint=new Paint();//����Ĭ�����ô���һ������
		canvas.drawBitmap(cacheBitmap, 0,0, bmpPaint);//����cacheBitmap
		canvas.drawPath(path,paint);//����·��
		canvas.save(Canvas.ALL_SAVE_FLAG);//����canvas��״̬
		canvas.restore();//�ָ�canvas֮ǰ�����״̬����ֹ������canvasִ�еĲ����Ժ����Ĳ�����Ӱ��
		
	}
	public boolean onTouchEvent(MotionEvent event){
		
		//��ȡ�����¼��ķ���λ��
		float x=event.getX();
		float y=event.getY();
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			path.moveTo(x, y);//����ͼ����ʼ���ƶ���x��y�������λ��
			preX=x;
			preY=y;
			break;
		case MotionEvent.ACTION_MOVE:
			float dx=Math.abs(x-preX);
			float dy=Math.abs(y-preY);
			if(dx>=5||dy>=5){//�ж��Ƿ�������ķ�Χ��
				path.quadTo(preX,preY,(x+preX)/2,(y+preY)/2);
				preX=x;
				preY=y;	
			}
			break;
		case MotionEvent.ACTION_UP:
			cacheCanvas.drawPath(path, paint);//��ͼ·��
			path.reset();
			break;
		}
		invalidate();
		return true;//����true�����������Ѿ������˸��¼�
		
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
		paint.setStrokeWidth(50);
	}

	public void save() {
		// TODO Auto-generated method stub
		try {
			saveBitmap("myPicture");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println();
		}
	}
	private void saveBitmap(String fileName)throws IOException {
		File file=new File("/sdcard/pictures/"+fileName+".png");//�����ļ�����
		file.createNewFile();//����һ�����ļ�
		FileOutputStream fileOS=new FileOutputStream(file);//����һ���ļ������
		//����ͼ����ѹ��Ϊpng��ʽ��������������
		cacheBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOS);
		fileOS.flush();//��������������ȫ��д�����������
		fileOS.close();//�ر��ļ����������
		
		// TODO Auto-generated method stub
		
	}

}
