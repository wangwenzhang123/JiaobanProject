package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.adapter.UserManagerAdapter;
import com.tongdada.library_main.user.respose.UserManagerBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:06
 * @change
 */
@Route(path = ArouterKey.USER_USERMANAGERACTIVITY)
public class UserManagerActivity extends BaseMvpActivity<BasePresenter> {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.user_manager_recycle)
    RecyclerView userManagerRecycle;
    private List<UserManagerBean> userManagerBeanList=new ArrayList<>();
    private UserManagerAdapter adapter;
    @Override
    public int getView() {
        return R.layout.activity_usermanager;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        userManagerRecycle.setLayoutManager(new LinearLayoutManager(this));
        adapter=new UserManagerAdapter(R.layout.item_usermanager,userManagerBeanList);
        userManagerRecycle.setAdapter(adapter);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        userManagerBeanList.add(new UserManagerBean());
        userManagerBeanList.add(new UserManagerBean());
        userManagerBeanList.add(new UserManagerBean());
        userManagerBeanList.add(new UserManagerBean());
        adapter.notifyDataSetChanged();
    }

    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onViewClicked() {
    }
}
