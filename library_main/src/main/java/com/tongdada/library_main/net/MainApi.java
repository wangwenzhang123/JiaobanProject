package com.tongdada.library_main.net;

import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.user.respose.MessageBean;

import org.json.JSONObject;

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
    Observable<BannerBean> shuffling();
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
     * 修改订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/editOrder.action")
    Observable<BaseAppEntity<Object>> editOrder(@Field("orderId") String stationId);
    /**
     * 取消订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/cancelOrder.action")
    Observable<BaseAppEntity<Object>> cancelOrder(@Field("orderId") String stationId);
    /**
     * 修改密码
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/editPassword.action")
    Observable<BaseAppEntity<UserBean>> editPassword(@Field("psAppUsers.id") String id,
                                                @Field("oldPassword") String oldPassword,
                                                @Field("newPassword") String newPassword);
    /**
     * 人员列表
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/userList.action")
    Observable<BaseAppEntity<Object>> userList(@Field("psAppUsers.stationId") String id);

    /**
     * 修改人员信息
     * @return
     */

    @POST("/interface/editUser.action")
    Observable<BaseAppEntity<UserBean>> editUser(@Body UserBean requestBody/*@Field("psAppUsers.stationId") String id,@Field("psAppUsers.userName") String userName
            ,@Field("psAppUsers.userAddress") String userAddress
            ,@Field("psAppUsers.userContacts") String userContacts
            ,@Field("psAppUsers.iconPic") String iconPic*/);
    /**
     * 获取消息列表
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/messageList.action")
    Observable<MessageBean> messageList(@Field("psMessages.appUserId") String id, @Field("psMessages.messageContent") String messageContent);
    /**
     * 阅读消息
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/readMessage.action")
    Observable<BaseAppEntity<Object>> readMessage(@Field("psMessages.id") String id);
    /**
     * 阅读消息
     * @return
     */
    @FormUrlEncoded
    @POST("/interface/deleteMessage.action")
    Observable<BaseAppEntity<Object>> deleteMessage(@Field("psMessages.id") String id);
}
