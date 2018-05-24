package com.example.paint_test289;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class Custom_view extends View {

	public Custom_view(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public void onDraw(Canvas canvas){
		//绘制蓝色环
		Paint paint_blue=new Paint();
		paint_blue.setColor(Color.BLUE);
		paint_blue.setStyle(Style.STROKE);
		paint_blue.setStrokeWidth(10);
		canvas.drawCircle(110, 150, 60, paint_blue);
		//绘制黄色环
		Paint paint_yellow=new Paint();
		paint_yellow.setColor(Color.YELLOW);
		paint_yellow.setStyle(Style.STROKE);
		paint_yellow.setStrokeWidth(10);
		canvas.drawCircle((float)175.5,210, 60, paint_yellow);
		//绘制黑色环
		Paint paint_black=new Paint();
		paint_black.setColor(Color.BLACK);
		paint_black.setStyle(Style.STROKE);
		paint_black.setStrokeWidth(10);
		canvas.drawCircle(245, 150, 60, paint_black);
		//绘制绿色环
		Paint paint_green=new Paint();
		paint_green.setColor(Color.GREEN);
		paint_green.setStyle(Style.STROKE);
		paint_green.setStrokeWidth(10);
		canvas.drawCircle(311, 210, 60, paint_green);
		//绘制红色环
		Paint paint_red=new Paint();
		paint_red.setColor(Color.RED);
		paint_red.setStyle(Style.STROKE);
		paint_red.setStrokeWidth(10);
		canvas.drawCircle(380, 150, 60, paint_red);
		
		//绘制字符串
		Paint paint_string=new Paint();
		paint_string.setColor(Color.BLUE);
		paint_string.setStyle(Style.STROKE);
		paint_string.setTextSize(20);
		canvas.drawText("Welcome to Beijing!", 245, 310, paint_string);
		//绘制直线
		Paint paint_line=new Paint();
		paint_line.setColor(Color.BLUE);
		paint_line.setStyle(Style.STROKE);
		canvas.drawLine(240,310,425,310,paint_line);
		//绘制字符串
		Paint paint_text=new Paint();
		paint_text.setColor(Color.BLUE);
		paint_text.setTextSize(20);
		canvas.drawText("北京欢迎您！", 275, 330, paint_text);
		//绘制福娃图片
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher),35, 340,paint_line);
		
		
	}

}
