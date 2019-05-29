package com.example.library_amap.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 10:56
 * @change
 */
public class MapCarDetailContract  {
    public interface View extends BaseView{

    }
    public interface Presenter{
        void getDetailOrderById(String orderid);
    }
}
