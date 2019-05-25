package com.tongdada.library_main.utils;

import com.example.library_commen.model.UserBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshen on 2019/5/24.
 */

public class UserMapUtils {
    public static Map<String,Object> getUserMap(UserBean userBean){
        Map<String,Object> map=new HashMap<>();
        map.put("psAppUsers.companyId",userBean.getCompanyId());
        map.put("psAppUsers.createUserID",userBean.getCreateUserID());
        map.put("psAppUsers.delFlag",userBean.getDelFlag());
        map.put("psAppUsers.deptId",userBean.getDeptId());
        map.put("psAppUsers.regTime",userBean.getRegTime());
        map.put("psAppUsers.stationId",userBean.getStationId());
        map.put("psAppUsers.stationRemarks",userBean.getStationRemarks());
        map.put("psAppUsers.updateUserID",userBean.getUpdateUserID());
        map.put("psAppUsers.driverId",userBean.getDriverId());
        map.put("psAppUsers.iconPic",userBean.getIconPic());
        map.put("psAppUsers.userContacts",userBean.getUserContacts());
        map.put("psAppUsers.userAddress",userBean.getUserAddress());
        map.put("psAppUsers.userPassword",userBean.getUserPassword());
        map.put("psAppUsers.userStatus",userBean.getUserStatus());
        map.put("psAppUsers.id",userBean.getId());
        map.put("psAppUsers.userName",userBean.getUserName());
        return map;
    }
}
