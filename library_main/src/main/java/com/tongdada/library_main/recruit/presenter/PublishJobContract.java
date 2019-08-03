package com.tongdada.library_main.recruit.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.example.library_commen.model.RecuritListBean;

public class PublishJobContract {
    public interface View extends BaseView{
        void refrshUi();
    }
    public interface Presenter{
        void publishJob(RecuritListBean publishJobRequestBean);
        void cancelJob(String id);
    }
}
