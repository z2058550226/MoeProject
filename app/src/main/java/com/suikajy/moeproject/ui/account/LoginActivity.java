package com.suikajy.moeproject.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cpacm.core.mvp.views.LoginIView;
import com.suikajy.moeproject.R;
import com.suikajy.moeproject.ui.AbstractAppActivity;

/**
 * Created by Administrator on 2016/11/21.
 * 登录页面Activity
 */

public class LoginActivity extends AbstractAppActivity implements View.OnClickListener, LoginIView {

    /**
     * 一个静态的打开方法 , 可以在任何有context的地方打开登录页面
     * @param context a subclass instance of context
     */
    public static void open(Context context){
        Intent intent=new Intent();
        intent.setClass(context,LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void OauthRedirect(String url) {

    }

    @Override
    public void LoginSuccess() {

    }

    @Override
    public void LoginFailed() {

    }

    @Override
    public void LoginFailed(String s) {

    }
}
