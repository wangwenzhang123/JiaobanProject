package com.tongdada.library_main.finance.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.finance.adapter.FinaceCompleteAdapter;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.finance.presenter.FinanceContract;
import com.tongdada.library_main.finance.presenter.FinancePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinanceCompleteFragment extends BaseMvpFragment<FinancePresenter> implements FinanceContract.View {
    @BindView(R2.id.finance_complete_recycle)
    RecyclerView financeCompleteRecycle;
    Unbinder unbinder;
    private FinaceCompleteAdapter adapter;
    private List<FinaceBean> list=new ArrayList<>();
    @Override
    public int getViewId() {
        return R.layout.fragment_finance_complete;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        list.clear();
        list.add(new FinaceBean());
        list.add(new FinaceBean());
        list.add(new FinaceBean());
        financeCompleteRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new FinaceCompleteAdapter(R.layout.item_finace_complete,list);
        financeCompleteRecycle.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public FinancePresenter getPresenter() {
        return new FinancePresenter();
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
