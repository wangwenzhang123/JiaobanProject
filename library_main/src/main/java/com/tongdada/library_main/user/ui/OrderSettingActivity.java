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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/23 14:56
 * @change
 */
@Route(path = ArouterKey.USER_SETORDER)
public class OrderSettingActivity extends BaseMvpActivity<BasePresenter> {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.tongche_et)
    EditText tongcheEt;
    @BindView(R2.id.bengche_et)
    EditText bengcheEt;
    @BindView(R2.id.sure_change)
    TextView sureChange;

    @Override
    public int getView() {
        return R.layout.activity_order_setting;
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
    public BasePresenter getPresenter() {
        return null;
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

    @OnClick(R2.id.sure_change)
    public void onSureChangeClicked() {
    }
}
