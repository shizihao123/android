package com.nupt.day4_1_listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView; 
	private int images[] = {
			R.drawable.s1,
			R.drawable.s2,
			R.drawable.s3,
			R.drawable.s4,
			R.drawable.s5,
			R.drawable.s6,
			R.drawable.s7,
			R.drawable.s8
			};
	private String name[]={"�����","����⨺�","��˿��","��β��","������","С��","С��","С��"};
	private String sign[]={"������ȥҲ","��������⨺�","","������","hello","�ٺ�","ŶŶ","��"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listview);
		MyAdapter adapter = new MyAdapter(name, MainActivity.this, images, sign);
		listView.setAdapter(adapter);
	}

	
}
