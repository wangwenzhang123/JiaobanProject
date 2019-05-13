package com.wangshen.library_login.presenter;

import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.library_login.net.LoginApi;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presnter {
    private LoginApi loginApi;

    public LoginPresenter() {
        loginApi= KRetrofitFactory.createService(LoginApi.class);
    }

    @Override
    public void login(String phone, String password) {

    }
}
