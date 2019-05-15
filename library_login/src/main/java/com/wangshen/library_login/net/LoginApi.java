package com.wangshen.library_login.net;

import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.library_login.net.request.RequestRegisterBean;

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
    @POST("sample/sampleRequst")
    Observable<BaseAppEntity<Object>> login(@Field("billnumber") String params);
    @FormUrlEncoded
    @POST("sample/sampleRequst")
    Observable<BaseAppEntity<Object>> regist(@Body RequestRegisterBean params);
}
