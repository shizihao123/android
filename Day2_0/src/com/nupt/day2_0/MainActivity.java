package com.nupt.day2_0;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class MainActivity extends Activity {

	//声明ImageView,在传统动画里代表承载控件，区间动画里代表动画的执行对象
	private Button btn_fire;
	private Button btn_launch;
	private ImageView img_robot;
	private Animation anim_shot = null;
	private ImageView img_bomb ;
	//传统动画的动画类
	private AnimationDrawable anim_fire = null;
	private AnimationDrawable anim_bomb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fire = (Button) findViewById(R.id.fire);
        btn_launch = (Button) findViewById(R.id.launch);
        img_robot = (ImageView) findViewById(R.id.robot);
        img_bomb = (ImageView) findViewById(R.id.bomb);

        anim_shot = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
        //获取传统动画的所有动画内容
        anim_fire = (AnimationDrawable)img_robot.getBackground();
        anim_bomb = (AnimationDrawable)img_bomb.getBackground();

        btn_fire.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// 启动动画
				if(anim_fire.isRunning()){
					Toast.makeText(MainActivity.this,"已点火",Toast.LENGTH_SHORT).show();
				}
				anim_fire.start();
			}
		});
        
        btn_launch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(anim_fire.isRunning()){
					img_robot.startAnimation(anim_shot);
				}else{
					Toast.makeText(MainActivity.this,"尚未点火，还不能发射",Toast.LENGTH_SHORT).show();
				}

			}
		});
        
        anim_shot.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				img_bomb.setVisibility(View.VISIBLE);
				anim_bomb.start();
				img_robot.setVisibility(View.INVISIBLE);
			}
		});
        
        }
    
}
