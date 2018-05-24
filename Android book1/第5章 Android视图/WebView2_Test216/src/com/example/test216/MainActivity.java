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
		webview.loadUrl("http://www.hao123.cn/");//加载需要显示的网页
		webview.setWebViewClient(new HelloWebViewClient());
		
	}

	//设置回退，覆盖Activity类的onkeyDown(int keyCoder,keyEvent event)方法
		public boolean onKeyDown(int keyCode,KeyEvent event){
			if((keyCode==KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
				webview.goBack();//goback（）表示返回webview的上一页
				return true;
			}
			return false;
			
		}
	//web视图
		private class HelloWebViewClient extends WebViewClient{
			public boolean shouldOverrideUrlLoading(WebView view,String url){
				view.loadUrl(url);
				return true;
			}
		}
	

}
