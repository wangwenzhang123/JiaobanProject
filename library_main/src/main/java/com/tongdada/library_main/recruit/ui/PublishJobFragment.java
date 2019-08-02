package com.tongdada.library_main.recruit.ui;


import android.widget.TextView;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.PublishJobRequestBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.recruit.presenter.PublishJobContract;
import com.tongdada.library_main.recruit.presenter.PublishJobPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PublishJobFragment extends BaseMvpFragment<PublishJobPresenter> implements PublishJobContract.View {

    @BindView(R2.id.job_name)
    TextView jobName;
    @BindView(R2.id.salary_range)
    TextView salaryRange;
    @BindView(R2.id.qualifications)
    TextView qualifications;
    @BindView(R2.id.work_name)
    TextView workName;
    @BindView(R2.id.work_address)
    TextView workAddress;
    @BindView(R2.id.work_contact)
    TextView workContact;
    @BindView(R2.id.contact_phone)
    TextView contactPhone;
    @BindView(R2.id.job_end_time)
    TextView jobEndTime;
    @BindView(R2.id.release_job)
    TextView releaseJob;
    private PublishJobRequestBean requestBean=new PublishJobRequestBean();
    @Override
    public PublishJobPresenter getPresenter() {
        return new PublishJobPresenter();
    }
    
    @Override
    public int getViewId() {
        return R.layout.fragment_publishjob;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

}
