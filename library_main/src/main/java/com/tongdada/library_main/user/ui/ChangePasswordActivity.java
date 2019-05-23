package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.ChangePasswordContract;
import com.tongdada.library_main.user.presenter.ChangePasswordPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 16:42
 * @change
 */
@Route(path = ArouterKey.USER_CHANGEPASSWORDACTIVITY)
public class ChangePasswordActivity extends BaseMvpActivity<ChangePasswordPresenter> implements ChangePasswordContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.user_phone)
    EditText userPhone;
    @BindView(R2.id.user_oldpassword)
    EditText userOldpassword;
    @BindView(R2.id.user_newpassword)
    EditText userNewpassword;
    @BindView(R2.id.user_sure_newpassword)
    EditText userSureNewpassword;
    @BindView(R2.id.sure_tv)
    TextView sureTv;

    @Override
    public int getView() {
        return R.layout.activity_changepassword;
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
    public ChangePasswordPresenter getPresenter() {
        return new ChangePasswordPresenter();
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

    @OnClick(R2.id.sure_tv)
    public void onSureTvClicked() {

    }
}
