package com.example.path_test301;

import android.R.color;
import android.net.wifi.WpsInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    class MyView extends View{

    	float phase;
    	PathEffect[] effects=new PathEffect[7];
    	int[] colors;
    	private Paint paint;
    	Path path;
		public MyView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			paint=new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(4);
			path=new Path();
			path.moveTo(0, 0);
			for(int i=1;i<=15;i++){
				//����15���㣬����������ǵ�y���꣬������������һ��path
				path.lineTo(i*20,( float)Math.random()*60);
			}
			//��ʼ��7����ɫ
			colors=new int[]{Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,
					Color.MAGENTA,Color.RED,Color.YELLOW};
		}
		protected void onDraw(Canvas canvas){
			//���������ɰ�ɫ
			canvas.drawColor(Color.WHITE);
			//--------��ʼ��7�в�ͬ��·��Ч��----------
			//0.��ʹ��·��Ч��
			effects[0]=null;
			//1.ʹ��CornerPathEffect·��Ч��
			effects[1]=new CornerPathEffect(10);
			//2.��ʼ��DiscretepathEffect
			effects[2]=new DiscretePathEffect(3.0f, 5.0f);
			//3.��ʼ��DashPathEffect
			effects[3]=new DashPathEffect(new float[]{20,10,5,10}, phase);
			//4.��ʼ��PathDashPathEffect
			Path p=new Path();
			p.addRect(0, 0, 8, 8, Path.Direction.CCW);
			effects[4]=new PathDashPathEffect(p, 12, phase,PathDashPathEffect.Style.ROTATE);
			//5.��ʼ��ComposePathEffect
			effects[5]=new ComposePathEffect(effects[2], effects[4]);
			//6.��ʼ��SumPathEffect
			effects[6]=new SumPathEffect(effects[4], effects[3]);
			//�������ƶ�����8,8������ʼ����
			canvas.translate(8,8);
			//����ʹ��7�ֲ�ͬ·��Ч�� 7�ֲ�ͬ��ɫ������·��
			for(int i=0;i<effects.length;i++){
				paint.setPathEffect(effects[i]);
				paint.setColor(colors[i]);
				canvas.drawPath(path, paint);
				canvas.translate(0, 60);
				
			}
			//�ı�phaseֵ���γɶ���Ч��
			phase+=1;
			invalidate();
		}
    	
    }


    
    
}
