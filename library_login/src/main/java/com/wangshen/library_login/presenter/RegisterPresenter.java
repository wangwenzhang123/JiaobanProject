package com.wangshen.library_login.presenter;

import android.graphics.Bitmap;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.library_login.net.LoginApi;
import com.wangshen.library_login.net.request.RequestRegisterBean;
import com.wangshen.library_login.net.request.respose.LoginBean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 20:01
 * @change
 */
public class RegisterPresenter extends BasePresenter<RegisterContact.View> implements RegisterContact.Presnter {
    private LoginApi loginApi;

    public RegisterPresenter() {
        loginApi= KRetrofitFactory.createService(LoginApi.class);
    }

    @Override
    public void register(RequestRegisterBean requestRegisterBean) {
        Observable.create(new ObservableOnSubscribe<RequestRegisterBean>() {
            @Override
            public void subscribe(ObservableEmitter<RequestRegisterBean> e) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestRegisterBean>() {
                    @Override
                    public void accept(RequestRegisterBean requestRegisterBean) throws Exception {
                        loginApi.regist(requestRegisterBean)
                                .compose(RegisterPresenter.this.<BaseAppEntity<LoginBean>>handleEverythingResult())
                                .subscribe(new Consumer<BaseAppEntity<LoginBean>>() {
                                    @Override
                                    public void accept(BaseAppEntity<LoginBean> requestRegisterBean) throws Exception {
                                        getView().routerIntent(ArouterKey.LOGIN_SUBMITAUDITACTIVITY,null);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {

                                    }
                                });
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }
    private byte[] InputStream2ByteArray(String filePath)  {

        InputStream in = null;
        byte[] data=null;
        try {
            in = new FileInputStream(filePath);
            data = toByteArray(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return data;
    }
    private byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
    @Override
    public void upload(String path) {
        loginApi.upload(path,InputStream2ByteArray(path))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object objectBaseAppEntity) throws Exception {
                        Log.e("12312",objectBaseAppEntity.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("12312",throwable.getMessage());
                    }
                });
       /* loginApi.upload(path,body).compose(this.handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<Object>>() {
                    @Override
                    public void accept(BaseAppEntity<Object> objectBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });*/
    }
}
