package com.tongdada.library_main.finance.presenter;

import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.finance.net.FinanceApi;

/**
 * Created by wangshen on 2019/5/14.
 */

public class FinancePresenter extends BasePresenter<FinanceContract.View> implements FinanceContract.Presenter {
    private FinanceApi financeApi;
    public FinancePresenter() {
        financeApi= KRetrofitFactory.createService(FinanceApi.class);
    }
}
