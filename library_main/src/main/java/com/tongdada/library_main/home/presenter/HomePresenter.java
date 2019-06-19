package com.tongdada.library_main.home.presenter;

import android.os.Handler;

import com.example.library_commen.event.EventMessageBran;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.RequestRegisterBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.order.respose.OrderListBean;
import com.tongdada.library_main.user.respose.MessageBean;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangshen on 2019/5/17.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    private int index=2;
    @Override
    public void getMixStationById() {
        MainApiUtils.getMainApi().getMixStationById(CommenUtils.getIncetance().getUserBean().getStationId())
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity != null && objectBaseAppEntity.getContent() != null){
                            CommenUtils.getIncetance().setRequestRegisterBean(objectBaseAppEntity.getContent());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }


    @Override
    public void shuffling() {
        MainApiUtils.getMainApi().shuffling().
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        if (bannerBean != null && bannerBean.getRows() != null && bannerBean.getRows().size() > 0){
                            getView().setBannerData(bannerBean.getRows());
                        }else {
                            getView().showToast("暂无数据");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
    @Override
    public void getMessageList() {
        MainApiUtils.getMainApi().messageList(CommenUtils.getIncetance().getUserBean().getId(),null)
                .compose(this.<MessageBean>handleEverythingResult(false))
                .subscribe(new Consumer<MessageBean>() {
                    @Override
                    public void accept(MessageBean objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity.getPagenation() != null && objectBaseAppEntity.getPagenation().getList().size() >0){
                            int a=0;
                            for (int i = 0; i < objectBaseAppEntity.getPagenation().getList().size() ; i++) {
                                MessageBean.PagenationBean.ListBean listBean=objectBaseAppEntity.getPagenation().getList().get(i);
                                if (listBean.getReadStatus().equals("N")){
                                    a++;
                                }
                            }
                            EventBus.getDefault().post(new EventMessageBran(a));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

}
