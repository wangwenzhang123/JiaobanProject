package com.example.library_amap.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.MapView;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/21 9:32
 * @change
 */
public class RouteActivity extends BaseActivity {

    @BindView(R2.id.route_map)
    MapView routeMap;
    @BindView(R2.id.issueorder_start_iv)
    ImageView issueorderStartIv;
    @BindView(R2.id.issueorder_start_tv)
    TextView issueorderStartTv;
    @BindView(R2.id.issue_go_start_iv)
    ImageView issueGoStartIv;
    @BindView(R2.id.start_view)
    View startView;
    @BindView(R2.id.issueorder_end_iv)
    ImageView issueorderEndIv;
    @BindView(R2.id.issueorder_end_tv)
    TextView issueorderEndTv;
    @BindView(R2.id.issue_go_end_iv)
    ImageView issueGoEndIv;
    @BindView(R2.id.end_view)
    View endView;
    @BindView(R2.id.issueorder_route_cl)
    ConstraintLayout issueorderRouteCl;

    @Override
    public int getView() {
        return R.layout.activity_route;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
