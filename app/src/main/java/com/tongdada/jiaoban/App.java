package com.tongdada.jiaoban;


import com.tencent.bugly.Bugly;
import com.tongdada.base.appContext.AppContext;

/**
 * Created by Administrator on 2019/6/13.
 */

public class App extends AppContext {
    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "586de8cba7", false);
    }
}
