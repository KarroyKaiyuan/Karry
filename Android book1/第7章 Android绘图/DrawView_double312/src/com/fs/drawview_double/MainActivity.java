package com.fs.drawview_double;

import com.fs.drawview_double312.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    //����ѡ��˵�
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater=new MenuInflater(this);//ʵ����һ��Menuinflater����
    	inflater.inflate(R.menu.menu_item, menu);//�����˵��ļ�
    	return super.onCreateOptionsMenu(menu);
    }
    //���˵��ѡ����������Ӧ�Ĵ���
    public boolean onOptionsItemSelected(MenuItem item){
    	drawView dv=(drawView)findViewById(R.id.drawView1);//��ȡ�Զ���Ļ�ͼ��ͼ
    	dv.paint.setXfermode(null);//ȡ������Ч��
    	dv.paint.setStrokeWidth(1);//��ʼ�����ʵĿ��
    	switch(item.getItemId()){
    	case R.id.red:
    		dv.paint.setColor(Color.RED);
    		item.setChecked(true);
    		break;
    	case R.id.green:
    		dv.paint.setColor(Color.GREEN);
    		item.setChecked(true);
    		break;
    	case R.id.blue:
    		dv.paint.setColor(Color.BLUE);
    		//item.setChecked(true);
    		break;
    	case R.id.width_1:
    		dv.paint.setStrokeWidth(1);
    		item.setCheckable(true);
    		break;
    	case R.id.width_2:
    		dv.paint.setStrokeWidth(5);
    		item.setCheckable(true);
    		break;
    	case R.id.width_3:
    		dv.paint.setStrokeWidth(10);
    		//item.setCheckable(true);
    		break;
    	case R.id.clear:
    		dv.clear();
    		break;
    	case R.id.save:
    		dv.save();
    		break;
    	}
		return true;
		
    	
    }

    
}
