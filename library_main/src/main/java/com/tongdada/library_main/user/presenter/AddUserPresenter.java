package com.tongdada.library_main.user.presenter;

import com.example.library_commen.event.EventAddBean;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.utils.UserMapUtils;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/24.
 */

public class AddUserPresenter extends BasePresenter<AddUserConstract.View> implements AddUserConstract.Presenter {

    @Override
    public void upload(String path, int dex) {

    }

    @Override
    public void addStationUser(UserBean userBean) {
        MainApiUtils.getMainApi().addStationUser(UserMapUtils.getUserMap(userBean))
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        getView().showToast("添加成功");
                        EventBus.getDefault().post(new EventAddBean());
                        getView().addStationUserSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

}
