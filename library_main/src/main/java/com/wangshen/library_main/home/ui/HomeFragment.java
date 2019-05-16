package com.wangshen.library_main.home.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.library_main.R;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpFragment;
import com.wangshen.library_main.home.presenter.HomeContract;
import com.zhouwei.mzbanner.holder.MZViewHolder;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 9:46
 * @change
 */
public class HomeFragment extends BaseMvpFragment implements HomeContract.View {


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

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }
    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
}
