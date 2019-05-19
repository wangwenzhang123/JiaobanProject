package com.tongdada.library_main.home.presenter;

import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/17.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{


    @Override
    public void shuffling() {
        MainApiUtils.getMainApi().shuffling().compose(this.<BaseAppEntity<Object>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
