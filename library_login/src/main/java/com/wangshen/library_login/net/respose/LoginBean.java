package com.wangshen.library_login.net.respose;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/16 12:35
 * @change
 */
public class LoginBean {

    /**
     * companyId :
     * createTime : {"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119}
     * createUserID :
     * delFlag : 0
     * deptId :
     * driverId :
     * id : 4028830d6abe6beb016abe6fc92c0002
     * regTime : 2019-05-16 10:19:16
     * stationId : 4028830d6abe6beb016abe6f84300001
     * stationRemarks :
     * updateTime : null
     * updateUserID :
     * userAddress :
     * userContacts : 1893234123
     * userName : ad
     * userPassword : 999999
     * userStatus : N
     */

    private String companyId;
    private CreateTimeBean createTime;
    private String createUserID;
    private int delFlag;
    private String deptId;
    private String driverId;
    private String id;
    private String regTime;
    private String stationId;
    private String stationRemarks;
    private Object updateTime;
    private String updateUserID;
    private String userAddress;
    private String userContacts;
    private String userName;
    private String userPassword;
    private String userStatus;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public CreateTimeBean getCreateTime() {
        return createTime;
    }

    public void setCreateTime(CreateTimeBean createTime) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationRemarks() {
        return stationRemarks;
    }

    public void setStationRemarks(String stationRemarks) {
        this.stationRemarks = stationRemarks;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(String userContacts) {
        this.userContacts = userContacts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public static class CreateTimeBean {
        /**
         * date : 16
         * day : 4
         * hours : 10
         * minutes : 19
         * month : 4
         * nanos : 0
         * seconds : 18
         * time : 1557973158000
         * timezoneOffset : -480
         * year : 119
         */

        private int date;
        private int day;
        private int hours;
        private int minutes;
        private int month;
        private int nanos;
        private int seconds;
        private long time;
        private int timezoneOffset;
        private int year;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getNanos() {
            return nanos;
        }

        public void setNanos(int nanos) {
            this.nanos = nanos;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getTimezoneOffset() {
            return timezoneOffset;
        }

        public void setTimezoneOffset(int timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}

