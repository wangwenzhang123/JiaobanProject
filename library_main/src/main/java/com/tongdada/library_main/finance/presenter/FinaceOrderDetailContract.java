package com.tongdada.library_main.finance.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.example.library_commen.model.TransportCarBean;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 14:25
 * @change
 */
public class FinaceOrderDetailContract {
    public interface View extends BaseView{
        void setOrderDetail(TransportCarBean transportCarBean);
    }
    public interface Presenter{
         void getOrderDetail(String id);
    }
}
