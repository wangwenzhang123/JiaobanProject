package com.tongdada.library_main.finance.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.finance.adapter.FinaceCompleteAdapter;
import com.tongdada.library_main.finance.adapter.FinaceOrderAdapter;
import com.tongdada.library_main.finance.net.respose.FinaceBean;
import com.tongdada.library_main.finance.presenter.FinanceContract;
import com.tongdada.library_main.finance.presenter.FinancePresenter;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.home.respose.TransportCarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinanceOrderFragment extends BaseMvpFragment<FinancePresenter> implements FinanceContract.View {
    @BindView(R2.id.finance_order_recycle)
    RecyclerView financeOrderRecycle;
    @BindView(R2.id.check_all)
    TextView checkAll;
    @BindView(R2.id.settlement_bt)
    Button settlementBt;
    Unbinder unbinder;
    private FinaceOrderAdapter adapter;
    private List<TransportCarBean> list=new ArrayList<>();
    private boolean isCheckAll=false;
    @Override
    public int getViewId() {
        return R.layout.fragment_finance_order;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        financeOrderRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new FinaceOrderAdapter(R.layout.item_finace,list);
        financeOrderRecycle.setAdapter(adapter);
        presenter.detailOrderList();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //routerIntent(ArouterKey.FINANCE_FINACEORDERACTIVITY,null);
                ARouter.getInstance().build(ArouterKey.FINANCE_FINACEORDERACTIVITY).withString(IntentKey.MAP_ORDERID,list.get(position).getOrderId()).navigation(mContext);

            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    int id=view.getId();
                if (id == R.id.btn_select) {
                    TransportCarBean finaceBean=list.get(position);
                    if (finaceBean.isCheck()){
                        finaceBean.setCheck(false);
                    }else {
                        finaceBean.setCheck(true);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
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

    @OnClick(R2.id.check_all)
    public void onCheckAllClicked() {
        for (int i = 0; i < list.size(); i++) {
            if (!isCheckAll){
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        if (isCheckAll){
            isCheckAll=false;
        }else {
            isCheckAll=true;
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R2.id.settlement_bt)
    public void onSettlementBtClicked() {
    }

    @Override
    public void setOrderList(List<TransportCarBean> list) {
        adapter.setNewData(list);
    }
}
