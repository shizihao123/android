package com.nupt.day3_03_tiger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class SecondActivity extends Activity {
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
	private String sign[]={"������ȥҲ","��������⨺�","hehe","������","hello","�ٺ�","ŶŶ","��"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);
		
		listView = (ListView)findViewById(R.id.listview);
		MyAdapter adapter = new MyAdapter(name, SecondActivity.this, images, sign);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			 public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
	            Toast.makeText(SecondActivity.this, "�����˵�"+position+"��", Toast.LENGTH_SHORT).show();
	            Intent intent = new Intent();
	    		intent.putExtra("position", position);
	    		setResult(2000,intent);
	    		finish();
			 }
		});
		
	}

}
