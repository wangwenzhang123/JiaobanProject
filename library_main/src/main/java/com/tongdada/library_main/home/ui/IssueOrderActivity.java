package com.tongdada.library_main.home.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.appkey.SettingString;
import com.example.library_commen.event.EventAdressBean;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.OrderBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.home.presenter.IssueOrderContract;
import com.tongdada.library_main.home.presenter.IssueOrderPresenter;
import com.tongdada.library_main.widget.datepicker.CustomDatePicker;
import com.tongdada.library_main.widget.datepicker.DateFormatUtils;
import com.winfo.photoselector.PhotoSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

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
    CheckBox rg16;
    @BindView(R2.id.rg_18)
    CheckBox rg18;
    @BindView(R2.id.rg_20)
    CheckBox rg20;
    @BindView(R2.id.rg_type)
    LinearLayout rgType;
    @BindView(R2.id.release_order)
    TextView releaseOrder;
    @BindView(R2.id.order_amount)
    EditText orderAmount;
    @BindView(R2.id.order_price)
    TextView orderPrice;
    @BindView(R2.id.order_pic)
    ImageView orderPic;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.tong_ll)
    LinearLayout tongLl;
    @BindView(R2.id.rb_beng_qi)
    RadioButton rbBengQi;
    @BindView(R2.id.rb_beng_gu)
    RadioButton rbBengGu;
    @BindView(R2.id.beng_carType_ll)
    LinearLayout bengCarTypeLl;
    @BindView(R2.id.beng_1)
    RadioButton beng1;
    @BindView(R2.id.beng_2)
    RadioButton beng2;
    @BindView(R2.id.beng_3)
    RadioButton beng3;
    @BindView(R2.id.beng_type)
    RadioGroup bengType;
    @BindView(R2.id.beng_qi_ll)
    LinearLayout bengQiLl;
    @BindView(R2.id.gu_1)
    RadioButton gu1;
    @BindView(R2.id.gu_2)
    RadioButton gu2;
    @BindView(R2.id.beng_gu_ll)
    LinearLayout bengGuLl;
    @BindView(R2.id.order_price_beng)
    TextView orderPriceBeng;
    @BindView(R2.id.bang_ll)
    LinearLayout bangLl;
    @BindView(R2.id.beng_gu_type)
    RadioGroup bengGuType;
    @BindView(R2.id.platform_phone_tv)
    TextView platformPhoneTv;
    @BindView(R2.id.issue_endtime_et)
    TextView issueEndtimeEt;
    @BindView(R2.id.end_order_time_iv)
    ImageView endOrderTimeIv;
    private OrderBean issueOrderBean = new OrderBean();
    private static final int ORDER_PIC = 0;
    private boolean isUpdate = false;

    @Override
    public int getView() {
        return R.layout.activity_issueorder;
    }

    @Override
    public void initView() {
        orderPrice.setText(CommenUtils.getIncetance().getRequestRegisterBean().getTongPrice());
        orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceThree());
        issueOrdernumberEt.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStationName());
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + CommenUtils.getIncetance().getRequestRegisterBean().getLogoPic()).apply(requestOptions).into(orderPic);
        issueOrderBean.setOrderPic(CommenUtils.getIncetance().getRequestRegisterBean().getLogoPic());
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
        platformPhoneTv.setText(SettingString.PHONE);
        issueOrdernameEt.setText(CommenUtils.getIncetance().getRequestRegisterBean().getContactsPhone());
    }

    @Override
    public void getData() {
        OrderBean orderBean = (OrderBean) getIntent().getSerializableExtra(IntentKey.ORDER_BEAN);
        if (orderBean != null) {
            issueOrderBean = orderBean;
            isUpdate = true;
            initUi();
        }
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
    public void eventRoute(OrderBean adressBean) {
        issueOrderBean.setStartLatitude(String.valueOf(adressBean.getStartLatitude()));
        issueOrderBean.setStartLongitude(String.valueOf(adressBean.getStartLongitude()));
        issueOrderBean.setStartPlace(adressBean.getStartPlace());
        issueorderStartTv.setText(adressBean.getStartPlace());
        issueOrderBean.setDestinationPlace(adressBean.getDestinationPlace());
        issueOrderBean.setDstLatitude(String.valueOf(adressBean.getDstLatitude()));
        issueOrderBean.setDstLongitude(String.valueOf(adressBean.getDstLongitude()));
        issueorderEndTv.setText(adressBean.getDestinationPlace());
        selectRoute.setText(adressBean.getTotalDistance());
        issueOrderBean.setTotalDistance(adressBean.getTotalDistance());
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
        issueEndtimeEt.setText(beginTime);
        // 通过日期字符串初始化日期，格式请用：yyyy-MM-dd HH:mm
        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                if (isEnd){
                    issueEndtimeEt.setText(DateFormatUtils.long2Str(timestamp, true));
                }else {
                    issueOrdertimeEt.setText(DateFormatUtils.long2Str(timestamp, true));
                }

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
        tongLl.setVisibility(View.VISIBLE);
        bangLl.setVisibility(View.GONE);
        orderPrice.setText(CommenUtils.getIncetance().getRequestRegisterBean().getTongPrice());
       /* int id = rgType.getCheckedRadioButtonId();
        if (id == R2.id.rg_16) {
            issueOrderBean.setCarType("T16");
        } else if (id == R2.id.rg_18) {
            issueOrderBean.setCarType("T18");
        } else if (id == R2.id.rg_20) {
            issueOrderBean.setCarType("T20");
        }*/
    }

    @OnClick(R2.id.rb_beng)
    public void onRbBengClicked() {
        tongLl.setVisibility(View.GONE);
        bangLl.setVisibility(View.VISIBLE);

    }

    @OnClick(R2.id.rg_16)
    public void onRg16Clicked() {
        issueOrderBean.setCarType("T16");
    }

    private void getCheckTong() {
        String caType = null;
        if (rg16.isChecked()) {
            caType = "T16";
        }
        if (rg18.isChecked()) {
            caType = caType + ",T18";
        }
        if (rg20.isChecked()) {
            caType = caType + ",T20";
        }
        issueOrderBean.setCarType(caType);
    }

    private void getCheckBang() {
        if (rbBengQi.isChecked()) {
            int id = bengType.getCheckedRadioButtonId();
            if (id == R.id.beng_1) {
                issueOrderBean.setCarType("B1");
            } else if (id == R.id.beng_2) {
                issueOrderBean.setCarType("B2");
            } else {
                issueOrderBean.setCarType("B3");
            }
        } else {
            int id = bengGuType.getCheckedRadioButtonId();
            if (id == R.id.gu_1) {
                issueOrderBean.setCarType("B4");
            } else {
                issueOrderBean.setCarType("B5");
            }
        }
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

        if (TextUtils.isEmpty(orderAmount.getText().toString().trim())) {
            showToast("请选择订单数量");
            return;
        }
        issueOrderBean.setOrderAmount(orderAmount.getText().toString().trim());
        issueOrderBean.setOrderPhone(issueOrdernameEt.getText().toString().trim());
        issueOrderBean.setStationId(CommenUtils.getIncetance().getUserBean().getStationId());
        issueOrderBean.setPublishTime(issueOrdertimeEt.getText().toString().trim());
        issueOrderBean.setOrderRemark(etNote.getText().toString().trim());
        if (rbTong.isChecked()) {
            getCheckTong();
            issueOrderBean.setPerPrice(orderPrice.getText().toString());
        } else {
            getCheckBang();
            issueOrderBean.setPerPrice(orderPriceBeng.getText().toString());
        }
        if (TextUtils.isEmpty(issueOrderBean.getCarType())) {
            showToast("请选择车辆类型");
            return;
        }
        if (TextUtils.isEmpty(issueOrderBean.getStartPlace())) {
            showToast("请选择出发地");
            return;
        }
        if (TextUtils.isEmpty(issueOrderBean.getDestinationPlace())) {
            showToast("请选择目的地");
            return;
        }
        if (TextUtils.isEmpty(issueOrderBean.getTotalDistance())) {
            showToast("请选择路线");
            return;
        }
        if (isUpdate) {
            presenter.editOrder(issueOrderBean);
        } else {
            presenter.publishOrder(issueOrderBean);
        }
    }
    private boolean isEnd=false;
    @OnClick(R2.id.issue_ordertime_et)
    public void onViewTimeClicked() {
        isEnd=false;
        mTimerPicker.show(issueOrdertimeEt.getText().toString());
    }

    @Override
    public void publishSuccess() {
        EventBus.getDefault().post(new OrderBean());
        finish();
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(IssueOrderActivity.this, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case ORDER_PIC:
                    //单选的话 images就只有一条数据直接get(0)即可
                    List<String> images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Log.e(TGA, "1=" + images.get(0));
                    Glide.with(mContext).load(images.get(0)).into(orderPic);
                    presenter.upload(images.get(0));
                    break;
            }
        }
    }

    @Override
    public void uploadSuccess(String path, String url) {
        Glide.with(mContext).load(path).into(orderPic);
        issueOrderBean.setOrderPic(url);
    }

    @Override
    public void initUi() {
        issueorderStartTv.setText(issueOrderBean.getStartPlace());
        issueOrdertimeEt.setText(issueOrderBean.getPublishTime());
        issueorderEndTv.setText(issueOrderBean.getDestinationPlace());
        selectRoute.setText(issueOrderBean.getTotalDistance());
        etNote.setText(issueOrderBean.getOrderRemark());
        issueOrdernameEt.setText(issueOrderBean.getOrderPhone());
        orderPrice.setText(issueOrderBean.getPerPrice());
        orderAmount.setText(issueOrderBean.getOrderAmount());
        releaseOrder.setText("确认修改");
        title.setText("修改订单");
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + issueOrderBean.getOrderPic()).apply(requestOptions).into(orderPic);

        issueOrdernumberEt.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStationName());
        if (issueOrderBean.getCarType().contains("B")) {
            rbBeng.setChecked(true);
            tongLl.setVisibility(View.GONE);
            bangLl.setVisibility(View.VISIBLE);
            switch (issueOrderBean.getCarType()) {
                case "B1":
                    bengQiLl.setVisibility(View.VISIBLE);
                    bengGuLl.setVisibility(View.GONE);
                    beng1.setChecked(true);
                    rbBengQi.setChecked(true);
                    break;
                case "B2":
                    bengQiLl.setVisibility(View.VISIBLE);
                    bengGuLl.setVisibility(View.GONE);
                    beng2.setChecked(true);
                    rbBengQi.setChecked(true);
                    break;
                case "B3":
                    bengQiLl.setVisibility(View.VISIBLE);
                    bengGuLl.setVisibility(View.GONE);
                    beng3.setChecked(true);
                    rbBengQi.setChecked(true);
                    break;
                case "B4":
                    rbBengGu.setChecked(true);
                    bengQiLl.setVisibility(View.GONE);
                    bengGuLl.setVisibility(View.VISIBLE);
                    gu1.setChecked(true);

                    break;
                case "B5":
                    rbBengGu.setChecked(true);
                    bengQiLl.setVisibility(View.GONE);
                    bengGuLl.setVisibility(View.VISIBLE);
                    gu2.setChecked(true);

                    break;
            }
        } else {
            rbTong.setChecked(true);
            tongLl.setVisibility(View.VISIBLE);
            bangLl.setVisibility(View.GONE);
            switch (issueOrderBean.getCarType()) {
                case "T16":
                    rg16.setChecked(true);
                    break;
                case "T18":
                    rg18.setChecked(true);
                    break;
                case "T20":
                    rg20.setChecked(true);
                    break;
            }
            if (!issueOrderBean.getCarType().contains("T16")) {
                rg16.setChecked(false);
            }
            if (!issueOrderBean.getCarType().contains("T18")) {
                rg18.setChecked(false);
            }
            if (!issueOrderBean.getCarType().contains("T20")) {
                rg20.setChecked(false);
            }
        }
    }

    @OnClick(R2.id.order_pic)
    public void onViewPicClicked() {
        selectPic(ORDER_PIC);
    }

    @OnClick({R2.id.register_back, R2.id.back_tv})
    public void onViewClicked(View view) {
        finish();
    }

    @OnClick(R2.id.rb_beng_qi)
    public void onRbBengQiClicked() {
        bengQiLl.setVisibility(View.VISIBLE);
        bengGuLl.setVisibility(View.GONE);
        int id = bengType.getCheckedRadioButtonId();
        if (id == R.id.beng_1) {
            orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceThree());
        } else if (id == R.id.beng_2) {
            orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceFive());
        } else {
            orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceSix());
        }
    }

    @OnClick(R2.id.rb_beng_gu)
    public void onRbBengGuClicked() {
        bengQiLl.setVisibility(View.GONE);
        bengGuLl.setVisibility(View.VISIBLE);
        int id = bengGuType.getCheckedRadioButtonId();
        if (id == R.id.gu_1) {
            orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStaticNormalPrice());
        } else {
            orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStaticPressurePrice());
        }
    }

    @OnClick(R2.id.beng_1)
    public void onBeng1Clicked() {
        orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceThree());
    }

    @OnClick(R2.id.beng_2)
    public void onBeng2Clicked() {
        orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceFive());
    }

    @OnClick(R2.id.beng_3)
    public void onBeng3Clicked() {
        orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceSix());
    }

    @OnClick(R2.id.gu_1)
    public void onGu1Clicked() {
        orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStaticNormalPrice());
    }

    @OnClick(R2.id.gu_2)
    public void onGu2Clicked() {
        orderPriceBeng.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStaticPressurePrice());
    }

    @OnClick(R2.id.platform_phone_tv)
    public void onViewPhoneClicked() {

    }

    @OnClick({R2.id.issue_endtime_et, R2.id.end_order_time_iv})
    public void onViewEndClicked(View view) {
        isEnd=true;
        mTimerPicker.show(issueEndtimeEt.getText().toString());
    }
}
