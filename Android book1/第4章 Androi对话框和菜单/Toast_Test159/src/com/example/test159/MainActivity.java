package com.example.test159;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Handler handler=new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViewById(R.id.btnSimpleToast).setOnClickListener(this);
		findViewById(R.id.btnSimpleToastWithCustomPosition).setOnClickListener(this);
		findViewById(R.id.btnSimpleToastWithImage).setOnClickListener(this);
		findViewById(R.id.btnCustomToast).setOnClickListener(this);
		findViewById(R.id.btnRunToastFromOtherThread).setOnClickListener(this);
	}
	public void showToast(){
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"我来自其他线程",Toast.LENGTH_SHORT).show();
			}
		});
	}
	public void onClick(View v){
		Toast toast=null;
		switch (v.getId()) {
		case R.id.btnSimpleToast:
			Toast.makeText(getApplicationContext(),
					"默认Toast样式", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnSimpleToastWithCustomPosition:
			toast=Toast.makeText(getApplicationContext(),
					"自定义位置Toast", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			break;
		case R.id.btnSimpleToastWithImage:
			toast=Toast.makeText(getApplicationContext(),
					"带图片的Toast", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView=(LinearLayout)toast.getView();
			ImageView imageCodeProject=new ImageView(getApplicationContext());
			imageCodeProject.setImageResource(R.drawable.a2);
			toastView.addView(imageCodeProject,0);
			toast.show();
			break;
		case R.id.btnCustomToast:
			LayoutInflater inflater=getLayoutInflater();
			View layout=inflater.inflate(R.layout.custom, 
					(ViewGroup)findViewById(R.id.llToast));
			ImageView image=(ImageView)layout.findViewById(R.id.imageView1);
			image.setImageResource(R.drawable.a2);
			TextView title=(TextView)layout.findViewById(R.id.textView1);
			title.setText("Attention");
			TextView text=(TextView)layout.findViewById(R.id.textView2);
			title.setText("完全自定义的Toast");
			toast=new Toast(getApplicationContext());
			toast.setGravity(Gravity.RIGHT|Gravity.TOP, 12, 40);
			toast.setDuration(Toast.LENGTH_LONG);
			toast.setView(layout);
			toast.show();
			break;
		case R.id.btnRunToastFromOtherThread:
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					showToast();
				}
			}).start();
			break;
		}
	}

}