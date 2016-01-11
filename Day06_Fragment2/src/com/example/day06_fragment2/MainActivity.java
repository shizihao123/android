package com.example.day06_fragment2;

import android.support.v7.app.ActionBarActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity  implements OnClickListener{
    private Button btn_msg,btn_friend,btn_my;
    private FirstFragment first;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		FragmentManager manager=getFragmentManager();
		FragmentTransaction action=manager.beginTransaction();
		first=new FirstFragment();
		action.add(R.id.fragment, first);
		action.commit();
	}
	public void initView()
	{
		btn_msg=(Button) findViewById(R.id.mes);
		btn_friend=(Button) findViewById(R.id.friend);
		btn_my=(Button) findViewById(R.id.my);
		btn_msg.setOnClickListener(this);
		btn_friend.setOnClickListener(this);
		btn_my.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
	
		FragmentManager manager=getFragmentManager();
		FragmentTransaction action=manager.beginTransaction();
		switch (view.getId()) {
		case R.id.mes:
			action.replace(R.id.fragment,first);
			action.commit();
			btn_msg.setBackgroundColor(Color.BLUE);
			btn_friend.setBackgroundColor(Color.BLACK);
			btn_my.setBackgroundColor(Color.BLACK);
			break;

		case R.id.friend:
			action.replace(R.id.fragment, new SecondFragment());
			action.commit();
			btn_msg.setBackgroundColor(Color.BLACK);
			btn_friend.setBackgroundColor(Color.BLUE);
			btn_my.setBackgroundColor(Color.BLACK);
			break;
		case R.id.my:
			action.replace(R.id.fragment, new ThirdFragment());
			action.commit();
			btn_msg.setBackgroundColor(Color.BLACK);
			btn_friend.setBackgroundColor(Color.BLACK);
			btn_my.setBackgroundColor(Color.BLUE);
	
			break;
		}
	}
}
