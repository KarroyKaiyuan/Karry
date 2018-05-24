package com.example.test127;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {
	
	
	private SeekBar seekBar;
	private TextView textView1,textView2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		seekBar=(SeekBar)this.findViewById(R.id.seekBar1);
		textView1=(TextView)this.findViewById(R.id.textView1);
		textView2=(TextView)this.findViewById(R.id.textView2);
		seekBar.setOnSeekBarChangeListener(this);//����¼�����
	}
	//�϶�zhong
	public void onProgressChanged(SeekBar seekBar,int progress,
			boolean fromUser){
		this.textView1.setText("��ǰֵ"+progress);
	}
	//��ʼ�϶�
	public void onStartTrackingTouch(SeekBar seekBar){
		this.textView2.setText("�϶��С���");
	}
    
	public void onStopTrackingTouch(SeekBar seekBar){
		this.textView2.setText("�϶����");
	}
}
