package com.example.test210;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private int[] imageId=new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,
			R.drawable.a4,R.drawable.a5};
	private ImageSwitcher imageSwitcher;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Gallery gallery=(Gallery)findViewById(R.id.gallery1);//��ȡ���
		imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher1);
		//���ö���Ч��
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				this, android.R.anim.fade_in));
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				this, android.R.anim.fade_out));//���õ�������
		imageSwitcher.setFactory(new ViewFactory(){

			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				//ʵ����һ��imageView��Ķ���
				ImageView imageView=new ImageView(MainActivity.this);
				//���ñ����ݺ�Ⱦ�������ͼ��
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageView;
			}});
		//ʹ��baseAdapterָ��Ҫ��ʾ�����ݷ�
		BaseAdapter adapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ImageView imageView;//����һ������
				if(convertView==null){
					imageView=new ImageView(MainActivity.this);//ʵ��������
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);//�������ŷ�ʽ
					imageView.setPadding(5, 0, 5, 0);//shezhi�ڱ߾�
				}else
				{imageView=(ImageView)convertView;}
				imageView.setImageResource(imageId[position]);//Ϊimageview����Ҫ��ʾ��ͼƬ
				return imageView;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageId.length;
			}
		};
		gallery.setAdapter(adapter);//����������gallery�����
		gallery.setSelection(imageId.length/2);//���м��ͼƬѡ��
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				imageSwitcher.setImageResource(imageId[position]);//��ʾѡ�е�ͼƬ
				
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		
		
	}

	

}
