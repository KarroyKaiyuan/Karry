package com.example.test214;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	private WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//实例化webview对象
		webview=new WebView(this);
		//设置webview属性，能够执行javaScript脚本
		webview.getSettings().setJavaScriptEnabled(true);
		//加载需要显示的网页
		webview.loadUrl("http://www.hao123.cn/");
		//设置web视图
		setContentView(webview);
	}
	//设置回退，覆盖Activity类的onkeyDown(int keyCoder,keyEvent event)方法
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if((keyCode==KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
			webview.goBack();//goback（）表示返回webview的上一页
			return true;
		}
		return false;
		
	}
	
	
}
