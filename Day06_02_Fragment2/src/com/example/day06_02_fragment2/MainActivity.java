package com.example.day06_02_fragment2;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener{
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private FirstFragment first;
	private SecondFragment second;
	private ThridFragment third;
//	private FragmentTransaction action;
//	private FragmentManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		FragmentManager manager = getFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        first = new FirstFragment();
		action.add(R.id.fragment, first);
		action.show(first);
		action.commit();
	}

	@Override
	public void onClick(View view) {
		FragmentManager manager = getFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.btn1:
			action.replace(R.id.fragment, first);
			action.commit();
			Toast.makeText(getApplicationContext(), "消息", Toast.LENGTH_LONG).show();
			
			break;
		case R.id.btn2:
			action.replace(R.id.fragment, new SecondFragment());
			action.commit();
			Toast.makeText(getApplicationContext(), "联系人", Toast.LENGTH_LONG).show();
			break;
		case R.id.btn3:
			action.replace(R.id.fragment, new ThridFragment());
			action.commit();
			Toast.makeText(getApplicationContext(), "动态", Toast.LENGTH_LONG).show();
			break;
			
		}
	}


}
