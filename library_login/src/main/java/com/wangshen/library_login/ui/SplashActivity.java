package com.wangshen.library_login.ui;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.ui.BaseActivity;
import com.wangshen.base.util.SharedPreferencesUtil;
import com.wangshen.library_login.R;

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
        SplashActivityPermissionsDispatcher.getFristWithPermissionCheck(this);
    }

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void getFrist() {
        if (SharedPreferencesUtil.getInstance().isFirstRun(mContext)){
            startActivity(new Intent(this,LoginActivity.class));
        }else {
            startActivity(new Intent(this,LoginActivity.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
