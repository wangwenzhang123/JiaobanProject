package com.wangshen.library_login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpActivity;
import com.wangshen.library_login.R;
import com.wangshen.library_login.R2;
import com.wangshen.library_login.presenter.RegisterContact;
import com.wangshen.library_login.presenter.RegisterPresenter;
import com.winfo.photoselector.PhotoSelector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 21:38
 * @change
 */
@Route(path = ArouterKey.LOGIN_REGISTERACTIVITY)
public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements RegisterContact.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.register_business_rl)
    RelativeLayout registerBusinessRl;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;

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

    @Override
    public void selectPic() {
        PhotoSelector.builder()
                .setSingle(true)
                .start(RegisterActivity.this, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
    }

    @OnClick(R2.id.register_business_rl)
    public void onRegisterBusinessRlClicked() {
        selectPic();
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {

    }
}
