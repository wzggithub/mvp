package com.project.wechat.home;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

import appframework.com.mvpprojet.R;

/**
 * 绕球心旋转的引导页效果
 */
public class SplashActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        viewFlipper = (ViewFlipper) findViewById(R.id.vf);

        detector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if(e1.getX() - e2.getX() > 120.0f){
                    viewFlipper.setInAnimation(SplashActivity.this, R.anim.tip_left_in);
                    viewFlipper.setOutAnimation(SplashActivity.this, R.anim.tip_left_out);

                    if (viewFlipper.getDisplayedChild() < 2){
                        viewFlipper.showNext();
                    }
                }else if(e1.getX() - e2.getX() < -120.0f){
                    viewFlipper.setInAnimation(SplashActivity.this, R.anim.tip_right_in);
                    viewFlipper.setOutAnimation(SplashActivity.this, R.anim.tip_right_out);

                    if (viewFlipper.getDisplayedChild() > 0){
                        viewFlipper.showPrevious();
                    }
                }


                return false;
            }
        });

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (detector != null){
            return  detector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }



}
