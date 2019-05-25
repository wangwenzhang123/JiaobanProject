package com.tongdada.library_main.order.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.example.library_commen.model.OrderBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 17:00
 * @change
 */
public class OrderListContract {
    public interface View extends BaseView{
        void setData(List<OrderBean> list,String type);
    }
    public interface Presenter{
        void getOrderList(String type);
    }
}
