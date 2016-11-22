package com.suikajy.moeproject.ui.account;

import com.cpacm.core.mvp.presenters.LoginIPresenter;
import com.github.scribejava.core.model.OAuth1AccessToken;

/**
 * Created by Administrator on 2016/11/21.
 */

public class LoginPresenter implements LoginIPresenter{


    @Override
    public void OauthRedirect(String url) {

    }

    @Override
    public void LoginSuccess(OAuth1AccessToken accessToken) {

    }

    @Override
    public void LoginFailed(Throwable e) {

    }
}
