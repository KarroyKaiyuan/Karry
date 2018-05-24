package com.example.gl10_3d_test;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private GLSurfaceView mGLView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLView=new GLSurfaceView(this);//����һ��GLSurfaceView����
        //ΪGLSurfaceViewָ��ʹ�õ�Renderer����
        mGLView.setRenderer(new Renderertest());
        setContentView(mGLView);
    }
    protected void onResume() {
    	super.onResume();
    	mGLView.onResume();
    }
    protected void onPause() {
    	super.onPause();
    	mGLView.onPause();
    }

  
}
