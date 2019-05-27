package com.example.library_amap.model;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/27 10:45
 * @change
 */
public class CarBean {
    private String  name;
    private String phone;
    private double jing;
    private double wei;

    public CarBean(String name, String phone, double jing, double wei) {
        this.name = name;
        this.phone = phone;
        this.jing = jing;
        this.wei = wei;
    }

    public double getJing() {
        return jing;
    }

    public void setJing(double jing) {
        this.jing = jing;
    }

    public double getWei() {
        return wei;
    }

    public void setWei(double wei) {
        this.wei = wei;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
