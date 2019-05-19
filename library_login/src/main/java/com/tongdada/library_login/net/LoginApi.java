package com.tongdada.library_login.net;

import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.library_login.net.request.RequestRegisterBean;
import com.tongdada.library_login.net.respose.LoginBean;
import com.tongdada.library_login.net.respose.UploadBean;


import io.reactivex.Observable;
import okhttp3.RequestBody;
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
    Observable<BaseAppEntity<LoginBean>> login(@Field("phone") String phone, @Field("password") String password);

    @POST("/interface/uploadAttach.action")
    Observable<BaseAppEntity<UploadBean>> upload(@Body RequestBody requestBody);

    @POST("/interface/mixUserRegister.action")
    Observable<BaseAppEntity<LoginBean>> regist(@Body RequestRegisterBean params);
}
