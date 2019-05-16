package com.wangshen.library_login.net;

import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.library_login.net.request.RequestRegisterBean;
import com.wangshen.library_login.net.request.respose.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wangshen on 2019/5/13.
 */

public interface LoginApi {
    @FormUrlEncoded
    @POST("/interface/userLogin.action")
    Observable<BaseAppEntity<LoginBean>> login(@Field("phone") String phone,@Field("password") String password);
    @FormUrlEncoded
    @POST("/interface/mixUserRegister.action")
    Observable<BaseAppEntity<LoginBean>> regist(@Body RequestRegisterBean params);
}
