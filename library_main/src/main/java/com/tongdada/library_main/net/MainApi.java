package com.tongdada.library_main.net;

import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.RequestRegisterBean;
import com.example.library_commen.model.UploadBean;
import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.order.respose.OrderListBean;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;
import com.tongdada.library_main.recruit.respose.ResumeBean;
import com.tongdada.library_main.user.respose.MessageBean;
import com.tongdada.library_main.user.respose.UserListBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
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
    @POST("/tonghe/newsList.action")
    Observable<BannerBean> shuffling();
    /**
     * 发布订单
     */
    @FormUrlEncoded
    @POST("/tonghe/publishOrder.action")
    Observable<BaseAppEntity<Object>> publishOrder(@FieldMap Map<String,Object> map
            /*@Field("psTotalOrders.stationId") String stationId,
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
                                                @Field("psTotalOrders.orderRemark") String orderRemark
            ,
                                                   @Field("psTotalOrders.publishTime") String publishTime
            ,
                                                   @Field("psTotalOrders.orderPic") String orderPic*/


    );
    /**
     * 获取订单列表
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/orderList.action")
    Observable<PagenationBase<OrderListBean>> orderList(@Field("psTotalOrders.stationId") String stationId,
                                                        @Field("page") String pageNumber,
                                                        @Field("psTotalOrders.orderName") String orderName,
                                                        @Field("psTotalOrders.orderStatus") String orderStatus);
    /**
     * 修改订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editOrder.action")
    Observable<BaseAppEntity<Object>> editOrder(@FieldMap Map<String,Object> stationId);
    /**
     * 取消订单
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/cancelOrder.action")
    Observable<BaseAppEntity<Object>> cancelOrder(@Field("orderId") String stationId);
    /**
     * 修改密码
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editPassword.action")
    Observable<BaseAppEntity<UserBean>> editPassword(@Field("psAppUsers.id") String id,
                                                @Field("oldPassword") String oldPassword,
                                                @Field("newPassword") String newPassword);
    /**
     * 人员列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/userList.action")
    Observable<UserListBean> userList(@Field("psAppUsers.stationId") String id);
    /**
     * 删除人员
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/deleteUser.action")
    Observable<UserListBean> deleteUser(@Field("psAppUsers.id") String id);

    /**
     * 修改人员信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editUser.action")
    Observable<BaseAppEntity<UserBean>> editUser(@FieldMap Map<String,Object> requestBody/*@Field("psAppUsers.stationId") String id,@Field("psAppUsers.userName") String userName
            ,@Field("psAppUsers.userAddress") String userAddress
            ,@Field("psAppUsers.userContacts") String userContacts
            ,@Field("psAppUsers.iconPic") String iconPic*/);
    /**
     * 添加人员
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/addStationUser.action")
    Observable<BaseAppEntity<UserBean>> addStationUser(@FieldMap Map<String,Object> requestBody);
    /**
     * 获取消息列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/messageList.action")
    Observable<MessageBean> messageList(@Field("psMessages.appUserId") String id, @Field("psMessages.messageContent") String messageContent);
    /**
     * 阅读消息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/readMessage.action")
    Observable<BaseAppEntity<Object>> readMessage(@Field("psMessages.id") String id);
    /**
     * 删除消息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/deleteMessage.action")
    Observable<BaseAppEntity<Object>> deleteMessage(@Field("psMessages.id") String id);
    /**
     * 系统设置
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/sysSet.action")
    Observable<BaseAppEntity<RequestRegisterBean>> sysSet(@Field("psMixingStations.id") String id,
                                                          @Field("psMixingStations.tongPrice") String tongPrice,
                                                          @Field("psMixingStations.carPriceThree") String carPriceThree,
                                                          @Field("psMixingStations.carPriceFive") String carPriceFive,
                                                          @Field("psMixingStations.carPriceSix") String carPriceSix,
                                                          @Field("psMixingStations.staticNormalPrice") String staticNormalPrice,
                                                          @Field("psMixingStations.staticPressurePrice") String staticPressurePrice);
    /**
     * 获取搅拌站信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/getMixStationById.action")
    Observable<BaseAppEntity<RequestRegisterBean>> getMixStationById(@Field("psMixingStations.id") String id);
    /**
     * 更新搅拌站信息
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/updateMixStation.action")
    Observable<BaseAppEntity<RequestRegisterBean>> updateMixStation(@FieldMap Map<String,Object> params);

    /**
     * 上传图片
     * @param requestBody
     * @return
     */
    @POST("/tonghe/uploadAttach.action")
    Observable<BaseAppEntity<UploadBean>> upload(@Body RequestBody requestBody);
    /**
     * 获取子订单列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/findDetailList.action")
    Observable<PagenationBase<CarOrderBean>> detailOrderList(@Field("psDetailOrders.stationId") String id, @Field("psDetailOrders.orderStatus") String orderStatus
            , @Field("psDetailOrders.orderRemark") String orderRemark,
                                                             @Field("page") String pageNumber, @Field("psDetailOrders.orderId") String orderId
    );
    /**
     * 发布招聘
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/publishPosition.action")
    Observable<PagenationBase<CarOrderBean>> publishPosition(/*@Field("psPositions.positionName") String positionName,
                                                             @Field("psPositions.positionSalary") String positionSalary,
                                                             @Field("psPositions.companyId") String companyId,
                                                             @Field("psPositions.positionRemarks") String positionRemarks,
                                                             @Field("psPositions.stationId") String stationId,
                                                             @Field("psPositions.companyName") String companyName,
                                                             @Field("psPositions.companyAddress") String companyAddress,
                                                             @Field("psPositions.contacts") String contacts,
                                                             @Field("psPositions.phoneNo") String phoneNo,
                                                             @Field("psPositions.endTime") String endTime,
                                                             @Field("psPositions.publishTime") String publishTime*/
            @FieldMap Map<String,Object> params
    );
    /**
     * 修改招聘
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/editPosition.action")
    Observable<PagenationBase<CarOrderBean>> editPosition(/*@Field("psPositions.positionName") String positionName,
                                                             @Field("psPositions.positionSalary") String positionSalary,
                                                             @Field("psPositions.companyId") String companyId,
                                                             @Field("psPositions.positionRemarks") String positionRemarks,
                                                             @Field("psPositions.stationId") String stationId,
                                                             @Field("psPositions.companyName") String companyName,
                                                             @Field("psPositions.companyAddress") String companyAddress,
                                                             @Field("psPositions.contacts") String contacts,
                                                             @Field("psPositions.phoneNo") String phoneNo,
                                                             @Field("psPositions.endTime") String endTime,
                                                             @Field("psPositions.publishTime") String publishTime*/
            @FieldMap Map<String,Object> params
    );
    /**
     * 获取招聘列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listPosition.action")
    Observable<PagenationBase<RecruitmentBean>> listPosition(@Field("psPositions.positionName") String positionName,
                                                             @Field("psPositions.companyId") String companyId,
                                                             @Field("psPositions.stationId") String stationId,
                                                             @Field("page") int page
    );
    /**
     * 取消招聘
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/cancelPosition.action")
    Observable<PagenationBase<RecruitmentBean>> cancelPosition(@Field("psPositions.id") String positionName
    );
    /**
     * 获取简历中心列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listApply.action")
    Observable<PagenationBase<ResumeBean>> listApply(@Field("psPositions.positionName") String positionName,
                                                     @Field("psPositions.companyId") String companyId,
                                                     @Field("psPositions.stationId") String stationId
    );
    /**
     * 获取简历列表
     * @return
     */
    @FormUrlEncoded
    @POST("/tonghe/listUsersOfPostion.action")
    Observable<PagenationBase<ResumeBean>> listUsersOfPostion(@Field("psPositionApply.positionId") String positionId,
                                                              @Field("psPositionApply.stationId") String stationId,
                                                              @Field("psPositionApply.companyId") String companyId,
                                                              @Field("page") int page

    );
}
