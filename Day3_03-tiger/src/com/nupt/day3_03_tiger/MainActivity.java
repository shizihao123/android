package com.nupt.day3_03_tiger;

import java.util.Random;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private  ImageButton image01_01,image01_02,image01_03,image02_01,image02_02,image02_03,image03_01,image03_02,image03_03;
    private Button btn_vote,btn_start;
    private  TextView text_money;
	private ImageButton images[]= new ImageButton[8];
    private Handler handler;
    private AnimThread animThread;
    private StopThread stopThread;
    private String name[] = {"大乔","貂蝉","蔡琰","小乔","孙尚香","西施","昭君","芈月"};
    private int count=1;
    private String selected = null;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		handler =new Handler(){
        public void handleMessage(Message msg) {
        		super.handleMessage(msg);
            	if(msg.what == 11){
            		animThread.isStop = false;
            		String stopName = getResult();
            		if(stopName.equals(selected)){
            			Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            		}else{
            			Toast.makeText(MainActivity.this, "Faile", Toast.LENGTH_LONG).show();
            		}
            	}else{
            		anim(msg.what);
            	}
        	}	     
		};
		
		animThread = new AnimThread();
		stopThread = new StopThread();
		btn_start.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
//					isStop=true;
//					animThread = new AnimThread();
//				    animThread.start();	
					if(count == 1){
						animThread.start();
						stopThread.start();
						count = 2;
					}else{
						if(animThread.isStop == true){
							Toast.makeText(MainActivity.this, "正在运行", Toast.LENGTH_LONG).show();
						}else{
							animThread=new AnimThread();
							stopThread=new StopThread();
							animThread.isStop=true;
							animThread.start();
						    stopThread.start();	
						}
					}
					
				}
		});
		btn_vote.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, SecondActivity.class);
				//startActivity(intent);	
				startActivityForResult(intent, 1000);

			}
		});
		
		
//		btn_vote.setOnClickListener(new OnClickListener() {
//			public void onClick(View arg0) {
//				isStop=false;
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			//	animThread.stop();
//		}
//	});
	}

     
	public void initView()
	{
		image01_01 = (ImageButton)findViewById(R.id.image_11);
		image01_02 = (ImageButton)findViewById(R.id.image_12);
		image01_03 = (ImageButton)findViewById(R.id.image_13);
		image02_01 = (ImageButton)findViewById(R.id.image_21);
		image02_02 = (ImageButton)findViewById(R.id.image_22);
		image02_03 = (ImageButton)findViewById(R.id.image_23);
		image03_01 = (ImageButton)findViewById(R.id.image_31);
		image03_02 = (ImageButton)findViewById(R.id.image_32);
		image03_03 = (ImageButton)findViewById(R.id.image_33);
		text_money = (TextView)findViewById(R.id.text_money);
		btn_vote = (Button)findViewById(R.id.btn_vote);
		btn_start = (Button)findViewById(R.id.btn_start);
		images[0] = image01_01;
		images[1] = image01_02;
		images[2] = image01_03;
		images[3] = image02_03;
		images[4] = image03_03;
		images[5] = image03_02;
		images[6] = image03_01;
		images[7] = image02_01;
	}
		
	
    public void anim(int a){
    	for(int j=0;j<8;j++){
    		images[j].setClickable(false);
    	}
    	
    	for(int i=0;i<8;i++){
    		if(i==a){
    			images[i].setBackgroundResource(R.drawable.changefocus);
        		images[i].setClickable(false);
    		}else{
    			images[i].setBackgroundColor(Color.TRANSPARENT);
        		images[i].setClickable(true);
    		}
    	}
    }
    
    public String getResult()
    {
    	String now_name = null;
    	for(int i = 0; i < 8; i++){
    		if(images[i].isClickable())
    		{
    			now_name = name[i];
    		}
    	}
    	return  now_name;
    }
    
    class AnimThread extends Thread{
    	public boolean isStop =true;
    	public void run(){
    		super.run();
    		int index = 0;
    		while(isStop){
    			handler.sendEmptyMessage(index++);	
    			if(index > 7){
    				index = 0;
    			}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
    		}
    	}
    }
    
    class StopThread extends Thread{
    	public void run(){
    		super.run();	
    		try {
    			Random rand = new Random();
        		int time = rand.nextInt(7) + 2;
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			handler.sendEmptyMessage(11);		
    	}
    }
    
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(arg0, arg1, arg2);
    	if(arg0 == 1000 && arg1 == 2000){
    		int position = arg2.getIntExtra("position",0);
    	//	Toast.makeText(MainActivity.this, "点击了第"+position+"项", Toast.LENGTH_LONG).show();
    	    selected = name[position]; 
    	//	Toast.makeText(MainActivity.this, "点击了第"+selected+"项", Toast.LENGTH_LONG).show();
    	}
    } 
    
    
}
