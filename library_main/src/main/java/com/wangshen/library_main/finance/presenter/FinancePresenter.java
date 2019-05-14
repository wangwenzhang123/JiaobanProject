package com.wangshen.library_main.finance.presenter;

import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.library_main.finance.net.FinanceApi;

/**
 * Created by wangshen on 2019/5/14.
 */

public class FinancePresenter extends BasePresenter<FinanceContract.View> implements FinanceContract.Presenter {
    private FinanceApi financeApi;
    public FinancePresenter() {
        financeApi= KRetrofitFactory.createService(FinanceApi.class);
    }
}
