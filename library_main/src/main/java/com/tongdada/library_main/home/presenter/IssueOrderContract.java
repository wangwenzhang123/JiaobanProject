package com.tongdada.library_main.home.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.home.request.IssueOrderBean;

/**
 * Created by wangshen on 2019/5/18.
 */

public class IssueOrderContract {
    public interface View extends BaseView{

    }
    public interface Presenter{
        void publishOrder(IssueOrderBean issueOrderBean);
    }
}
