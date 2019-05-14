package com.wangshen.library_login.net;

import com.wangshen.base.net.client.KRetrofitFactory;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/6 9:22
 * @change
 */
public class LoginNetUtils {
    private static LoginApi loginApi;
    public static LoginApi getLoginApi(){
        if (loginApi == null){
            loginApi= KRetrofitFactory.createService(LoginApi.class);
        }
        return loginApi;
    }
}
