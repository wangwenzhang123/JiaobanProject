package com.wangshen.library_main.order.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.library_main.MyViewPagerAdapter;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpFragment;
import com.wangshen.base.util.ToastUtils;
import com.wangshen.library_main.order.presenter.OrderContract;
import com.wangshen.library_main.user.ui.UserFragment;
import com.wangshen.library_main.widget.ViewPagerIndicator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import xu.viewpagerflextitle.ViewPagerTitle;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 9:46
 * @change
 */
public class OrderFragment extends BaseMvpFragment implements OrderContract.View {


    @BindView(R2.id.iv_order_search)
    ImageView ivOrderSearch;
    @BindView(R2.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R2.id.ll)
    LinearLayout ll;
    @BindView(R2.id.horizontal_scrollview)
    TabLayout horizontalScrollview;
    @BindView(R2.id.pager)
    ViewPager pager;
    Unbinder unbinder;
    List<String> list=new ArrayList<>()/*{"进行中","已完成","已卸货"}*/;
    private List<Fragment> fragments=new ArrayList<>();
    private MyViewPagerAdapter adapter;
    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_order;
    }

    @Override
    public BaseDialog getDialog() {

        return null;
    }

    @Override
    public void initView() {
        list.add("进行中");
        list.add("已完成");
        list.add("已卸货");
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        Observable.create(new ObservableOnSubscribe<List<Fragment>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Fragment>> e) throws Exception {
                fragments.add(new OrderListFragment());
                fragments.add(new OrderListFragment());
                fragments.add(new OrderListFragment());
                e.onNext(fragments);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Fragment>>() {
                    @Override
                    public void accept(final List<Fragment> fragments) throws Exception {
                        adapter = new MyViewPagerAdapter(getChildFragmentManager(), fragments);
                        pager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
                            @Override
                            public Fragment getItem(int position) {
                                return fragments.get(position);
                            }

                            @Override
                            public int getCount() {
                                return fragments.size();
                            }

                            @Nullable
                            @Override
                            public CharSequence getPageTitle(int position) {
                                return list.get(position);
                            }
                        });
                        horizontalScrollview.setupWithViewPager(pager);
                        horizontalScrollview.post(new Runnable() {
                            @Override
                            public void run() {
                                setIndicator(horizontalScrollview,32,32);
                            }
                        });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showToast(mContext,throwable.getMessage());
                    }
                });

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

    @OnClick(R2.id.iv_order_search)
    public void onViewClicked() {
    }
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
