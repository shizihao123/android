package com.example.day07_02_json;

import java.util.List;

import javax.crypto.spec.OAEPParameterSpec;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String path="http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=10&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
	private String pathPart1 = "http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=10&pageIndex=";
	private String pathPart2 = "&val=100511D3BE5301280E0992C73A9DEC41";
	private int pageNum = 1;
	private ListView listView; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loadData();
	}

	
	public void loadData(){
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, path, new RequestCallBack<String>(){

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Õ¯¬Áº”‘ÿ ß∞‹", Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				// TODO Auto-generated method stub
				First object = JSONObject.parseObject(arg0.result,First.class);
				List<Feed> list = object.getParamz().getFeeds();
				listView = (ListView)findViewById(R.id.listView);
				MyAdapter adapter = new MyAdapter(list,MainActivity.this);
				listView.setAdapter(adapter);
			}
			
		});
	}

}
