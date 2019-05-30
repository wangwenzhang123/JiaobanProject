package com.tongdada.library_main.finance.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.example.library_commen.model.TransportCarBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinaceOrderAdapter  extends BaseQuickAdapter<TransportCarBean,BaseViewHolder>{
    public FinaceOrderAdapter(int layoutResId, @Nullable List<TransportCarBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final TransportCarBean item) {
        helper.setText(R.id.transport_carnumber,item.getCarNo());
        helper.setText(R.id.driver_name,item.getDriverName());
        helper.setText(R.id.order_accept_time,item.getAcceptTime());
        helper.setText(R.id.distance_text,item.getTotalDistance()+"km");
        CheckBox checkBox=helper.getView(R.id.btn_select);
        helper.addOnClickListener(R.id.btn_select);
        helper.setText(R.id.order_price,item.getOrderPrice());
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
