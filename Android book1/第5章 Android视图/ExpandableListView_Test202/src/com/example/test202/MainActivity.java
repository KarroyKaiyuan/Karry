package com.example.test202;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView text=null;
	private int[] image={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
	private String[] item={"��Դ1","��Դ2","��Դ3","��Դ4"};
	private String[][] ability={{"�ɰ�,����"},{"����","ѩ��","����","���"},{"����","����"},{"����"}};
	private ExpandableListView expandableListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text=(TextView)findViewById(R.id.text);
		expandableListView=(ExpandableListView)findViewById(R.id.expandableListView1);
		ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
			//��������Ŀ�ĵ����¼�
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				String str=item[groupPosition]+
						ability[groupPosition][childPosition];
				updateText(str);
				return true;
			}
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}
			
			
			
		   //���ظ���Ŀ����ͼ�ؼ�
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, 
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll=new LinearLayout(MainActivity.this);
				ll.setOrientation(0);//������ʽΪHorizontal
				ll.setPadding(50,0, 0, 0);//���ò�����ҳ�߾�Ϊ50����
				ImageView imageView=new ImageView(MainActivity.this);
				imageView.setImageResource(image[groupPosition]);//����imageҪ��ʾ�Ķ����id
				ll.addView(imageView);
				TextView textView=getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
				
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return ability.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return item[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return ability[groupPosition].length;
			}
			public View getChildView(int groupPosition,int childPosition,
					boolean isLastChild, 
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView textView=getTextView();
				textView.setText(getChild(groupPosition,childPosition).toString());
				return textView;
			}
			
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return ability[groupPosition][childPosition];
			}
			private TextView getTextView() {
				// TODO Auto-generated method stub
				AbsListView.LayoutParams lp=new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.FILL_PARENT,64);
				TextView textView=new TextView(MainActivity.this);
				textView.setLayoutParams(lp);
				textView.setPadding(20, 0, 0, 0);
				textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
				return textView;
			}
		};
		expandableListView.setAdapter(adapter);
	}
	
	private void updateText(String string) {
		// TODO Auto-generated method stub
		text.setText(string);
	}


}
