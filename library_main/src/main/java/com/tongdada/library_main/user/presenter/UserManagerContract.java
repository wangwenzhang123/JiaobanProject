package com.tongdada.library_main.user.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.user.respose.UserListBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/24.
 */

public class UserManagerContract {
    public interface View extends BaseView{
        void setUserList(List<UserListBean.PagenationBean.ListBean> list);
    }
    public interface Presenter{
        void getUserList();
        void deleteUser(String id);
    }
}
