package com.example.test227;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {

	ImageView myImageView;
	Bitmap myBmp,newBmp;
	int bmpWidth,bmpHeight;
	SeekBar seekbarRotate;
	float rotAngle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myImageView=(ImageView)findViewById(R.id.imageView1);
		myBmp=BitmapFactory.decodeResource(getResources(), R.drawable.a8);	//由Resource载入图像
		bmpWidth=myBmp.getWidth();
		bmpHeight=myBmp.getHeight();
		Matrix matrix=new Matrix();//实例化maxtrix
		matrix.postScale(1.5F, 1.5F);//设定的matrix属性x，y缩放比例为1.5
		matrix.postRotate(45.0F);//顺时针旋转45°
		newBmp=Bitmap.createBitmap(myBmp,0,0,bmpWidth,bmpHeight,matrix,true);
		
		/*Bitmap createBitmap (Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter)
		sourceBitmap: The bitmap we are subsetting  产生子位图的源位图；
		x int: The x coordinate of the first pixel in source 子位图第一个像素在源位图的X坐标
		y int: The y coordinate of the first pixel in source 子位图第一个像素在源位图的y坐标
		width int: The number of pixels in each row 子位图每一行的像素个数
		height int: The number of rows 子位图的行数
		m Matrix: Optional matrix to be applied to the pixels 对像素值进行变换的可选矩阵
		filter boolean: true if the source should be filtered. Only applies if the matrix contains more than just translation. 
		如果为true，源图要被过滤。该参数仅在matrix包含了超过一个翻转才有效//		
		*/
		seekbarRotate=(SeekBar)findViewById(R.id.seekBar1);
		seekbarRotate.setOnSeekBarChangeListener(onRotate);
		
	}
	private SeekBar.OnSeekBarChangeListener onRotate=new SeekBar.OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProgressChanged(SeekBar seekBar1, int process, boolean fromUser) {
			// TODO Auto-generated method stub
			Matrix m=new Matrix();
			m.postRotate((float)process*1.2F);
			newBmp=Bitmap.createBitmap(myBmp,0,0,bmpWidth,bmpHeight,m,true);
			myImageView.setImageBitmap(newBmp);
			
		}
		
		

	};
	
	

}
