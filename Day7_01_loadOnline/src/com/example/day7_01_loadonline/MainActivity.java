package com.example.day7_01_loadonline;

import com.lidroid.xutils.BitmapUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView image;
	private String path = "http://pic.nipic.com/2008-07-05/20087584237954_2.jpg";
	//private String path = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&pn=6&spn=0&di=63705694250&pi=&rn=1&tn=baiduimagedetail&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3841157212%2C2135341815&os=2353784648%2C2722531871&simid=3438637943%2C188811404&adpicid=0&ln=30&fr=ala&sme=&cg=&bdtype=0&objurl=http%3A%2F%2Fpica.nipic.com%2F2007-11-09%2F200711912453162_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3FnAzdH3F0nAzdH3Fd8jv9bu88mnmw990_z%26e3Bip4s&gsm=0";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image = (ImageView)findViewById(R.id.image);
		BitmapUtils utils=new BitmapUtils(MainActivity.this);
		utils.display(image,path);
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
