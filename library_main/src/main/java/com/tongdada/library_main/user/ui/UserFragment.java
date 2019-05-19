package com.tongdada.library_main.user.ui;

import com.example.library_main.R;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.user.presenter.UserContract;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 9:47
 * @change
 */
public class UserFragment extends BaseMvpFragment implements UserContract.View {
    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_user;
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
