package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.annotation.PluralsRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.home.adapter.TransportCarrAdapter;
import com.tongdada.library_main.home.presenter.TransportCarContract;
import com.tongdada.library_main.home.presenter.TransportCarPresenter;
import com.tongdada.library_main.home.respose.TransportCarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 11:32
 * @change
 */
public class TransportCarFragment extends BaseMvpFragment<TransportCarPresenter> implements TransportCarContract.View {

    @BindView(R2.id.transport_recycle)
    RecyclerView transportRecycle;
    Unbinder unbinder;
    private TransportCarrAdapter adapter;
    private List<TransportCarBean> transportCarBeanList=new ArrayList<>();
    @Override
    public int getViewId() {
        return R.layout.fragment_transport;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        transportRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new TransportCarrAdapter(R.layout.item_transport_car,transportCarBeanList);
        transportRecycle.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                routerIntent(ArouterKey.MAP_MAPCARDETAILACTIVITY,null);
            }
        });
    }

    @Override
    public void getData() {
        transportCarBeanList.add(new TransportCarBean());
        transportCarBeanList.add(new TransportCarBean());
        transportCarBeanList.add(new TransportCarBean());
        transportCarBeanList.add(new TransportCarBean());
        transportCarBeanList.add(new TransportCarBean());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public TransportCarPresenter getPresenter() {
        return new TransportCarPresenter();
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
