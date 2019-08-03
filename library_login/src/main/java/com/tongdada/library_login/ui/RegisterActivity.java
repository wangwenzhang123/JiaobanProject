package com.tongdada.library_login.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventAdressBean;
import com.example.library_commen.model.RequestRegisterBean;
import com.example.library_commen.utils.CheckUtils;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;
import com.tongdada.library_login.presenter.RegisterContact;
import com.tongdada.library_login.presenter.RegisterPresenter;
import com.winfo.photoselector.PhotoSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 21:38
 * @change
 */
@Route(path = ArouterKey.LOGIN_REGISTERACTIVITY)
public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements RegisterContact.View {

    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.et_unit_name)
    EditText etUnitName;
    @BindView(R2.id.et_contact)
    EditText etContact;
    @BindView(R2.id.et_legal_person)
    EditText etLegalPerson;
    @BindView(R2.id.et_contact_phone)
    EditText etContactPhone;
    @BindView(R2.id.et_address)
    TextView etAddress;
    @BindView(R2.id.et_registered_capital)
    EditText etRegisteredCapital;
    @BindView(R2.id.iv_add)
    ImageView ivAdd;
    @BindView(R2.id.ll_legal_positive)
    LinearLayout llLegalPositive;
    @BindView(R2.id.iv_legal_positive)
    ImageView ivLegalPositive;
    @BindView(R2.id.ll_legal_reverse)
    LinearLayout llLegalReverse;
    @BindView(R2.id.iv_legal_reverse)
    ImageView ivLegalReverse;
    @BindView(R2.id.ll_business_license)
    LinearLayout llBusinessLicense;
    @BindView(R2.id.iv_business_license)
    ImageView ivBusinessLicense;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;
    private static final int IVLEGALPOSITIVE_CODE = 1;
    private static final int IVLEGALREVERSE_CODE = 2;
    private static final int IVBUSINESSLICENSE_CODE = 3;
    private RequestRegisterBean requestRegisterBean;

    @Override
    public int getView() {
        return R.layout.activity_register;
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
        requestRegisterBean = new RequestRegisterBean();
    }

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(RegisterActivity.this, code);
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case IVLEGALPOSITIVE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive);
                requestRegisterBean.setFrontPic(url);
                break;
            case IVLEGALREVERSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse);
                requestRegisterBean.setBackPic(url);
                break;
            case IVBUSINESSLICENSE_CODE:
                Glide.with(mContext).load(path).into(ivBusinessLicense);
                requestRegisterBean.setLicensePic(url);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case IVLEGALPOSITIVE_CODE:
                    //单选的话 images就只有一条数据直接get(0)即可
                    List<String> images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Log.e(TGA, "1=" + images.get(0));
                    Glide.with(mContext).load(images.get(0)).into(ivLegalPositive);
                    presenter.upload(images.get(0), IVLEGALPOSITIVE_CODE);
                    break;
                case IVLEGALREVERSE_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images2 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images2.get(0)).into(ivLegalReverse);
                    Log.e(TGA, "2=" + images2.get(0));
                    presenter.upload(images2.get(0), IVLEGALREVERSE_CODE);
                    break;
                case IVBUSINESSLICENSE_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(ivBusinessLicense);
                    presenter.upload(images3.get(0), IVBUSINESSLICENSE_CODE);
                    Log.e(TGA, "3=" + images3.get(0));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventAdress(EventAdressBean adressBean) {
        etAddress.setText(adressBean.getAdressName());
        requestRegisterBean.setStationLatitude(String.valueOf(adressBean.getLatitude()));
        requestRegisterBean.setStationLongitude(String.valueOf(adressBean.getLongitude()));
    }

    @OnClick(R2.id.ll_legal_positive)
    public void onLlLegalPositiveClicked() {
        selectPic(IVLEGALPOSITIVE_CODE);
    }

    @OnClick(R2.id.ll_legal_reverse)
    public void onLlLegalReverseClicked() {
        selectPic(IVLEGALREVERSE_CODE);
    }

    @OnClick(R2.id.ll_business_license)
    public void onLlBusinessLicenseClicked() {
        selectPic(IVBUSINESSLICENSE_CODE);
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {

        String unitName = etUnitName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String legalPerson = etLegalPerson.getText().toString().trim();
        String contactPhone = etContactPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String registeredCapital = etRegisteredCapital.getText().toString().trim();
        if (TextUtils.isEmpty(unitName)) {
            showToast("请输入公司名称！");
            return;
        }
        if (TextUtils.isEmpty(contact)) {
            showToast("请输入联系人！");
            return;
        }
        if (TextUtils.isEmpty(legalPerson)) {
            showToast("请输入公司法人！");
            return;
        }
        if (TextUtils.isEmpty(contactPhone)) {
            showToast("请输入联系人电话！");
            return;
        }
        if (TextUtils.isEmpty(address)) {
            showToast("请输入公司地址！");
            return;
        }
        if (TextUtils.isEmpty(registeredCapital)) {
            showToast("请输入公司注册资金！");
            return;
        }
        if (!CheckUtils.isChinaPhoneLegal(contactPhone)) {
            showToast("请输入正确的手机号！");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getFrontPic())) {
            showToast("请先上传法人身份证正面照片！");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getBackPic())) {
            showToast("请先上传法人身份证反面照片！");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getLicensePic())) {
            showToast("请先上传营业执照！");
            return;
        }
        requestRegisterBean.setContactsPhone(contactPhone);
        requestRegisterBean.setRegisterCapital(registeredCapital);
        requestRegisterBean.setStationAddress(address);
        requestRegisterBean.setLegalPersion(legalPerson);
        requestRegisterBean.setStationName(unitName);
        requestRegisterBean.setStationContacts(contact);
        presenter.register(requestRegisterBean);
    }

    @OnClick(R2.id.et_address)
    public void onViewClicked() {
        ARouter.getInstance().build(ArouterKey.MAP_SELECTADRESSACTIVITY).withInt(IntentKey.MAP_TYPE, 0).navigation(mContext);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
