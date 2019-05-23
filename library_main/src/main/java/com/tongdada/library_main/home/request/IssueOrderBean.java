package com.tongdada.library_main.home.request;

import retrofit2.http.Field;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/23 15:38
 * @change
 */
public class IssueOrderBean {
    String stationId;
    String orderAmount;
    String startPlace;
    String destinationPlace;
    String startLongitude;
    String startLatitude;
    String dstLongitude;
    String dstLatitude;
    String totalDistance;
    String perPrice;
    String orderStatus;
    String orderName;
    String carType;
    String orderRemark;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getDstLongitude() {
        return dstLongitude;
    }

    public void setDstLongitude(String dstLongitude) {
        this.dstLongitude = dstLongitude;
    }

    public String getDstLatitude() {
        return dstLatitude;
    }

    public void setDstLatitude(String dstLatitude) {
        this.dstLatitude = dstLatitude;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(String perPrice) {
        this.perPrice = perPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
}
