package com.wangshen.base.ui.mvp.base.refresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wangshen.base.R;
import com.wangshen.base.R2;
import com.wangshen.base.ui.mvp.base.adapter.BaseAdapter;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseFragment;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpFragment;
import com.wangshen.base.view.empty.IStateLayout;

import butterknife.BindView;

/**
 * description：列表页面基类
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/30 17:38
 * <p>
 */
public abstract class BaseRecyclerRefreshFragment<V extends BaseRecyclerRefreshContact.View, P extends BaseRecyclerRefreshPresenter> extends BaseMvpFragment<P> implements BaseRecyclerRefreshContact.View, OnRefreshListener, OnLoadMoreListener {

    @BindView(R2.id.tbl_title)
    TextView tblTitle;
    @BindView(R2.id.rv_content)
    RecyclerView rvContent;
    @BindView(R2.id.srl_layout)
    RefreshLayout srlLayout;
    @BindView(R2.id.ll_root)
    LinearLayout llRoot;
    @BindView(R2.id.st_state_layout)
    IStateLayout stStateLayout;
    @BindView(R2.id.ll_title_content)
    RelativeLayout llTitleContent;
    BaseAdapter adapter;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.ll_back)
    LinearLayout llBack;
    @Override
    public int getViewId() {
        return R.layout.common_activity_recycler_refresh;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        srlLayout.setOnRefreshListener(this);
        srlLayout.setOnLoadMoreListener(this);
        setRecyclerAdapter(rvContent);
        getBackView().setVisibility(View.GONE);
    }

    @Override
    public void setRecyclerAdapter(RecyclerView recyclerView) {
        adapter = createRecyclerAdapter();
        if (adapter == null) {
            return;
        }
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
        rvContent.setAdapter(adapter);
    }

    @Override
    public BaseAdapter getRecyclerAdapter() {
        return adapter;
    }

    @Override
    public void setCustomTitleLayout(View view) {
        if (view == null) {
            return;
        }
        ViewGroup parentView = (ViewGroup) view.getParent();
        if (parentView != null) {
            parentView.removeAllViews();
        }
        tblTitle.setVisibility(View.GONE);
        llTitleContent.addView(view);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        presenter.onRefresh(refreshLayout);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        presenter.onLoadMore(refreshLayout);
    }

    @Override
    public RefreshLayout getRefreshLayout() {
        return srlLayout;
    }


    @Override
    public void setEnableLoadMore(boolean enabled) {
        srlLayout.setEnableFooterFollowWhenLoadFinished(enabled);
        srlLayout.setEnableLoadMore(enabled);
    }
    @Override
    public ImageView getBackImage() {
        return backIv;
    }

    @Override
    public LinearLayout getBackView() {
        return llBack;
    }

    @Override
    public TextView getBackTextView() {
        return backTv;
    }
    @Override
    public void setEnableRefresh(boolean enabled) {
        srlLayout.setEnableRefresh(enabled);
    }

    @Override
    public void setEnableStateLayout(boolean enabled) {
        stStateLayout.setEnableStateLayout(enabled);
    }

    @Override
    public TextView getTitleBarLayout() {
        return tblTitle;
    }
}
