package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventAdressBean;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.IssueOrderBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.home.presenter.IssueOrderContract;
import com.tongdada.library_main.home.presenter.IssueOrderPresenter;
import com.tongdada.library_main.widget.datepicker.CustomDatePicker;
import com.tongdada.library_main.widget.datepicker.DateFormatUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    TextView issueOrdernumberEt;
    @BindView(R2.id.number_view)
    View numberView;
    @BindView(R2.id.issue_ordername_et)
    EditText issueOrdernameEt;
    @BindView(R2.id.order_number_view)
    View orderNumberView;
    @BindView(R2.id.issue_ordertime_et)
    TextView issueOrdertimeEt;
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
    @BindView(R2.id.select_route)
    TextView selectRoute;
    @BindView(R2.id.rb_tong)
    RadioButton rbTong;
    @BindView(R2.id.rb_beng)
    RadioButton rbBeng;
    @BindView(R2.id.rg_16)
    RadioButton rg16;
    @BindView(R2.id.rg_18)
    RadioButton rg18;
    @BindView(R2.id.rg_20)
    RadioButton rg20;
    @BindView(R2.id.rg_type)
    RadioGroup rgType;
    @BindView(R2.id.release_order)
    TextView releaseOrder;
    @BindView(R2.id.order_amount)
    EditText orderAmount;
    @BindView(R2.id.order_price)
    TextView orderPrice;
    @BindView(R2.id.order_pic)
    ImageView orderPic;
    private IssueOrderBean issueOrderBean = new IssueOrderBean();

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
        EventBus.getDefault().register(this);
        issueOrderBean.setCarType("T16");
        initTimerPicker();
    }


    @OnClick(R2.id.issueorder_start_tv)
    public void onIssueorderStartTvClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SELECTADRESSACTIVITY).withInt(IntentKey.MAP_TYPE, 0).navigation(mContext);
    }

    @OnClick(R2.id.select_route)
    public void onSelectRouteClicked() {
        if (TextUtils.isEmpty(issueOrderBean.getStartLatitude())) {
            ToastUtils.showToast(mContext, "请先选择出发地！");
            return;
        }
        if (TextUtils.isEmpty(issueOrderBean.getDstLatitude())) {
            ToastUtils.showToast(mContext, "请先选择目的地！");
            return;
        }
        ARouter.getInstance().build(ArouterKey.MAP_ROUTEACTIVITY).withSerializable(IntentKey.MAP_ADDRESS, issueOrderBean).navigation(mContext);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventAdress(EventAdressBean adressBean) {
        if (adressBean.getCode() == 0) {
            issueOrderBean.setStartLatitude(String.valueOf(adressBean.getLatitude()));
            issueOrderBean.setStartLongitude(String.valueOf(adressBean.getLongitude()));
            issueOrderBean.setStartPlace(adressBean.getAdressName());
            issueorderStartTv.setText(adressBean.getAdressName());
        } else {
            issueOrderBean.setDestinationPlace(adressBean.getAdressName());
            issueOrderBean.setDstLatitude(String.valueOf(adressBean.getLatitude()));
            issueOrderBean.setDstLongitude(String.valueOf(adressBean.getLongitude()));
            issueorderEndTv.setText(adressBean.getAdressName());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventRoute(IssueOrderBean adressBean) {
        issueOrderBean.setStartLatitude(String.valueOf(adressBean.getStartLatitude()));
        issueOrderBean.setStartLongitude(String.valueOf(adressBean.getStartLongitude()));
        issueOrderBean.setStartPlace(adressBean.getStartPlace());
        issueorderStartTv.setText(adressBean.getStartPlace());
        issueOrderBean.setDestinationPlace(adressBean.getDestinationPlace());
        issueOrderBean.setDstLatitude(String.valueOf(adressBean.getDstLatitude()));
        issueOrderBean.setDstLongitude(String.valueOf(adressBean.getDstLongitude()));
        issueorderEndTv.setText(adressBean.getDestinationPlace());
        selectRoute.setText(adressBean.getTotalDistance());
    }

    @OnClick(R2.id.issueorder_end_tv)
    public void onIssueorderEndTvClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SELECTADRESSACTIVITY).withInt(IntentKey.MAP_TYPE, 1).navigation(mContext);
    }

    private CustomDatePicker mTimerPicker;

    private void initTimerPicker() {

        String beginTime = DateFormatUtils.long2Str(System.currentTimeMillis(), true);
        String endTime = DateFormatUtils.long2Str(System.currentTimeMillis() + 315360000000L, true);
        issueOrdertimeEt.setText(beginTime);

        // 通过日期字符串初始化日期，格式请用：yyyy-MM-dd HH:mm
        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                issueOrdertimeEt.setText(DateFormatUtils.long2Str(timestamp, true));
            }
        }, beginTime, endTime);
        // 允许点击屏幕或物理返回键关闭
        mTimerPicker.setCancelable(true);
        // 显示时和分
        mTimerPicker.setCanShowPreciseTime(true);
        // 允许循环滚动
        mTimerPicker.setScrollLoop(true);
        // 允许滚动动画
        mTimerPicker.setCanShowAnim(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R2.id.rb_tong)
    public void onRbTongClicked() {
        rgType.setVisibility(View.VISIBLE);
        int id = rgType.getCheckedRadioButtonId();
        if (id == R.id.rg_16) {
            issueOrderBean.setCarType("T16");
        } else if (id == R.id.rg_18) {
            issueOrderBean.setCarType("T18");
        } else if (id == R.id.rg_20) {
            issueOrderBean.setCarType("T20");
        }
    }

    @OnClick(R2.id.rb_beng)
    public void onRbBengClicked() {
        rgType.setVisibility(View.INVISIBLE);
        issueOrderBean.setCarType("B");
    }

    @OnClick(R2.id.rg_16)
    public void onRg16Clicked() {
        issueOrderBean.setCarType("T16");
    }

    @OnClick(R2.id.rg_18)
    public void onRg18Clicked() {
        issueOrderBean.setCarType("T18");
    }

    @OnClick(R2.id.rg_20)
    public void onRg20Clicked() {
        issueOrderBean.setCarType("T20");
    }

    @OnClick(R2.id.release_order)
    public void onViewClicked() {
        if (TextUtils.isEmpty(issueOrdertimeEt.getText().toString())) {
            showToast("请选择订单时间");
            return;
        }
        if (TextUtils.isEmpty(issueOrdernameEt.getText().toString())) {
            showToast("请填写订单发布单位");
            return;
        }
        if (TextUtils.isEmpty(issueOrdernumberEt.getText().toString())) {
            showToast("请选择订单订单编号");
            return;
        }
        if (TextUtils.isEmpty(orderAmount.getText().toString().trim())) {
            showToast("请选择订单数量");
            return;
        }
        issueOrderBean.setOrderName(issueOrdernameEt.getText().toString());
        issueOrderBean.setOrderAmount(orderAmount.getText().toString().trim());
        issueOrderBean.setPerPrice(orderPrice.getText().toString());
        issueOrderBean.setStationId(CommenUtils.getIncetance().getUserBean().getStationId());
        presenter.publishOrder(issueOrderBean);
    }

    @OnClick(R2.id.issue_ordertime_et)
    public void onViewTimeClicked() {
        mTimerPicker.show(issueOrdertimeEt.getText().toString());
    }

    @Override
    public void publishSuccess() {
        finish();
    }

    @OnClick(R2.id.order_pic)
    public void onViewPicClicked() {
    }
}
