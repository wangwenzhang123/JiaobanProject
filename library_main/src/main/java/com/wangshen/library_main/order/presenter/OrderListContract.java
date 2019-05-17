package com.wangshen.library_main.order.presenter;

import com.wangshen.base.ui.mvp.base.view.BaseView;
import com.wangshen.library_main.order.respose.OrderBean;

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
        void setData(List<OrderBean> list);
    }
    public interface Presenter{

    }
}
