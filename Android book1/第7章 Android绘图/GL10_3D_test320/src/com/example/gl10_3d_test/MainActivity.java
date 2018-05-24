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
        mGLView=new GLSurfaceView(this);//创建一个GLSurfaceView对象
        //为GLSurfaceView指定使用的Renderer对象
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
