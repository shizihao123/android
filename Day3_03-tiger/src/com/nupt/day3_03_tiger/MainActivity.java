package com.nupt.day3_03_tiger;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    private  ImageButton image01_01,image01_02,image01_03,image02_01,image02_02,image02_03,image03_01,image03_02,image03_03;
    private Button btn_vote,btn_start;
    private  TextView text_money;
	private ImageButton images[]= new ImageButton[8];
    private Handler handler;
    private AnimThread animThread;
    private AnimThread2 animThread2;
	public boolean isStop = true;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		handler =new Handler(){
        public void handleMessage(Message msg) {
        		super.handleMessage(msg);
        		anim(msg.what);
        	}	     
		};
		
		btn_start.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					isStop=true;
					animThread = new AnimThread();
				    animThread.start();	
			}
		});
		btn_vote.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				isStop=false;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	animThread.stop();
		}
	});
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
    	
    	for(int i=0;i<8;i++){
    		if(i==a){
    			images[i].setBackgroundResource(R.drawable.ic_launcher);
    		}else{
    			images[i].setBackgroundColor(Color.TRANSPARENT);
    		}
    	}
    }
    
    class AnimThread extends Thread{
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
    
    class AnimThread2 extends Thread{
    	public void run(){
    		super.run();	
			handler.sendEmptyMessage(11);		
    	}
    }
    
    
}
