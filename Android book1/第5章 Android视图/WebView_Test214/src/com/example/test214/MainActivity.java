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
		//ʵ����webview����
		webview=new WebView(this);
		//����webview���ԣ��ܹ�ִ��javaScript�ű�
		webview.getSettings().setJavaScriptEnabled(true);
		//������Ҫ��ʾ����ҳ
		webview.loadUrl("http://www.hao123.cn/");
		//����web��ͼ
		setContentView(webview);
	}
	//���û��ˣ�����Activity���onkeyDown(int keyCoder,keyEvent event)����
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if((keyCode==KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
			webview.goBack();//goback������ʾ����webview����һҳ
			return true;
		}
		return false;
		
	}
	
	
}
