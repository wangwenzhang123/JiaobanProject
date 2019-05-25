package com.tongdada.library_main.user.presenter;

import com.example.library_commen.event.EventUpdateUser;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.user.respose.RequestBean;
import com.tongdada.library_main.utils.UserMapUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by wangshen on 2019/5/23.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.View>implements UserInfoContract.Presenter{

    @Override
    public void editUser(UserBean userBean) {
        MainApiUtils.getMainApi().editUser(UserMapUtils.getUserMap(userBean))
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        CommenUtils.getIncetance().setUserBean(userBeanBaseAppEntity.getContent());
                        EventBus.getDefault().post(new EventUpdateUser());
                        getView().showToast("修改成功");
                        getView().editUserSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
