package com.tongdada.library_main.finance.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.example.library_commen.model.TransportCarBean;
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
        helper.setText(R.id.transport_carnumber,item.getCarNo());
        helper.setText(R.id.driver_name,item.getDriverName());
        helper.setText(R.id.order_accept_time,item.getAcceptTime());
        helper.setText(R.id.distance_text,item.getTotalDistance()+"km");
        CheckBox checkBox=helper.getView(R.id.btn_select);
        helper.addOnClickListener(R.id.btn_select);
        helper.setText(R.id.order_price,item.getOrderPrice());
        ImageView state=helper.getView(R.id.car_state_iv);
        if (item.getOrderStatus().equals("S")){
            state.setImageResource(R.mipmap.accounting);
        }else if (item.getOrderStatus().equals("H")){
            state.setImageResource(R.mipmap.weihesuan);
        }else {
            state.setImageResource(R.mipmap.daiqueren);
        }
        if (item.isCheck()){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
    }
}
