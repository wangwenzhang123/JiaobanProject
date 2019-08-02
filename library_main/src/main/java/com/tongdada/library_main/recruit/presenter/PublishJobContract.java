package com.tongdada.library_main.recruit.presenter;

import com.example.library_commen.model.PublishJobRequestBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

public class PublishJobContract {
    public interface View extends BaseView{

    }
    public interface Presenter{
        void publishJob(PublishJobRequestBean publishJobRequestBean);
    }
}
