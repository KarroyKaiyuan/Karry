package com.example.canvasimage_test308;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener,OnClickListener{

	private ImageView image;
	private Paint paint;
	private Canvas canvas;
	private Bitmap bitmap;
	private Bitmap alterBitmap;
	private Button choose;
	private Button save;
	private final static int RESULT=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        image=(ImageView)findViewById(R.id.imageView1);
        choose=(Button)findViewById(R.id.button1);
        save=(Button)findViewById(R.id.button2);
        image.setOnTouchListener(this);
        choose.setOnClickListener(this);
        save.setOnClickListener(this);
    }
	private float downx=0;
	private float downy=0;
	private float upx=0;
	private float upy=0;
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action=event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			downx=event.getX();
			downy=event.getY();
			break;

		case MotionEvent.ACTION_MOVE:
			//Â·¾¶»­°å
			upx=event.getX();
			upy=event.getY();
			canvas.drawLine(downx, downy, upx, upy, paint);
			image.invalidate();
			downx=upx;
			downy=upy;
			break;
		case MotionEvent.ACTION_UP:
			//Ö±Ïß»­°å
			upx=event.getX();
			upy=event.getY();
			canvas.drawLine(downx, downy, upx, upy, paint);
			image.invalidate();
			break;
			
		default:
			break;
		}
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0==choose){
			Intent intent=new Intent(Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, RESULT);
		}
		else if(arg0==save){
			if(alterBitmap!=null){
				try{
					Uri imageUri=getContentResolver().insert(
							Media.EXTERNAL_CONTENT_URI,new ContentValues());
					OutputStream outputStream=getContentResolver().openOutputStream(imageUri);
					alterBitmap.compress(CompressFormat.PNG, 90, outputStream);
					Toast.makeText(getApplicationContext(), "save!", Toast.LENGTH_SHORT).show();
				} catch(FileNotFoundException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Uri imageFileUri=data.getData();
			Display display=getWindowManager().getDefaultDisplay();
			float dw=display.getWidth();
			float dh=display.getHeight();
			try {
				BitmapFactory.Options options=new BitmapFactory.Options();
				options.inJustDecodeBounds=true;
				bitmap=BitmapFactory.decodeStream(
						getContentResolver().openInputStream(imageFileUri),null,options);
				int heightRatio=(int)Math.ceil(options.outHeight/dh);
				int widthRatio=(int)Math.ceil(options.outWidth/dw);
				if(heightRatio>1&&widthRatio>1){
				if(heightRatio>widthRatio){
					options.inSampleSize=heightRatio;
				}else{
					options.inSampleSize=widthRatio;
				     }
				}
				options.inJustDecodeBounds=false;
				bitmap=BitmapFactory.decodeStream(
						getContentResolver().openInputStream(imageFileUri),null,options);
				alterBitmap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
				canvas=new Canvas(alterBitmap);
				paint=new Paint();
				paint.setColor(Color.GREEN);
				paint.setStrokeWidth(10);
				Matrix matrix=new Matrix();
				canvas.drawBitmap(bitmap, matrix, paint);
				image.setImageBitmap(alterBitmap);
				image.setOnTouchListener(this);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


    
}
