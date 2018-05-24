package com.example.gl10_3_test335;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	private GLSurfaceView mGLView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLView=new GLSurfaceView(this);//创建一个GLSurfaceView对象
        //为GLSurfaceView指定使用的Renderer对象
        mGLView.setRenderer(new Renderertest(this));
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