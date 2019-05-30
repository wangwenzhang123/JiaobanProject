package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.example.library_commen.model.TransportCarBean;
import com.tongdada.library_main.order.adapter.AcceptOrderDetailAdapter;
import com.tongdada.library_main.order.presenter.AcceptOrderDetailContract;
import com.tongdada.library_main.order.presenter.AcceptOrderDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 17:29
 * @change
 */
public class AcceptOrderDetailActivity extends BaseMvpActivity<AcceptOrderDetailPresenter> implements AcceptOrderDetailContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.accept_order_ry)
    RecyclerView acceptOrderRy;
    private AcceptOrderDetailAdapter acceptOrderDetailAdapter;
    @Override
    public int getView() {
        return R.layout.activity_accept_order_detail;
    }


    @Override
    public AcceptOrderDetailPresenter getPresenter() {
        return new AcceptOrderDetailPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }

    @Override
    public void initView() {
        acceptOrderDetailAdapter=new AcceptOrderDetailAdapter(R.layout.item_accept_detail,new ArrayList<TransportCarBean>());
        acceptOrderRy.setLayoutManager(new LinearLayoutManager(this));
        acceptOrderRy.setAdapter(acceptOrderDetailAdapter);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }

    @Override
    public void setOrderList(List<TransportCarBean> list) {
        acceptOrderDetailAdapter.setNewData(list);
    }
}
