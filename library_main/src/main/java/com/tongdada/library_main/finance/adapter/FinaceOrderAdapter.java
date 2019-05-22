package com.tongdada.library_main.finance.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinaceOrderAdapter  extends BaseQuickAdapter<FinaceBean,BaseViewHolder>{
    public FinaceOrderAdapter(int layoutResId, @Nullable List<FinaceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final FinaceBean item) {
        CheckBox checkBox=helper.getView(R.id.btn_select);
        helper.addOnClickListener(R.id.btn_select);
        if (item.isCheck()){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
        /*checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                item.setCheck(b);
                notifyDataSetChanged();
            }
        });*/
    }
}
