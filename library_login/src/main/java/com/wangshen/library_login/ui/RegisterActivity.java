package com.wangshen.library_login.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpActivity;
import com.wangshen.library_login.R;
import com.wangshen.library_login.R2;
import com.wangshen.library_login.net.request.RequestRegisterBean;
import com.wangshen.library_login.presenter.RegisterContact;
import com.wangshen.library_login.presenter.RegisterPresenter;
import com.winfo.photoselector.PhotoSelector;

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
    EditText etAddress;
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
    private static final int IVLEGALPOSITIVE_CODE=1;
    private static final int IVLEGALREVERSE_CODE=2;
    private static final int IVBUSINESSLICENSE_CODE=3;
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

    }

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void selectPic(int  code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(RegisterActivity.this, code);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case IVLEGALPOSITIVE_CODE:
                    //单选的话 images就只有一条数据直接get(0)即可
                    List<String> images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Log.e(TGA,"1="+images.get(0));
                    Glide.with(mContext).load(images.get(0)).into(ivLegalPositive);
                    break;
                case IVLEGALREVERSE_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images2 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images2.get(0)).into(ivLegalReverse);
                    Log.e(TGA,"2="+images2.get(0));
                    break;
                case IVBUSINESSLICENSE_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(ivBusinessLicense);
                    Log.e(TGA,"3="+images3.get(0));
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
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
        RequestRegisterBean requestRegisterBean=new RequestRegisterBean();
        String unitName=etUnitName.getText().toString().trim();
        String contact=etContact.getText().toString().trim();
        String legalPerson=etLegalPerson.getText().toString().trim();
        String contactPhone=etContactPhone.getText().toString().trim();
        String address=etAddress.getText().toString().trim();
        String registeredCapital=etRegisteredCapital.getText().toString().trim();
        if (TextUtils.isEmpty(unitName)){
            showToast("请输入公司名称！");
            return;
        }
        if (TextUtils.isEmpty(contact)){
            showToast("请输入联系人！");
            return;
        }
        if (TextUtils.isEmpty(legalPerson)){
            showToast("请输入公司法人！");
            return;
        }
        if (TextUtils.isEmpty(contactPhone)){
            showToast("请输入联系人电话！");
            return;
        }
        if (TextUtils.isEmpty(address)){
            showToast("请输入公司地址！");
            return;
        }
        if (TextUtils.isEmpty(registeredCapital)){
            showToast("请输入公司注册资金！");
            return;
        }
        requestRegisterBean.setContactsPhone(contactPhone);
        requestRegisterBean.setRegisterCapita(registeredCapital);
        requestRegisterBean.setStationAddress(address);
        requestRegisterBean.setLegalPersion(legalPerson);
        requestRegisterBean.setStationName(unitName);
        requestRegisterBean.setStationContacts(contact);
        presenter.register(requestRegisterBean);
    }
}
