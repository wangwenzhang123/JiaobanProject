package com.tongdada.library_main.order.presenter;

import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.home.respose.TransportCarBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 17:29
 * @change
 */
public class AcceptOrderDetailContract {
    public interface View extends BaseView{
        void setOrderList(List<TransportCarBean> list);
    }
    public interface Presenter{
        void detailOrderList(String id);
    }
}
