package com.tongdada.library_main.home.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshFragment;
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
@SuppressLint("ValidFragment")
public class TransportCarFragment extends BaseRecyclerRefreshFragment<TransportCarContract.View,TransportCarPresenter> implements TransportCarContract.View {
    private String type;

    public TransportCarFragment(String type) {
        this.type = type;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
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
                routerIntent(ArouterKey.MAP_MAPCARDETAILACTIVITY,null);
            }
        });
    }

    @Override
    public void getData() {

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
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new TransportCarrAdapter(R.layout.item_transport_car,new ArrayList<TransportCarBean>());
    }
}
