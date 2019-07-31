package com.tongdada.library_main.recruit.ui;

import com.example.library_main.R;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

public class ResumeActivity extends BaseMvpActivity {
    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_resume;
    }
}
