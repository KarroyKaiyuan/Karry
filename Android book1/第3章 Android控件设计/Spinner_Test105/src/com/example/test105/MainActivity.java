package com.example.test105;
import android.R.string;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	final static int WRAP_COETNT=-2;
	//������Դ��ͼƬid������
	int[] drawableIds={R.drawable.a2,R.drawable.a3,R.drawable.a4};
	//������Դ�ַ���id������
	int[] msgIds={R.string.zq,R.string.lq,R.string.pq};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Spinner sp=(Spinner)this.findViewById(R.id.spinner1);
		BaseAdapter ba=new BaseAdapter() {
			
			@SuppressLint("ResourceAsColor")
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				//��̬����ÿ���������Ӧ��View��ÿ��������View��LinearLayout�а�����һ��Imageview��һ��Textview����
				//��ʼ��LinearLayout
				LinearLayout b=new LinearLayout(MainActivity.this);
				b.setOrientation(LinearLayout.HORIZONTAL);
				//��ʼ��Imageview
				ImageView ii=new ImageView(MainActivity.this);
				ii.setImageDrawable((getResources().getDrawable(drawableIds[position])));
				b.addView(ii);
				//��ʼ��Textview
				TextView tv=new TextView(MainActivity.this);
				tv.setText(""+getResources().getText(msgIds[position]));
				tv.setTextColor(R.color.black);
				tv.setTextSize(24);
				b.addView(tv);
				return b;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 3;
			}
		};
		//Ϊspinner��������������
		sp.setAdapter(ba);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//��ȡ������textview
				TextView tv=(TextView)findViewById(R.id.textView1);
				//��ȡ��ǰѡ�е�ѡ���Ӧ��linearlayout
				LinearLayout ll=(LinearLayout)view;
				//��ȡ���е�textview
				TextView tvn=(TextView)ll.getChildAt(1);
				//��stringbuilder��̬������Ϣ
				StringBuilder sb=new StringBuilder();
				sb.append(getResources().getText(R.string.ys));
				sb.append(":");
				sb.append(tvn.getText());
				//��Ϣ���ý�פ����
				tv.setText(sb.toString());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	

}
