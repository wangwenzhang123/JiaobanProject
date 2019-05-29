package com.tongdada.library_main.order.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshFragment;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.view.empty.IStateLayout;
import com.tongdada.library_main.order.adapter.OrderAdapter;
import com.tongdada.library_main.order.presenter.OrderListContract;
import com.tongdada.library_main.order.presenter.OrderListPresenter;
import com.example.library_commen.model.OrderBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 16:57
 * @change
 */
@SuppressLint("ValidFragment")
public class OrderListFragment extends BaseRecyclerRefreshFragment<OrderListContract.View,OrderListPresenter,OrderBean> implements OrderListContract.View {
    private String type;
    private List<OrderBean> orderBeanList=new ArrayList<>();
    @SuppressLint("ValidFragment")
    public OrderListFragment(String type) {
        this.type=type;
    }
    @Override
    public void initView() {
        presenter.setType(type);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getRecyclerAdapter().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                routerIntent(ArouterKey.MAP_MAPORDERDETAILACTIVITY,null);
            }
        });
    }

    @Override
    public void getData() {

    }

    @Override
    public OrderListPresenter getPresenter() {
        return new OrderListPresenter();
    }
    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new OrderAdapter(R.layout.item_order,orderBeanList);
    }
}
