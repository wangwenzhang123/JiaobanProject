package com.wangshen.library_main.finance.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.library_main.R;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpFragment;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 9:16
 * @change
 */
public class FinanceFragment extends BaseMvpFragment {

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_finance;
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
