package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by wangshen on 2019/5/23.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.View>implements UserInfoContract.Presenter{

    @Override
    public void editUser(UserBean userBean) {
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("psAppUsers.userName",userBean.getUserName());
            jsonObject.put("psAppUsers.userAddress",userBean.getUserAddress());
            jsonObject.put("psAppUsers.userContacts",userBean.getUserContacts());
            jsonObject.put("psAppUsers.iconPic",userBean.getIconPic());
            jsonObject.put("psAppUsers.id",userBean.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jsonObject.toString());

        MainApiUtils.getMainApi().editUser(jsonObject)
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {
                        CommenUtils.getIncetance().setUserBean(userBeanBaseAppEntity.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
