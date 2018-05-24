package com.example.test98;

import java.util.ArrayList;

import android.app.Activity;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.CheckedTextView;

public class MainActivity extends Activity {
	private CheckedTextView checkedTextViewMul1;
	private CheckedTextView checkedTextViewMul2;
	private CheckedTextView checkedTextViewMul3;
	private CheckedTextView checkedTextViewMul4;
	private CheckedTextView checkedTextViewMul5;
	private CheckedTextView checkedTextViewSinglea;
	private CheckedTextView checkedTextViewSingleb;
	private CheckedTextView checkedTextViewSinglec;
	private CheckedTextView checkedTextViewSingled;
	private Button getMulCheckedTextValue;
	private Button getSingleCheckedTextValue;
	private ArrayList<Integer> mulCheckedTextViewIdArray=new ArrayList();
	private ArrayList<Integer> singleCheckedTextViewIdArray=new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getMulCheckedTextValue=(Button)this.findViewById(R.id.button1);
		getSingleCheckedTextValue=(Button)this.findViewById(R.id.button2);
		checkedTextViewMul1=(CheckedTextView)this.findViewById(R.id.checkedTextView1);
		   checkedTextViewMul1.setChecked(true);
		checkedTextViewMul2=(CheckedTextView)this.findViewById(R.id.checkedTextView2);
		   checkedTextViewMul1.setChecked(true);
		checkedTextViewMul3=(CheckedTextView)this.findViewById(R.id.checkedTextView3);
		   checkedTextViewMul1.setChecked(true);
		checkedTextViewMul4=(CheckedTextView)this.findViewById(R.id.checkedTextView4);
		   checkedTextViewMul1.setChecked(true);
		checkedTextViewMul5=(CheckedTextView)this.findViewById(R.id.checkedTextView5);
		   checkedTextViewMul1.setChecked(true);
		mulCheckedTextViewIdArray.add(checkedTextViewMul1.getId());
		mulCheckedTextViewIdArray.add(checkedTextViewMul2.getId());
		mulCheckedTextViewIdArray.add(checkedTextViewMul3.getId());
		mulCheckedTextViewIdArray.add(checkedTextViewMul4.getId());
		mulCheckedTextViewIdArray.add(checkedTextViewMul5.getId());
		OnClickListener checkedTextViewMulListenerRef=new OnClickListener(){
		
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				((CheckedTextView)arg0).toggle();
			}
		};
		checkedTextViewMul1.setOnClickListener( checkedTextViewMulListenerRef);
		checkedTextViewMul2.setOnClickListener( checkedTextViewMulListenerRef);
		checkedTextViewMul3.setOnClickListener( checkedTextViewMulListenerRef);
		checkedTextViewMul4.setOnClickListener( checkedTextViewMulListenerRef);
		checkedTextViewMul5.setOnClickListener( checkedTextViewMulListenerRef);
		getMulCheckedTextValue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<mulCheckedTextViewIdArray.size();i++){
					CheckedTextView findCheckedTextViewRef=(CheckedTextView)MainActivity.
							this.findViewById(mulCheckedTextViewIdArray.get(i));
					if(findCheckedTextViewRef.isChecked()==true){
						Log.v("选中的checkbox是", ""+findCheckedTextViewRef.getTag());
					}
				}
			}
		});
		
		checkedTextViewSinglea=(CheckedTextView)this.findViewById(R.id.checkedTextViewa);
		checkedTextViewSingleb=(CheckedTextView)this.findViewById(R.id.checkedTextViewb);
		checkedTextViewSinglec=(CheckedTextView)this.findViewById(R.id.checkedTextViewc);
		checkedTextViewSingled=(CheckedTextView)this.findViewById(R.id.checkedTextViewd);
	
		singleCheckedTextViewIdArray.add(checkedTextViewSinglea.getId());
		singleCheckedTextViewIdArray.add(checkedTextViewSingleb.getId());
		singleCheckedTextViewIdArray.add(checkedTextViewSinglec.getId());
		singleCheckedTextViewIdArray.add(checkedTextViewSingled.getId());
		OnClickListener checkedTextViewSingleListenerRef=new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<singleCheckedTextViewIdArray.size();i++){
					if(singleCheckedTextViewIdArray.get(i).intValue()!=((CheckedTextView)arg0)
							.getId()){
						((CheckedTextView)MainActivity.this.findViewById(singleCheckedTextViewIdArray
								.get(i))).setChecked(false);
					}else{
						((CheckedTextView)MainActivity.this.findViewById(singleCheckedTextViewIdArray
								.get(i))).setChecked(true);
					}
				}
			}
		};
		checkedTextViewSinglea.setOnClickListener(checkedTextViewSingleListenerRef);
		checkedTextViewSingleb.setOnClickListener(checkedTextViewSingleListenerRef);
		checkedTextViewSinglec.setOnClickListener(checkedTextViewSingleListenerRef);
		checkedTextViewSingled.setOnClickListener(checkedTextViewSingleListenerRef);
		getSingleCheckedTextValue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<singleCheckedTextViewIdArray.size();i++){
					CheckedTextView eachCheckTextViewRef=((CheckedTextView)MainActivity.
							this.findViewById(singleCheckedTextViewIdArray.get(i)));
					if(eachCheckTextViewRef.isChecked()==true){
						Log.v("单选选中了",""+eachCheckTextViewRef.getTag().toString());
					}
				}
			}
		});
	}

	
}
