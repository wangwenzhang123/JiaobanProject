package com.wangshen.library_login.presenter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.library_login.net.LoginApi;
import com.wangshen.library_login.net.request.RequestRegisterBean;
import com.wangshen.library_login.net.request.respose.LoginBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class RegisterPresenter extends BasePresenter<RegisterContact.View> implements RegisterContact.Presnter {
    private LoginApi loginApi;

    public RegisterPresenter() {
        loginApi= KRetrofitFactory.createService(LoginApi.class);
    }

    @Override
    public void register(RequestRegisterBean requestRegisterBean) {
        Observable.create(new ObservableOnSubscribe<RequestRegisterBean>() {
            @Override
            public void subscribe(ObservableEmitter<RequestRegisterBean> e) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestRegisterBean>() {
                    @Override
                    public void accept(RequestRegisterBean requestRegisterBean) throws Exception {
                        loginApi.regist(requestRegisterBean)
                                .compose(RegisterPresenter.this.<BaseAppEntity<LoginBean>>handleEverythingResult())
                                .subscribe(new Consumer<BaseAppEntity<LoginBean>>() {
                                    @Override
                                    public void accept(BaseAppEntity<LoginBean> requestRegisterBean) throws Exception {
                                        getView().routerIntent(ArouterKey.LOGIN_SUBMITAUDITACTIVITY,null);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {

                                    }
                                });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }
}
