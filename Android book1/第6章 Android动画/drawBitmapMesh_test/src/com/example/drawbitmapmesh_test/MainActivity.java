package com.example.drawbitmapmesh_test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

	private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this,R.drawable.a5));
    }
    public class MyView extends View{

    	
		//定义两个常量，这两个常量指定该图片横向纵向上被划分为20格
    	private final int WIDTH=20;
    	private final int HEIGHT=20;
    	//记录该图片上包含的441个顶点
    	private final int COUNT=(WIDTH+1)*(HEIGHT+1);
    	//定义一个数组，记录Bitmap上的21*21个点的坐标
    	private final float[] verts=new float[COUNT*2];
    	//定义一个数组，记录Bitmap上的21*21个点经过扭曲后的坐标，对图片扭曲的关键就是修改该数组元素的值
    	private final float[] orig=new float[COUNT*2];
    	public MyView(Context context, int drawableId) {
			super(context);
			//setFocusable(true);
			//根据指定资源加载图片
			bitmap=BitmapFactory.decodeResource(getResources(), drawableId);
			//获取图片的宽度和高度
			float bitmapWidth=bitmap.getWidth();
			float bitmapHeight=bitmap.getHeight();
			int index=0;
			for(int y=0;y<=HEIGHT;y++){
				float fy=bitmapHeight*y/HEIGHT;
				for(int x=0;x<=WIDTH;x++){
					float fx=bitmapWidth*x/WIDTH;
					//初始化orig verts数组，两个数组均匀的保存了21*21个点的坐标
					orig[index*2+0]=verts[index*2+0]=fx;
					orig[index*2+1]=verts[index*2+1]=fy;
					index+=1;
				}
			}
			//设置背景色
			setBackgroundColor(Color.WHITE);
		}
    	protected void onDraw(Canvas canvas){
    		//对bitmap按verts数组进行扭曲 从第1个点（由5个参数0控制）开始扭曲
    		canvas.drawBitmapMesh(bitmap, WIDTH, WIDTH, verts, 0, null, 0, null);
    	}
    	//工具方法 用于根据触摸事件的位置计算verts数组里各元素的值
    	private void wrap(float cx,float cy){
    		for(int i=0;i<COUNT*2;i+=2){
    			float dx=cx-orig[i+0];
    			float dy=cy-orig[i+1];
    			float dd=dx*dx+dy*dy;
    			//计算每个坐标点与当前点（cx，cy）之间的距离
    			float d=(float)Math.sqrt(dd);
    			//计算扭曲度，距离当前点（cx，cy）越远，扭曲度越小
    			float pull=8000/((float)(dd*d));
    			//对verts数组（保存bitmap上21*21个点经过扭曲后的坐标）重新赋值
    			if(pull>=1){
    				verts[i+0]=cx;
    				verts[i+1]=cy;
    			}
    			else{
    				//控制各顶点向触摸事件发生的点偏移
    				verts[i+0]=orig[i+0]+dx*pull;
    				verts[i+1]=orig[i+1]+dx*pull;
    			}
    		}
    		//通知view组件重绘
    		invalidate();
    	}
		public boolean onTouchEvent(MotionEvent event){
			//调用wrap方法根据接触屏时间的坐标点来扭曲verts数组
			wrap(event.getX(),event.getY());
			return true;
		}
    }
}
