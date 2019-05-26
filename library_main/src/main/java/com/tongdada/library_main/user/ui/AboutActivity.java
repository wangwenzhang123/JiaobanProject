package com.tongdada.library_main.user.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

/**
 * Created by wangshen on 2019/5/26.
 */
@Route(path = ArouterKey.USER_ABOUTACTIVITY)
public class AboutActivity extends BaseActivity {
    @Override
    public int getView() {
        return  R.layout.activity_about;
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
}
