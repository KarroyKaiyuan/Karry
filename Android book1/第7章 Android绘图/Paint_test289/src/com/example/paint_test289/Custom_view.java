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
		//������ɫ��
		Paint paint_blue=new Paint();
		paint_blue.setColor(Color.BLUE);
		paint_blue.setStyle(Style.STROKE);
		paint_blue.setStrokeWidth(10);
		canvas.drawCircle(110, 150, 60, paint_blue);
		//���ƻ�ɫ��
		Paint paint_yellow=new Paint();
		paint_yellow.setColor(Color.YELLOW);
		paint_yellow.setStyle(Style.STROKE);
		paint_yellow.setStrokeWidth(10);
		canvas.drawCircle((float)175.5,210, 60, paint_yellow);
		//���ƺ�ɫ��
		Paint paint_black=new Paint();
		paint_black.setColor(Color.BLACK);
		paint_black.setStyle(Style.STROKE);
		paint_black.setStrokeWidth(10);
		canvas.drawCircle(245, 150, 60, paint_black);
		//������ɫ��
		Paint paint_green=new Paint();
		paint_green.setColor(Color.GREEN);
		paint_green.setStyle(Style.STROKE);
		paint_green.setStrokeWidth(10);
		canvas.drawCircle(311, 210, 60, paint_green);
		//���ƺ�ɫ��
		Paint paint_red=new Paint();
		paint_red.setColor(Color.RED);
		paint_red.setStyle(Style.STROKE);
		paint_red.setStrokeWidth(10);
		canvas.drawCircle(380, 150, 60, paint_red);
		
		//�����ַ���
		Paint paint_string=new Paint();
		paint_string.setColor(Color.BLUE);
		paint_string.setStyle(Style.STROKE);
		paint_string.setTextSize(20);
		canvas.drawText("Welcome to Beijing!", 245, 310, paint_string);
		//����ֱ��
		Paint paint_line=new Paint();
		paint_line.setColor(Color.BLUE);
		paint_line.setStyle(Style.STROKE);
		canvas.drawLine(240,310,425,310,paint_line);
		//�����ַ���
		Paint paint_text=new Paint();
		paint_text.setColor(Color.BLUE);
		paint_text.setTextSize(20);
		canvas.drawText("������ӭ����", 275, 330, paint_text);
		//���Ƹ���ͼƬ
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher),35, 340,paint_line);
		
		
	}

}
