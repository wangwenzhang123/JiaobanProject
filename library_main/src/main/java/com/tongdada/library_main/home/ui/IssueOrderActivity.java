package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.home.presenter.IssueOrderContract;
import com.tongdada.library_main.home.presenter.IssueOrderPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/18.
 */
@Route(path = ArouterKey.MAIN_ISSUEORDERACTIVITY)
public class IssueOrderActivity extends BaseMvpActivity<IssueOrderPresenter> implements IssueOrderContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.issue_back_rl)
    RelativeLayout issueBackRl;
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
    @BindView(R2.id.issueorder_issue_iv)
    ImageView issueorderIssueIv;
    @BindView(R2.id.issueorder_distance_tv)
    TextView issueorderDistanceTv;
    @BindView(R2.id.issue_go_distance_iv)
    ImageView issueGoDistanceIv;
    @BindView(R2.id.issueorder_route_cl)
    ConstraintLayout issueorderRouteCl;
    @BindView(R2.id.issue_ordernumber_et)
    EditText issueOrdernumberEt;
    @BindView(R2.id.number_view)
    View numberView;
    @BindView(R2.id.issue_ordername_et)
    EditText issueOrdernameEt;
    @BindView(R2.id.order_number_view)
    View orderNumberView;
    @BindView(R2.id.issue_ordertime_et)
    EditText issueOrdertimeEt;
    @BindView(R2.id.start_order_time_iv)
    ImageView startOrderTimeIv;
    @BindView(R2.id.order_time_view)
    View orderTimeView;
    @BindView(R2.id.issue_total_tv)
    TextView issueTotalTv;
    @BindView(R2.id.issue_total_tv1)
    TextView issueTotalTv1;
    @BindView(R2.id.order_total_view)
    View orderTotalView;
    @BindView(R2.id.issue_vehicle_type_tv)
    TextView issueVehicleTypeTv;
    @BindView(R2.id.order_type_view)
    View orderTypeView;
    @BindView(R2.id.issue_order_ll)
    LinearLayout issueOrderLl;
    @BindView(R2.id.order_type_tv1)
    TextView orderTypeTv1;
    @BindView(R2.id.order_type_view1)
    View orderTypeView1;
    @BindView(R2.id.tv_note)
    TextView tvNote;
    @BindView(R2.id.et_note)
    EditText etNote;

    @Override
    public int getView() {
        return R.layout.activity_issueorder;
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
    public IssueOrderPresenter getPresenter() {
        return new IssueOrderPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.issueorder_start_tv)
    public void onViewClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SELECTADRESSACTIVITY).navigation(mContext);
    }

}
