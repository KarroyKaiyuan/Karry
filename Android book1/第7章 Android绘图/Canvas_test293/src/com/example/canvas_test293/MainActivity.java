package com.example.canvas_test293;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//    }

    private CanvasView myView =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      // TODO Auto-generated method stub
      super.onCreate(savedInstanceState);
      myView = new CanvasView(this, null);
      setContentView(myView);
    }
    
    

}
