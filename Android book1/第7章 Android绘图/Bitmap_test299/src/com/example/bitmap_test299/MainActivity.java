package com.example.bitmap_test299;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private Surface_View bitmapView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bitmapView=new Surface_View(this);
        setContentView(bitmapView);
    }


    
    
}
