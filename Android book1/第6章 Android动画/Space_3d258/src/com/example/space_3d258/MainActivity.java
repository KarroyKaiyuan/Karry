package com.example.space_3d258;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MainActivity extends Animation{
	private int centerX;
	private int centerY;
	private int duration;
	private Camera camera=new Camera();
	public MainActivity(int centerX,int centerY,int duration){
		this.centerX=centerX;
		this.centerY=centerY;
		this.duration=duration;
	}
    public void initialize(int width,int height,int parentWidth,int parentHeight){
    	super.initialize(width, height, parentWidth, parentHeight);
    	setDuration(duration);
    	//���ö����������Ч������
    	setFillAfter(true);
    	setInterpolator(new LinearInterpolator());
    }
    protected void applyTransformation(float interpolatedTime,Transformation t){
    	camera.save();
    	//����interpolatedTimeʱ��������xyz�ϵ�ƫ��
    	camera.translate(100.0f-100.0f*interpolatedTime,
    			150.0f*interpolatedTime-150,80.0f-80.0f*interpolatedTime);
    	//����interpolatedTimeʱ��������Y������ת��ͬ�ĽǶ�
    	camera.rotateY(360*(interpolatedTime));
    	//����interpolatedTimeʱ��������x������ת��ͬ�ĽǶ�
    	camera.rotateX(360*(interpolatedTime));
    	//��ȡTransformation������matrix����
    	Matrix matrix=t.getMatrix();
    	camera.getMatrix(matrix);
    	matrix.preTranslate(-centerX,-centerY);
    	matrix.postTranslate(centerX, centerY);
    	camera.restore();
    }
	
}
