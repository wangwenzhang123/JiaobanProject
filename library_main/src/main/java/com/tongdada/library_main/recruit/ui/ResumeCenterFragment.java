package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library_main.R;
import com.example.library_main.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.view.empty.StateLayout;
import com.tongdada.library_main.recruit.presenter.ResumeCenterContract;
import com.tongdada.library_main.recruit.presenter.ResumeCenterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ResumeCenterFragment extends BaseMvpFragment<ResumeCenterPresenter> implements ResumeCenterContract.View {
    @BindView(R2.id.rv_content1)
    RecyclerView rvContent1;
    @BindView(R2.id.srl_layout1)
    SmartRefreshLayout srlLayout1;
    @BindView(R2.id.st_state_layout1)
    StateLayout stStateLayout1;
    Unbinder unbinder;

    public ResumeCenterFragment() {
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_resume;
    }


    @Override
    public ResumeCenterPresenter getPresenter() {
        return new ResumeCenterPresenter();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
