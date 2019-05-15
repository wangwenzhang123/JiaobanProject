package com.wangshen.library_login.presenter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.library_login.net.LoginApi;
import com.wangshen.library_login.net.request.RequestRegisterBean;

import io.reactivex.functions.Consumer;

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
        loginApi.regist(requestRegisterBean)
                .compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {
                        getView().routerIntent(ArouterKey.LOGIN_SUBMITAUDITACTIVITY,null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
