package com.example.day07_practice;




import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity implements OnClickListener{
	private Button btn1,btn2,btn3;
	private FirstFragment first;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity_second);
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
		action.commit();
   }
   
   public void onClick(View view) {
		FragmentManager manager = getFragmentManager();
       FragmentTransaction action = manager.beginTransaction();
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.btn1:
			action.replace(R.id.fragment, first);
			action.commit();
			Toast.makeText(getApplicationContext(), "消息", Toast.LENGTH_SHORT).show();
			
			break;
		case R.id.btn2:
			action.replace(R.id.fragment, new SecondFragment());
			action.commit();
			Toast.makeText(getApplicationContext(), "联系人", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn3:
			action.replace(R.id.fragment, new ThirdFragment());
			action.commit();
			Toast.makeText(getApplicationContext(), "动态", Toast.LENGTH_SHORT).show();
			break;
			
		}
	}

}
