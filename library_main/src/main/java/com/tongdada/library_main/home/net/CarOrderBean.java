package com.tongdada.library_main.home.net;

import com.example.library_commen.model.TransportCarBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/28.
 */

public class CarOrderBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 2
     * list : [{"acceptTime":"2019-05-24 22:29:54","carId":"3","carNo":"苏A123452","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverId":"12","driverName":"dasd","id":"2334","orderAmount":"123","orderId":"2334232","orderPrice":"2","orderRemark":"阿达阿达","orderStatus":"A","stationId":"4028830d6abb5115016abb860c110005","stationName":"s22s","totalDistance":"3","updateTime":null,"updateUserID":""},{"acceptTime":"2019-05-24 22:29:54","carId":"3","carNo":"苏A123452","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverId":"3","driverName":"实打实 ","id":"12312","orderAmount":"23123","orderId":"2334232","orderPrice":"123","orderRemark":"dasdasd撒大蘇打","orderStatus":"A","stationId":"4028830d6abb5115016abb860c110005","stationName":"达到","totalDistance":"123123","updateTime":null,"updateUserID":""}]
     * listOfObject : [{"acceptTime":"2019-05-24 22:29:54","carId":"3","carNo":"苏A123452","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverId":"12","driverName":"dasd","id":"2334","orderAmount":"123","orderId":"2334232","orderPrice":"2","orderRemark":"阿达阿达","orderStatus":"A","stationId":"4028830d6abb5115016abb860c110005","stationName":"s22s","totalDistance":"3","updateTime":null,"updateUserID":""},{"acceptTime":"2019-05-24 22:29:54","carId":"3","carNo":"苏A123452","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverId":"3","driverName":"实打实 ","id":"12312","orderAmount":"23123","orderId":"2334232","orderPrice":"123","orderRemark":"dasdasd撒大蘇打","orderStatus":"A","stationId":"4028830d6abb5115016abb860c110005","stationName":"达到","totalDistance":"123123","updateTime":null,"updateUserID":""}]
     * objectsPerPage : 10
     * pageNumber : 1
     * pageSize : 10
     * searchId :
     * sortCriterion :
     * sortDirection : {"code":2,"name":"ascending"}
     * sortType : ascending
     * totalCount : 2
     */

    private boolean exportAllData;
    private int firstResult;
    private int fullListSize;
    private int objectsPerPage;
    private int pageNumber;
    private int pageSize;
    private String searchId;
    private String sortCriterion;
    private SortDirectionBean sortDirection;
    private String sortType;
    private int totalCount;
    private List<TransportCarBean> list;
    private List<ListOfObjectBean> listOfObject;

    public boolean isExportAllData() {
        return exportAllData;
    }

    public void setExportAllData(boolean exportAllData) {
        this.exportAllData = exportAllData;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getFullListSize() {
        return fullListSize;
    }

    public void setFullListSize(int fullListSize) {
        this.fullListSize = fullListSize;
    }

    public int getObjectsPerPage() {
        return objectsPerPage;
    }

    public void setObjectsPerPage(int objectsPerPage) {
        this.objectsPerPage = objectsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSortCriterion() {
        return sortCriterion;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    public SortDirectionBean getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirectionBean sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<TransportCarBean> getList() {
        return list;
    }

    public void setList(List<TransportCarBean> list) {
        this.list = list;
    }

    public List<ListOfObjectBean> getListOfObject() {
        return listOfObject;
    }

    public void setListOfObject(List<ListOfObjectBean> listOfObject) {
        this.listOfObject = listOfObject;
    }

    public static class SortDirectionBean {
        /**
         * code : 2
         * name : ascending
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static class ListOfObjectBean {
        /**
         * acceptTime : 2019-05-24 22:29:54
         * carId : 3
         * carNo : 苏A123452
         * createTime : null
         * createUserID :
         * delFlag : 0
         * deptId :
         * driverId : 12
         * driverName : dasd
         * id : 2334
         * orderAmount : 123
         * orderId : 2334232
         * orderPrice : 2
         * orderRemark : 阿达阿达
         * orderStatus : A
         * stationId : 4028830d6abb5115016abb860c110005
         * stationName : s22s
         * totalDistance : 3
         * updateTime : null
         * updateUserID :
         */

        private String acceptTime;
        private String carId;
        private String carNo;
        private Object createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String driverId;
        private String driverName;
        private String id;
        private String orderAmount;
        private String orderId;
        private String orderPrice;
        private String orderRemark;
        private String orderStatus;
        private String stationId;
        private String stationName;
        private String totalDistance;
        private Object updateTime;
        private String updateUserID;

        public String getAcceptTime() {
            return acceptTime;
        }

        public void setAcceptTime(String acceptTime) {
            this.acceptTime = acceptTime;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getCreateUserID() {
            return createUserID;
        }

        public void setCreateUserID(String createUserID) {
            this.createUserID = createUserID;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(String orderAmount) {
            this.orderAmount = orderAmount;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderPrice() {
            return orderPrice;
        }

        public void setOrderPrice(String orderPrice) {
            this.orderPrice = orderPrice;
        }

        public String getOrderRemark() {
            return orderRemark;
        }

        public void setOrderRemark(String orderRemark) {
            this.orderRemark = orderRemark;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getStationId() {
            return stationId;
        }

        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getTotalDistance() {
            return totalDistance;
        }

        public void setTotalDistance(String totalDistance) {
            this.totalDistance = totalDistance;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUserID() {
            return updateUserID;
        }

        public void setUpdateUserID(String updateUserID) {
            this.updateUserID = updateUserID;
        }
    }
}
