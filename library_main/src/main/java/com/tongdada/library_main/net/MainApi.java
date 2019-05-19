package com.tongdada.library_main.net;

import com.tongdada.base.net.bean.BaseAppEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by wangshen on 2019/5/17.
 */

public interface MainApi {
    /**
     * 获取轮播页数据
     * @return
     */
    @POST("/interface/newsList.action")
    Observable<BaseAppEntity<Object>> shuffling(/*@Field("phone") String phone, @Field("password") String password*/);

    /**
     * 获取订单列表
     * @param requestBody
     * @return
     */
    @POST("/interface/uploadAttach.action")
    Observable<BaseAppEntity<Object>> upload(@Body RequestBody requestBody);
}
