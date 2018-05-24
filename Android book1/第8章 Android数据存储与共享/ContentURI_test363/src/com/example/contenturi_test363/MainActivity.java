package com.example.contenturi_test363;

import android.net.Uri;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends ContentProvider {
	private static final UriMatcher uriMatcherRef=new UriMatcher(UriMatcher.NO_MATCH);
	static{
		uriMatcherRef.addURI("com.gaohongyan.www", "insert", 1000);
		uriMatcherRef.addURI("com.gaohongyan.www", "delete/#", 2000);
		
	}
	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		Log.v("!", "调用getType()方法");
		switch(uriMatcherRef.match(arg0)){
		case 1000:
			Log.v("！", "匹配了insert");
			return "vnd.android.cursor.item/insert";
		case 2000:
			Log.v("！", "匹配了delete");
			return "vnd.android.cursor.item/delete";	
		default:
		 throw new IllegalArgumentException();
			
		}
	}
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
