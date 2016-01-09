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
	private String name[]={"ËïÎò¿Õ","Áù¶úâ¨ºï","½ğË¿ºï","³¤Î²ºï","´óĞÉĞÉ","Ğ¡¾ü","Ğ¡ºì","Ğ¡°×"};
	private String sign[]={"°³ÀÏËïÈ¥Ò²","´òËÀÁù¶úâ¨ºï","","±ğÂôÃÈ","hello","ºÙºÙ","Å¶Å¶","¶î"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listview);
		MyAdapter adapter = new MyAdapter(name, MainActivity.this, images, sign);
		listView.setAdapter(adapter);
	}

	
}
