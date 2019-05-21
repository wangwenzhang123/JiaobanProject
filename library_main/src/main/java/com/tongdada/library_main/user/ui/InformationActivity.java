package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.PATCH;

/**
 * Created by wangshen on 2019/5/20.
 */
@Route(path = ArouterKey.USER_INFORMATIONACTIVITY)
public class InformationActivity extends BaseActivity {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.information_conten)
    FrameLayout messageConten;

    @Override
    public int getView() {
        return R.layout.activity_information;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.information_conten,new InformationFragment())
                .commit();
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

    @OnClick(R2.id.register_back)
    public void onViewClicked() {
        finish();
    }
}
