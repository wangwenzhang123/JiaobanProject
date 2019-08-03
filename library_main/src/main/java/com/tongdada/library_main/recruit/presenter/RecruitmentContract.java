package com.tongdada.library_main.recruit.presenter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshContact;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

import java.util.List;

public class RecruitmentContract {
    public interface View extends BaseView{
        BaseQuickAdapter getAdapter();
        SmartRefreshLayout getRefrshView();
    }
    public interface Presenter{
        void getData();
    }
}
