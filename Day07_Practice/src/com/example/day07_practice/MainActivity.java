package com.example.day07_practice;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ViewPager viewPager;	
    private int images[] = {
			R.drawable.welcome1,
			R.drawable.welcome2,
			R.drawable.welcome3,
			};
    private ImageView views[] = new ImageView[3];
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		for(int i = 0;i < 3;i++){
			//用代码生成控件
			ImageView image = new ImageView(MainActivity.this);
			image.setImageResource(images[i]);
			views[i]=image;
		}
		MyAdapter adapter = new MyAdapter(views);
		viewPager.setAdapter(adapter);
		views[2].setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
	}

	

}
