package com.example.openfile_test347;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button1;
	private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					FileOutputStream fosRef=MainActivity.this.openFileOutput(
							"ghad.text", Context.MODE_PRIVATE);
					fosRef.write("Android精要".getBytes());
					fosRef.close();
					StringBuffer sbRef=new StringBuffer();
					FileInputStream fisRef=MainActivity.this.openFileInput(
							"ghy.text");
					InputStreamReader isrRef=new InputStreamReader(fisRef);
					char[] charArray=new char[2];
					int readLength=isrRef.read(charArray);
					while (readLength!=-1) {
						sbRef.append(charArray,0,readLength);
						readLength=isrRef.read(charArray);
					}
					Log.v("读入的值：", new String(sbRef.toString()));
					fisRef.close();
					isrRef.close();

				} catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			
				public void onClick(View v) {
				 
				try{
				// TODO Auto-generated method stub
				FileOutputStream fosRef=MainActivity.this.openFileOutput(
						"ghy.text", Context.MODE_APPEND);
				fosRef.write("我是追加的".getBytes());
				fosRef.close();
				StringBuffer sbRef=new StringBuffer();
				FileInputStream fisRef=MainActivity.this.openFileInput(
						"ghy.text");
				InputStreamReader isrRef=new InputStreamReader(fisRef);
				char[] charArray=new char[2];
				int readLength=isrRef.read(charArray);
				while (readLength!=-1) {
					sbRef.append(charArray,0,readLength);
					readLength=isrRef.read(charArray);
				}
				Log.v("读入的值：", new String(sbRef.toString()));
				fisRef.close();
				isrRef.close();

			} catch(FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        }
			
		});
    }



   
    
}
