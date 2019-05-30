package com.tongdada.library_main.finance.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.TransportCarBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.finance.presenter.FinaceOrderDetailContract;
import com.tongdada.library_main.finance.presenter.FinaceOrderDetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.FINANCE_FINACEORDERACTIVITY)
public class FinaceOrderActivity extends BaseMvpActivity<FinaceOrderDetailPresenter> implements FinaceOrderDetailContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.text1)
    TextView text1;
    @BindView(R2.id.distance_text)
    TextView distanceText;
    @BindView(R2.id.text2)
    TextView text2;
    @BindView(R2.id.transport_carnumber)
    TextView transportCarnumber;
    @BindView(R2.id.driver_name)
    TextView driverName;
    @BindView(R2.id.driver_phone)
    TextView driverPhone;
    @BindView(R2.id.accept_total)
    TextView acceptTotal;
    @BindView(R2.id.driver_attribution)
    TextView driverAttribution;
    @BindView(R2.id.now_loading)
    TextView nowLoading;
    @BindView(R2.id.unit_price)
    TextView unitPrice;
    @BindView(R2.id.order_code)
    TextView orderCode;
    @BindView(R2.id.order_release_name)
    TextView orderReleaseName;
    @BindView(R2.id.order_start_time)
    TextView orderStartTime;
    @BindView(R2.id.order_total)
    TextView orderTotal;
    @BindView(R2.id.car_type)
    TextView carType;
    @BindView(R2.id.car_xinghao)
    TextView carXinghao;
    @BindView(R2.id.order_remark)
    TextView orderRemark;
    @BindView(R2.id.confirm_the_settlement)
    TextView confirmTheSettlement;
    @BindView(R2.id.order_start)
    TextView orderStart;
    @BindView(R2.id.order_end)
    TextView orderEnd;
    private TransportCarBean transportCarBean;

    @Override
    public int getView() {
        return R.layout.activity_finance_order;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        String id = getIntent().getStringExtra(IntentKey.MAP_ORDERID);
        presenter.getOrderDetail(id);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public FinaceOrderDetailPresenter getPresenter() {
        return new FinaceOrderDetailPresenter();
    }

    @Override
    public void setOrderDetail(TransportCarBean transportCarBean) {
        this.transportCarBean = transportCarBean;
        //orderStart.setText(transportCarBean.getS);
        //orderEnd.setText();
        distanceText.setText(transportCarBean.getTotalDistance()+"km");
        //orderTotal.setText();
        driverName.setText(transportCarBean.getDriverName());
        //driverPhone.setText(transportCarBean.get);
        acceptTotal.setText(transportCarBean.getOrderAmount()+"方");
        transportCarnumber.setText(transportCarBean.getCarNo());
        orderRemark.setText(transportCarBean.getOrderRemark());
        orderStartTime.setText(transportCarBean.getAcceptTime());
        orderCode.setText(transportCarBean.getStationName());
        unitPrice.setText(transportCarBean.getOrderPrice());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.confirm_the_settlement)
    public void onConfirmTheSettlementClicked() {

    }
}
