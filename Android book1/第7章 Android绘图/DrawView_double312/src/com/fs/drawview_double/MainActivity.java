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
    //创建选项菜单
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater=new MenuInflater(this);//实例化一个Menuinflater对象
    	inflater.inflate(R.menu.menu_item, menu);//解析菜单文件
    	return super.onCreateOptionsMenu(menu);
    }
    //当菜单项被选择是做出相应的处理
    public boolean onOptionsItemSelected(MenuItem item){
    	drawView dv=(drawView)findViewById(R.id.drawView1);//获取自定义的绘图视图
    	dv.paint.setXfermode(null);//取消擦除效果
    	dv.paint.setStrokeWidth(1);//初始化画笔的宽度
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
