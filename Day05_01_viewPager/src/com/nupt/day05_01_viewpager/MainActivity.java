package com.nupt.day05_01_viewpager;



import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ViewPager viewPager;	
    private int images[] = {
			R.drawable.paper,
			R.drawable.rock,
			R.drawable.scissor,
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
	}

	

}
