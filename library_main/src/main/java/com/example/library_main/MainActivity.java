package com.example.library_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public int getView() {
        return 0;
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
}
