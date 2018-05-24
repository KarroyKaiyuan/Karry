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
		myBmp=BitmapFactory.decodeResource(getResources(), R.drawable.a8);	//��Resource����ͼ��
		bmpWidth=myBmp.getWidth();
		bmpHeight=myBmp.getHeight();
		Matrix matrix=new Matrix();//ʵ����maxtrix
		matrix.postScale(1.5F, 1.5F);//�趨��matrix����x��y���ű���Ϊ1.5
		matrix.postRotate(45.0F);//˳ʱ����ת45��
		newBmp=Bitmap.createBitmap(myBmp,0,0,bmpWidth,bmpHeight,matrix,true);
		
		/*Bitmap createBitmap (Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter)
		sourceBitmap: The bitmap we are subsetting  ������λͼ��Դλͼ��
		x int: The x coordinate of the first pixel in source ��λͼ��һ��������Դλͼ��X����
		y int: The y coordinate of the first pixel in source ��λͼ��һ��������Դλͼ��y����
		width int: The number of pixels in each row ��λͼÿһ�е����ظ���
		height int: The number of rows ��λͼ������
		m Matrix: Optional matrix to be applied to the pixels ������ֵ���б任�Ŀ�ѡ����
		filter boolean: true if the source should be filtered. Only applies if the matrix contains more than just translation. 
		���Ϊtrue��ԴͼҪ�����ˡ��ò�������matrix�����˳���һ����ת����Ч//		
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
