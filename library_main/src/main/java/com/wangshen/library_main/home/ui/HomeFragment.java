package com.wangshen.library_main.home.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.library_main.R;
import com.example.library_main.R2;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpFragment;
import com.wangshen.base.util.ToastUtils;
import com.wangshen.library_main.home.presenter.HomeContract;
import com.wangshen.library_main.order.adapter.OrderAdapter;
import com.wangshen.library_main.order.respose.OrderBean;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 9:46
 * @change
 */
public class HomeFragment extends BaseMvpFragment implements HomeContract.View {


    @BindView(R2.id.iv_home_search)
    ImageView ivHomeSearch;
    @BindView(R2.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R2.id.ll)
    LinearLayout ll;
    @BindView(R2.id.banner)
    MZBannerView banner;
    @BindView(R2.id.home_order)
    TextView homeOrder;
    @BindView(R2.id.home_view)
    View homeView;
    @BindView(R2.id.home_order_rv)
    RecyclerView homeOrderRv;
    Unbinder unbinder;
    private OrderAdapter orderAdapter;
    private List<OrderBean> orderBeanList=new ArrayList<>();

    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        homeOrderRv.setLayoutManager(new LinearLayoutManager(mContext));
        orderAdapter=new OrderAdapter(R.layout.item_order,orderBeanList);
        homeOrderRv.setAdapter(orderAdapter);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderBeanList.add(new OrderBean());
        orderAdapter.setNewData(orderBeanList);
        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                ToastUtils.showToast(mContext,""+position);
            }
        });

        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

    }
    @Override
    public void onPause() {
        super.onPause();
        banner.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();//开始轮播
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

    @OnClick(R2.id.iv_home_search)
    public void onIvHomeSearchClicked() {
    }

    @OnClick(R2.id.iv_home_message)
    public void onIvHomeMessageClicked() {
    }

    @OnClick(R2.id.home_order)
    public void onHomeOrderClicked() {
    }

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {

            mImageView.setImageResource(data);
        }
    }
}
