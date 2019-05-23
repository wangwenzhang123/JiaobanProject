package com.tongdada.library_main.net;

import com.tongdada.base.net.bean.BaseAppEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    Observable<BaseAppEntity<Object>> shuffling();
    /**
     * 发布订单
     */
    @FormUrlEncoded
    @POST("/interface/publishOrder.action")
    Observable<BaseAppEntity<Object>> publishOrder(@Field("psTotalOrders.stationId") String stationId,
                                                   @Field("psTotalOrders.orderAmount") String orderAmount,
                                                   @Field("psTotalOrders.startPlace") String startPlace,
                                                   @Field("psTotalOrders.destinationPlace") String destinationPlace,
                                                   @Field("psTotalOrders.startLongitude") String startLongitude,
                                                   @Field("psTotalOrders.startLatitude") String startLatitude,
                                                   @Field("psTotalOrders.dstLongitude") String dstLongitude,
                                                   @Field("psTotalOrders.dstLatitude") String dstLatitude,
                                                   @Field("psTotalOrders.totalDistance") String totalDistance,
                                                   @Field("psTotalOrders.perPrice") String perPrice,
                                                @Field("psTotalOrders.orderStatus") String orderStatus,
                                                @Field("psTotalOrders.orderName") String orderName,
                                                   @Field("psTotalOrders.carType") String carType,
                                                @Field("psTotalOrders.orderRemark") String orderRemark);
    /**
     * 获取订单列表
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/orderList.actio")
    Observable<BaseAppEntity<Object>> orderList(@Field("psTotalOrders.stationId") String stationId,
                                             @Field("pagination.pageNumber") String pageNumber,
                                             @Field("psTotalOrders.orderName") String orderName,
                                             @Field("psTotalOrders.orderStatus") String orderStatus);

    /**
     * 修改密码
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/orderList.actio")
    Observable<BaseAppEntity<Object>> editPassword(@Field("psAppUsers.id") String id,
                                                @Field("oldPassword") String oldPassword,
                                                @Field("newPassword") String newPassword);


}
