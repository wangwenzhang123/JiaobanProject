package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.OrderSetContract;
import com.tongdada.library_main.user.presenter.OrderSetPrensenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/23 14:56
 * @change
 */
@Route(path = ArouterKey.USER_SETORDER)
public class OrderSettingActivity extends BaseMvpActivity<OrderSetPrensenter> implements OrderSetContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.tongche_et)
    EditText tongcheEt;
    @BindView(R2.id.sure_change)
    TextView sureChange;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.bang_1et)
    EditText bang1et;
    @BindView(R2.id.bang_2_et)
    EditText bang2Et;
    @BindView(R2.id.bang_3_et)
    EditText bang3Et;
    @BindView(R2.id.bang_4_et)
    EditText bang4Et;
    @BindView(R2.id.bang_5_et)
    EditText bang5Et;

    @Override
    public int getView() {
        return R.layout.activity_order_setting;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        tongcheEt.setText(CommenUtils.getIncetance().getRequestRegisterBean().getTongPrice());
        bang1et.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceThree());
        bang2Et.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceFive());
        bang3Et.setText(CommenUtils.getIncetance().getRequestRegisterBean().getCarPriceSix());
        bang4Et.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStaticNormalPrice());
        bang5Et.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStaticPressurePrice());
    }

    @Override
    public OrderSetPrensenter getPresenter() {
        return new OrderSetPrensenter();
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

    @OnClick(R2.id.sure_change)
    public void onSureChangeClicked() {
        if (!TextUtils.isEmpty(tongcheEt.getText().toString().trim()) &&
                !TextUtils.isEmpty(bang1et.getText().toString().trim()) &&
                !TextUtils.isEmpty(bang2Et.getText().toString().trim() )&&
                !TextUtils.isEmpty(bang3Et.getText().toString().trim()) &&
                !TextUtils.isEmpty(bang4Et.getText().toString().trim())&&
                !TextUtils.isEmpty(bang5Et.getText().toString().trim())
                ) {
            presenter.sysSet(tongcheEt.getText().toString().trim(),
                    bang1et.getText().toString().trim(),
                    bang2Et.getText().toString().trim(),
                    bang3Et.getText().toString().trim(),
                    bang4Et.getText().toString().trim(),
                    bang5Et.getText().toString().trim()
                    );
        } else {
            showToast("输入不能为空");
        }

    }

    @Override
    public void sysSetSuccess() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onViewClicked() {
        finish();
    }
}
