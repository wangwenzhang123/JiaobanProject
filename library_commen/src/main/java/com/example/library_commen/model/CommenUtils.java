package com.example.library_commen.model;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/23 16:23
 * @change
 */
public class CommenUtils {
    private static CommenUtils commenUtils;
    private UserBean userBean;
    private CommenUtils() {
    }
    public static CommenUtils getIncetance(){
        synchronized (CommenUtils.class){
            if (commenUtils == null){
                synchronized (CommenUtils.class){
                    commenUtils=new CommenUtils();
                }
            }
        }
        return commenUtils;
    }

    public UserBean getUserBean() {
        return (userBean== null)? new UserBean():userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
