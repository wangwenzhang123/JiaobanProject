package com.wangshen.library_login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpActivity;
import com.wangshen.library_login.R;
import com.wangshen.library_login.R2;
import com.wangshen.library_login.presenter.LoginContact;
import com.wangshen.library_login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = ArouterKey.LOGIN_LOGINACTIVITY)
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContact.View {


    @BindView(R2.id.imageView)
    ImageView imageView;
    @BindView(R2.id.phone_login)
    TextView phoneLogin;
    @BindView(R2.id.rt_phone_login)
    EditText rtPhoneLogin;
    @BindView(R2.id.password_login)
    TextView passwordLogin;
    @BindView(R2.id.et_password_login)
    EditText etPasswordLogin;
    @BindView(R2.id.bt_login)
    Button btLogin;
    @BindView(R2.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R2.id.tv_login_register)
    TextView tvLoginRegister;

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_login;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.bt_login)
    public void onBtLoginClicked() {
        routerIntent(ArouterKey.MAIN_MAINACTIVITY,null);
    }

    @OnClick(R2.id.tv_forgot_password)
    public void onTvForgotPasswordClicked() {

    }

    @OnClick(R2.id.tv_login_register)
    public void onTvLoginRegisterClicked() {
        routerIntent(ArouterKey.LOGIN_REGISTERACTIVITY,null);
    }
}
