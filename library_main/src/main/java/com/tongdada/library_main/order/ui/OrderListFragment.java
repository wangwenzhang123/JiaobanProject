package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
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
public class OrderListFragment extends BaseMvpFragment<OrderListPresenter> implements OrderListContract.View {
    @BindView(R2.id.order_list_rv)
    RecyclerView orderListRv;
    Unbinder unbinder;
    private OrderAdapter orderAdapter;
    private List<OrderBean> orderBeanList = new ArrayList<>();

    @Override
    public void setData(List<OrderBean> list) {
        orderAdapter.setNewData(list);
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_orderlist;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        orderListRv.setLayoutManager(new LinearLayoutManager(mContext));
        orderAdapter=new OrderAdapter(R.layout.item_order,orderBeanList);
        orderListRv.setAdapter(orderAdapter);

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        orderBeanList.clear();
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderAdapter.setNewData(orderBeanList);
    }

    @Override
    public OrderListPresenter getPresenter() {
        return new OrderListPresenter();
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
