package com.tongdada.library_main.order.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.OrderBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.order.adapter.OrderAdapter;
import com.tongdada.library_main.order.presenter.OrderContract;
import com.tongdada.library_main.order.presenter.OrderListPresenter;
import com.tongdada.library_main.widget.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.ORDER_SEARCHORDERACTIVITY)
public class SearchOrderActivity extends BaseMvpActivity<OrderListPresenter> implements OrderContract.View {
    @BindView(R2.id.select_search_tv)
    TextView selectSearchTv;
    @BindView(R2.id.history_fll)
    FlowLayout historyFll;
    @BindView(R2.id.search_recycle)
    RecyclerView searchRecycle;
    private OrderAdapter orderAdapter;
    private List<OrderBean> orderBeanList = new ArrayList<>();
    private String[] mVals = new String[]{"Java", "Android", "iOS", "Python",
            "Mac OS", "PHP", "JavaScript", "Objective-C",
            "Groovy", "Pascal", "Ruby", "Go", "Swift"};
    @Override
    public int getView() {
        return R.layout.activity_search_order;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        searchRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        orderAdapter=new OrderAdapter(R.layout.item_order,orderBeanList);
        searchRecycle.setAdapter(orderAdapter);
        for (int i = 0; i < mVals.length; i++) {
            TextView tv = (TextView) LayoutInflater.from(mContext).inflate(
                    R.layout.history_item, historyFll, false);
            tv.setText(mVals[i]);
            final String str = tv.getText().toString();
            //点击事件
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //加入搜索历史纪录记录

                }
            });
            historyFll.addView(tv);
        }
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.select_search_tv)
    public void onViewClicked() {
    }
}
