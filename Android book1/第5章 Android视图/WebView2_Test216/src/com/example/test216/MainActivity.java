package com.example.test216;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;;
public class MainActivity extends Activity {

	private WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		webview=(WebView)findViewById(R.id.webView);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("http://www.hao123.cn/");//������Ҫ��ʾ����ҳ
		webview.setWebViewClient(new HelloWebViewClient());
		
	}

	//���û��ˣ�����Activity���onkeyDown(int keyCoder,keyEvent event)����
		public boolean onKeyDown(int keyCode,KeyEvent event){
			if((keyCode==KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
				webview.goBack();//goback������ʾ����webview����һҳ
				return true;
			}
			return false;
			
		}
	//web��ͼ
		private class HelloWebViewClient extends WebViewClient{
			public boolean shouldOverrideUrlLoading(WebView view,String url){
				view.loadUrl(url);
				return true;
			}
		}
	

}
