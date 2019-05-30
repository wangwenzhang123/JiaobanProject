package com.example.library_commen.presenter;

import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/30.
 */

public class OrderDetailContract {
    public interface View extends BaseView{
        void setOrderDetail(OrderBean orderDetail);
    }
    public interface Presenter{
        void getOrderById(String id);
    }
}
