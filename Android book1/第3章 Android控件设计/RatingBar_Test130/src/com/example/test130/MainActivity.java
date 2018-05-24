package com.example.test130;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	RatingBar rb;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		rb=(RatingBar)this.findViewById(R.id.ratingBar1);
		tv=(TextView)this.findViewById(R.id.textView1);
		rb.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar,
					float rating, boolean fromUser) {
				// TODO Auto-generated method stub
				tv.setText("你的打分"+(float)rb.getRating()+"分");
			}
		});
	}

	

}
