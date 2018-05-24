package com.example.viewfactory_test268;

import java.util.ArrayList;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	//����һ������������ʾÿ����ʵ��Ӧ�ó�����
	public static final int NUMBER_PER_SCREEN=12;
	//����Ӧ�ó�����ڲ���
	public static class DataItem{
		//Ӧ�ó������ơ���ͼ��
		public String dataName;
		public Drawable drawable;
	}
	//����ϵͳ����Ӧ�ó����list'����
	private ArrayList<DataItem> items=new ArrayList<DataItem>();
	//��¼��ǰ������ʾ�ڼ����ĳ���
	private int screenNo=-1;
	private int screenCount;
	ViewSwitcher switcher;
	//����layoutInflater����
	LayoutInflater inflater;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        inflater=LayoutInflater.from(MainActivity.this);
        //����һ������40��Ԫ�ص�list���ϣ�����ģ�����40����Ӧ�ó���
        for(int i=0;i<40;i++){
        	String label=""+i;
        	Drawable drawable=getResources().getDrawable(R.drawable.ic_launcher);
        	DataItem item=new DataItem();
        	item.dataName=label;
        	item.drawable=drawable;
        	items.add(item);
        }
        //����Ӧ�ó�����ռ�õ�����������Ӧ�ó����������������NUMBER_PER_SCREEN��������������Ļ��
        //���������������������ǽ����1
        screenCount=items.size()%NUMBER_PER_SCREEN==0?
        		items.size()/NUMBER_PER_SCREEN:
        	items.size()/NUMBER_PER_SCREEN+1;
        switcher=(ViewSwitcher)findViewById(R.id.viewSwitcher1);
        switcher.setFactory(new ViewFactory() {
			//ʵ���Ͼ��Ƿ���һ��GridView���
			@Override
			public View makeView() {
				// ����R.layout.alidelistview�����ʵ���Ͼ���һ��GridView���
				return inflater.inflate(R.layout.slidelistview, null);
			}
		});
        //ҳ�����ʱ����ʾ��һ��
        next(null);
        
		}
    
    
    
	public  void next(View v) {
		// TODO Auto-generated method stub
		if(screenNo<screenCount-1){
			screenNo++;
			//ΪViewSwitcher�������ʾ�������ö���
			switcher.setInAnimation(this,R.anim.slide_in_right);
			//ΪViewSwitcher��������ع������ö���
			switcher.setOutAnimation(this,R.anim.slide_out_left);
			//������һ����Ҫ��ʾ��Gridview��Ӧ��adapter
			((GridView)switcher.getNextView()).setAdapter(adapter);
			//����ұ߰�ť����ʾ��һ����Ҳ��ͨ����ʰ�����ʾ��һ��
			switcher.showNext();
		}
	}
	
	public void prev(View v){
		// TODO Auto-generated method stub
		if(screenNo>0){
			screenNo--;
			//ΪViewSwitcher�������ʾ�������ö���
			switcher.setInAnimation(this,android.R.anim.slide_in_left);
			//ΪViewSwitcher��������ع������ö���
			switcher.setOutAnimation(this,android.R.anim.slide_out_right);
			//������һ����Ҫ��ʾ��Gridview��Ӧ��adapter
			((GridView)switcher.getNextView()).setAdapter(adapter);
			//����ұ߰�ť����ʾ��һ����Ҳ��ͨ����ʰ�����ʾ��һ��
			switcher.showPrevious();
		}
	}
	
	
	
	//��BaseAdapter����Ϊÿ����ʾ��GridView�ṩ�б���
	private BaseAdapter adapter=new BaseAdapter() {
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			//����Ѿ��������һ������Ӧ�ó����������������NUMBER_PER_SCREEN
			if(screenNo==screenCount-1&&items.size()%NUMBER_PER_SCREEN!=0)
			{
				//���һ����ʾ�ĳ�������Ϊ��NUMBER_PER_SCREEN����
				return items.size()%NUMBER_PER_SCREEN;
			}
			//����ÿ����ʾ������ΪNUMBER_PER_SCREEN
			return NUMBER_PER_SCREEN;
		}
		@Override
		public DataItem getItem(int position) {
			// TODO Auto-generated method stub
			//����screenNo�����position���б��������
			return items.get(screenNo*NUMBER_PER_SCREEN+position);
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view=convertView;
			if(convertView==null){
				//����R.layout.laelicon�����ļ�
				view=inflater.inflate(R.layout.labelicon, null);
			}
			//��ȡ�����ļ��е�imageview�������Ϊ֮����ͼ��
			ImageView imageView=(ImageView)view.findViewById(R.id.imageview);
			imageView.setImageDrawable(getItem(position).drawable);
			//��ȡ�����ļ��е�textview�������Ϊ֮�����ı�
			TextView textView=(TextView)view.findViewById(R.id.textview);
			textView.setText(getItem(position).dataName);
			return view;
		}
	};
	
	
    }
    
    

