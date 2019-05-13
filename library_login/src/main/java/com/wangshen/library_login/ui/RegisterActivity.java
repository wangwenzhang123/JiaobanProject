package com.wangshen.library_login.ui;

import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.app.AppActivityKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpActivity;
import com.wangshen.library_login.R;
import com.wangshen.library_login.presenter.RegisterContact;
import com.wangshen.library_login.presenter.RegisterPresenter;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 21:38
 * @change
 */
@Route(path = ArouterKey.LOGIN_REGISTERACTIVITY)
public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements RegisterContact.View {
    @Override
    public void finishActivity() {

    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }

    @Override
    public int getView() {
        return R.layout.activity_register;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }
}
