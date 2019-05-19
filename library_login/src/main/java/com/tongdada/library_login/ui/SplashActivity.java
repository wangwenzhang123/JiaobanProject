package com.tongdada.library_login.ui;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.base.util.SharedPreferencesUtil;
import com.tongdada.library_login.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class SplashActivity extends BaseActivity {



    @Override
    public int getView() {
        return R.layout.activity_splash;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        SplashActivityPermissionsDispatcher.getFristWithPermissionCheck(this);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void getFrist() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (SharedPreferencesUtil.getInstance().isFirstRun(mContext)){
                    startActivity(new Intent(mContext,LoginActivity.class));
                }else {
                    startActivity(new Intent(mContext,LoginActivity.class));
                }
                finish();
            }
        }).start();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
