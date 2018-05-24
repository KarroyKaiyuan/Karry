package com.example.test142;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

	private Button login_Button;
	private View moreHideBottomView,input2;
	private boolean mShowBottom=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		login_Button=(Button)findViewById(R.id.buton1);
		login_Button.setOnClickListener(this);
		moreHideBottomView=findViewById(R.id.morehidebottom);
		input2=findViewById(R.id.input2);
		input2.setOnClickListener(this);
	}
	public void showBottom(boolean bShow){
		if(bShow){
			moreHideBottomView.setVisibility(View.GONE);
			mShowBottom=true;
		}else{
			moreHideBottomView.setVisibility(View.VISIBLE);
			mShowBottom=false;
		}
	}
	public void onClick(View v){
		switch(v.getId()){
		case R.id.input2:
			showBottom(!mShowBottom);
			break;
			default:break;
		}
	}
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

	

}
