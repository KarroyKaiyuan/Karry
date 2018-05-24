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
	Bitmap cacheBitmap=null;//定义一个内存中图片，该图片将作为缓存区
	Canvas cacheCanvas=null;//定义cacheBitmap上的canvas对象
    //构造方法
	public drawView(Context context, AttributeSet set) {
		super(context, set);
		// TODO Auto-generated constructor stub
		view_width=context.getResources().getDisplayMetrics().widthPixels;//获取屏幕的宽度
		view_height=context.getResources().getDisplayMetrics().heightPixels;
		System.out.println(view_width+"*"+view_height);
		//创建一个与该view相同大小的缓存区
		cacheBitmap=Bitmap.createBitmap(view_width, view_height, Config.ARGB_8888);
		cacheCanvas=new Canvas();
		path=new Path();
		cacheCanvas.setBitmap(cacheBitmap);//在cachecanvas上绘制cacheBitmap
		paint=new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);//默认画笔为红色
		//设置画笔风格
		paint.setStyle(Paint.Style.STROKE);//设置填充方式为描边
		paint.setStrokeJoin(Paint.Join.ROUND);//设置笔刷的图形样式
		paint.setStrokeCap(Paint.Cap.ROUND);//画笔转弯处的链接风格
		paint.setStrokeWidth(1);//默认笔触宽度为1像素
		paint.setAntiAlias(true);//使用抗锯齿功能
		paint.setDither(true);//使用抖动效果
	}
		//重写onDraw（）方法
	public void onDraw(Canvas canvas){
		canvas.drawColor(0xFFFFFFFF);//背景颜色
		Paint bmpPaint=new Paint();//采用默认设置创建一个画笔
		canvas.drawBitmap(cacheBitmap, 0,0, bmpPaint);//绘制cacheBitmap
		canvas.drawPath(path,paint);//绘制路径
		canvas.save(Canvas.ALL_SAVE_FLAG);//保存canvas的状态
		canvas.restore();//恢复canvas之前保存的状态，防止保存后对canvas执行的操作对后续的操作有影响
		
	}
	public boolean onTouchEvent(MotionEvent event){
		
		//获取触摸事件的发生位置
		float x=event.getX();
		float y=event.getY();
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			path.moveTo(x, y);//将绘图的起始点移动（x，y）坐标点位置
			preX=x;
			preY=y;
			break;
		case MotionEvent.ACTION_MOVE:
			float dx=Math.abs(x-preX);
			float dy=Math.abs(y-preY);
			if(dx>=5||dy>=5){//判断是否在允许的范围内
				path.quadTo(preX,preY,(x+preX)/2,(y+preY)/2);
				preX=x;
				preY=y;	
			}
			break;
		case MotionEvent.ACTION_UP:
			cacheCanvas.drawPath(path, paint);//绘图路径
			path.reset();
			break;
		}
		invalidate();
		return true;//返回true表明处理方法已经处理了该事件
		
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
		File file=new File("/sdcard/pictures/"+fileName+".png");//创建文件对象
		file.createNewFile();//创建一个新文件
		FileOutputStream fileOS=new FileOutputStream(file);//创建一个文件输出流
		//将绘图内容压缩为png格式输出到输出流对象
		cacheBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOS);
		fileOS.flush();//将缓冲区的数据全部写出到输出流中
		fileOS.close();//关闭文件输出流对象
		
		// TODO Auto-generated method stub
		
	}

}
