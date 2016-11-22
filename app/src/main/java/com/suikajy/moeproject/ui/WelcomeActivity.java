package com.suikajy.moeproject.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.cpacm.core.cache.SettingManager;
import com.suikajy.moeproject.R;
import com.suikajy.moeproject.ui.account.LoginActivity;

public class WelcomeActivity extends AbstractAppActivity {

    private ImageView welComeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welComeView = (ImageView) findViewById(R.id.iv_logo);
        startAnimation();
    }

    private void startAnimation() {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(welComeView, "scaleX", 0f, 1f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(welComeView, "scaleY", 0f, 1f);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(welComeView, "alpha", 0f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimator).with(scaleYAnimator).with(alphaAnimator);
        animatorSet.setDuration(1500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hasLogin();
            }
        });
    }

    private void hasLogin() {
        //SharedPreference的key值Account_id写死在SettingManager中
        if (SettingManager.getInstance().getSetting(SettingManager.ACCOUNT_ID,-1)==-1){
            startActivity(LoginActivity.class);
        }else {
            // TODO: 2016/11/21 开启主页面
        }
        finish();
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}
