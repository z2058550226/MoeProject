package com.suikajy.moeproject.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.suikajy.moeproject.MoeApplication;

/**
 * Created by Administrator on 2016/11/21.
 */

public class AbstractAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // TODO: 2016/11/21 启动音乐服务
        MoeApplication.getInstance().addActivity(this);
    }

    public void startActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    public void showToast(@StringRes int toastMsg) {
        Toast.makeText(this, getString(toastMsg), Toast.LENGTH_SHORT).show();
    }

    public void showSnackBar(View view, @StringRes int toast) {
        Snackbar.make(view, getString(toast), Snackbar.LENGTH_SHORT).show();
    }

    public void showSnackBar(View view, String toast) {
        Snackbar.make(view, toast, Snackbar.LENGTH_SHORT).show();
    }

    public void goToSongPlayerActivity(){
        // TODO: 2016/11/21 跳转到音乐播放界面
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MoeApplication.getInstance().removeActivity(this);
    }
}
