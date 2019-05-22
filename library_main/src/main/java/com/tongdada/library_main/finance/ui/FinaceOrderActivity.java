package com.tongdada.library_main.finance.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.finance.presenter.FinanceContract;
import com.tongdada.library_main.finance.presenter.FinancePresenter;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.FINANCE_FINACEORDERACTIVITY)
public class FinaceOrderActivity extends BaseMvpActivity<FinancePresenter> implements FinanceContract.View {
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

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public FinancePresenter getPresenter() {
        return new FinancePresenter();
    }
}
