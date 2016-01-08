package com.nupt.day03_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class activity_second extends Activity {
	private TextView text;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		text = (TextView)findViewById(R.id.text);
		String love = intent.getStringExtra("sayHello");
		int integer = intent.getIntExtra("integer",0);
		Toast.makeText(activity_second.this,love, Toast.LENGTH_LONG).show();
		text.setText(integer+"");
		text.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
				// TODO Auto-generated method stub
							Intent intent = new Intent();
							intent.putExtra("reply", "hehe");
							setResult((int) 2000,intent);
							finish();
				
			}
		});
	}

}
