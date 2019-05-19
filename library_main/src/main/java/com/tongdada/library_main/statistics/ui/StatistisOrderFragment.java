package com.tongdada.library_main.statistics.ui;

import com.example.library_main.R;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.statistics.presenter.StatiscsPresenter;
import com.tongdada.library_main.statistics.presenter.StatisticsContract;

/**
 * Created by wangshen on 2019/5/19.
 */

public class StatistisOrderFragment extends BaseMvpFragment<StatiscsPresenter> implements StatisticsContract.View{
    @Override
    public int getViewId() {
        return R.layout.fragment_statistics_order;
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
    public StatiscsPresenter getPresenter() {
        return new StatiscsPresenter();
    }
}
