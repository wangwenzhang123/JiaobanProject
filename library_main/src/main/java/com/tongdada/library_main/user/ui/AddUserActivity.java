package com.tongdada.library_main.user.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.USER_ADDUSERACTIVITY)
public class AddUserActivity extends BaseMvpActivity<BasePresenter>{
    @Override
    public int getView() {
        return R.layout.activity_adduser;
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
}
