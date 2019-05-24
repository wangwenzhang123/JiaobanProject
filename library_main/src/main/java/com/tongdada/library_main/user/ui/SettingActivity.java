package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/20.
 */
@Route(path = ArouterKey.USER_SETTINGACTIVITY)
public class SettingActivity extends BaseActivity {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.order_setting)
    LinearLayout orderSetting;
    @BindView(R2.id.out_login)
    LinearLayout outLogin;

    @Override
    public int getView() {
        return R.layout.activity_setting;
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

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.order_setting)
    public void onOrderSettingClicked() {

    }

    @OnClick(R2.id.out_login)
    public void onOutLoginClicked() {
        ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
    }
}