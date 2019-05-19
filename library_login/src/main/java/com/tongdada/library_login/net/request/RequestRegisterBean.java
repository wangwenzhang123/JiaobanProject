package com.tongdada.library_login.net.request;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/15 15:43
 * @change
 */
public class RequestRegisterBean {
    private String stationName;//搅拌站名称
    private String stationAddress;//搅拌站地址
    private String stationContacts;//搅拌站联系人
    private String legalPersion;//搅拌站法人
    private String contactsPhone;//搅拌站联系电话
    private String registerCapita;//搅拌站注册资金
    private String stationRemarks;//搅拌站备注信息
    private String licensePic;//搅拌站营业执照
    private String frontPic;//搅拌站身份证正面
    private String backPic;//搅拌站身份证反面

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getStationContacts() {
        return stationContacts;
    }

    public void setStationContacts(String stationContacts) {
        this.stationContacts = stationContacts;
    }

    public String getLegalPersion() {
        return legalPersion;
    }

    public void setLegalPersion(String legalPersion) {
        this.legalPersion = legalPersion;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getRegisterCapita() {
        return registerCapita;
    }

    public void setRegisterCapita(String registerCapita) {
        this.registerCapita = registerCapita;
    }

    public String getStationRemarks() {
        return stationRemarks;
    }

    public void setStationRemarks(String stationRemarks) {
        this.stationRemarks = stationRemarks;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public String getFrontPic() {
        return frontPic;
    }

    public void setFrontPic(String frontPic) {
        this.frontPic = frontPic;
    }

    public String getBackPic() {
        return backPic;
    }

    public void setBackPic(String backPic) {
        this.backPic = backPic;
    }
}
