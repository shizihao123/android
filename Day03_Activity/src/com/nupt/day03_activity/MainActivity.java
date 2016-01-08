package com.nupt.day03_activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.jump);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, activity_second.class);
				intent.putExtra("sayHello", "I miss you,baby");
				//intent.putExtra("character", "o");
				//intent.putExtra("integer", 18);
				//startActivity(intent);
				startActivityForResult(intent, 1000);
			}
		});
         
    }
    
    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(arg0, arg1, arg2);
    	if(arg0 == 1000 && arg1 == 2000){
    		String str = arg2.getStringExtra("reply");
    		Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    	}
    }    
}
