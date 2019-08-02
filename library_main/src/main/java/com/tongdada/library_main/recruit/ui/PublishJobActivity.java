package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.PublishJobRequestBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.recruit.presenter.PublishJobContract;
import com.tongdada.library_main.recruit.presenter.PublishJobPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = ArouterKey.RECRUIT_PUBLISHJOBACTIVITY)
public class PublishJobActivity extends BaseMvpActivity<PublishJobPresenter> implements PublishJobContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.issue_back_rl)
    RelativeLayout issueBackRl;
    @BindView(R2.id.job_name)
    EditText jobName;
    @BindView(R2.id.salary_range)
    TextView salaryRange;
    @BindView(R2.id.qualifications)
    EditText qualifications;
    @BindView(R2.id.work_name)
    EditText workName;
    @BindView(R2.id.work_address)
    EditText workAddress;
    @BindView(R2.id.work_contact)
    EditText workContact;
    @BindView(R2.id.contact_phone)
    EditText contactPhone;
    @BindView(R2.id.job_end_time)
    EditText jobEndTime;
    @BindView(R2.id.release_job)
    TextView releaseJob;
    private PublishJobRequestBean requestBean=new PublishJobRequestBean();
    @Override
    public PublishJobPresenter getPresenter() {
        return new PublishJobPresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_publishjob;
    }

    @Override
    public void getData() {
        Bundle bundle=getIntent().getExtras();
        if (bundle == null){
            workAddress.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStationAddress());
            workContact.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStationContacts());
            workName.setText(CommenUtils.getIncetance().getRequestRegisterBean().getStationName());
            contactPhone.setText(CommenUtils.getIncetance().getRequestRegisterBean().getContactsPhone());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }

    @OnClick(R2.id.salary_range)
    public void onSalaryRangeClicked() {

    }

    @OnClick(R2.id.job_end_time)
    public void onJobEndTimeClicked() {

    }

    @OnClick(R2.id.release_job)
    public void onReleaseJobClicked() {
        String jobNameStr=jobName.getText().toString();
        String salaryRangeStr=salaryRange.getText().toString();
        String qualificationsStr=qualifications.getText().toString();
        String workNameStr=workName.getText().toString();
        String workAddressStr=workAddress.getText().toString();
        String workContactStr=workContact.getText().toString();
        String contactPhoneStr=contactPhone.getText().toString();
        String jobEndTimeStr=jobEndTime.getText().toString();
        requestBean.setStationId(CommenUtils.getIncetance().getRequestRegisterBean().getId());
        requestBean.setCompanyId(CommenUtils.getIncetance().getUserBean().getCompanyId());
        requestBean.setCompanyAddress(workAddressStr);
        requestBean.setPhoneNo(contactPhoneStr);
        requestBean.setEndTime(jobEndTimeStr);
        requestBean.setContacts(workContactStr);
        requestBean.setCompanyName(workNameStr);
        requestBean.setPositionRemarks(qualificationsStr);
        requestBean.setPositionSalary(salaryRangeStr);
        requestBean.setPositionName(jobNameStr);
        presenter.publishJob(requestBean);
    }
}
