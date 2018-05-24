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

    	
		//������������������������ָ����ͼƬ���������ϱ�����Ϊ20��
    	private final int WIDTH=20;
    	private final int HEIGHT=20;
    	//��¼��ͼƬ�ϰ�����441������
    	private final int COUNT=(WIDTH+1)*(HEIGHT+1);
    	//����һ�����飬��¼Bitmap�ϵ�21*21���������
    	private final float[] verts=new float[COUNT*2];
    	//����һ�����飬��¼Bitmap�ϵ�21*21���㾭��Ť��������꣬��ͼƬŤ���Ĺؼ������޸ĸ�����Ԫ�ص�ֵ
    	private final float[] orig=new float[COUNT*2];
    	public MyView(Context context, int drawableId) {
			super(context);
			//setFocusable(true);
			//����ָ����Դ����ͼƬ
			bitmap=BitmapFactory.decodeResource(getResources(), drawableId);
			//��ȡͼƬ�Ŀ�Ⱥ͸߶�
			float bitmapWidth=bitmap.getWidth();
			float bitmapHeight=bitmap.getHeight();
			int index=0;
			for(int y=0;y<=HEIGHT;y++){
				float fy=bitmapHeight*y/HEIGHT;
				for(int x=0;x<=WIDTH;x++){
					float fx=bitmapWidth*x/WIDTH;
					//��ʼ��orig verts���飬����������ȵı�����21*21���������
					orig[index*2+0]=verts[index*2+0]=fx;
					orig[index*2+1]=verts[index*2+1]=fy;
					index+=1;
				}
			}
			//���ñ���ɫ
			setBackgroundColor(Color.WHITE);
		}
    	protected void onDraw(Canvas canvas){
    		//��bitmap��verts�������Ť�� �ӵ�1���㣨��5������0���ƣ���ʼŤ��
    		canvas.drawBitmapMesh(bitmap, WIDTH, WIDTH, verts, 0, null, 0, null);
    	}
    	//���߷��� ���ڸ��ݴ����¼���λ�ü���verts�������Ԫ�ص�ֵ
    	private void wrap(float cx,float cy){
    		for(int i=0;i<COUNT*2;i+=2){
    			float dx=cx-orig[i+0];
    			float dy=cy-orig[i+1];
    			float dd=dx*dx+dy*dy;
    			//����ÿ��������뵱ǰ�㣨cx��cy��֮��ľ���
    			float d=(float)Math.sqrt(dd);
    			//����Ť���ȣ����뵱ǰ�㣨cx��cy��ԽԶ��Ť����ԽС
    			float pull=8000/((float)(dd*d));
    			//��verts���飨����bitmap��21*21���㾭��Ť��������꣩���¸�ֵ
    			if(pull>=1){
    				verts[i+0]=cx;
    				verts[i+1]=cy;
    			}
    			else{
    				//���Ƹ����������¼������ĵ�ƫ��
    				verts[i+0]=orig[i+0]+dx*pull;
    				verts[i+1]=orig[i+1]+dx*pull;
    			}
    		}
    		//֪ͨview����ػ�
    		invalidate();
    	}
		public boolean onTouchEvent(MotionEvent event){
			//����wrap�������ݽӴ���ʱ����������Ť��verts����
			wrap(event.getX(),event.getY());
			return true;
		}
    }
}
