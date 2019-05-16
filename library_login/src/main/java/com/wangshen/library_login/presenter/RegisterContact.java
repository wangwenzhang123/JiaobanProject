package com.wangshen.library_login.presenter;

import com.wangshen.base.ui.mvp.base.view.BaseView;
import com.wangshen.library_login.net.request.RequestRegisterBean;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class RegisterContact {
   public interface Presnter{
      void register(RequestRegisterBean requestRegisterBean);
      void upload(String path);
   }
   public interface View extends BaseView{
      void selectPic(int  code);

   }
}
