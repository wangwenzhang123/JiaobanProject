package com.tongdada.library_main.home.presenter;

import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.request.IssueOrderBean;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/18.
 */

public class IssueOrderPresenter extends BasePresenter<IssueOrderContract.View> implements IssueOrderContract.Presenter {

    @Override
    public void publishOrder(IssueOrderBean issueOrderBean) {
        MainApiUtils.getMainApi().publishOrder(issueOrderBean.getStationId(),issueOrderBean.getOrderAmount(),issueOrderBean.getStartPlace(),issueOrderBean.getDestinationPlace(),issueOrderBean.getStartLongitude(),
                issueOrderBean.getStartLatitude(),issueOrderBean.getDstLongitude(),issueOrderBean.getDstLatitude(),issueOrderBean.getTotalDistance(),issueOrderBean.getPerPrice(),issueOrderBean.getOrderStatus(),issueOrderBean.getOrderName(),
                issueOrderBean.getCarType(),issueOrderBean.getOrderRemark())
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }
}
