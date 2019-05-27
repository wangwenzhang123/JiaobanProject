package com.example.library_amap.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_amap.model.CarBean;
import com.example.library_amap.model.MarkerBean;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.OrderBean;
import com.example.library_commen.utils.PhoneCallUtils;
import com.example.util.PopwindowUtils;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.support.design.widget.BottomSheetBehavior.STATE_COLLAPSED;
import static android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED;

/**
 * Created by wangshen on 2019/5/19.
 */
@Route(path = ArouterKey.MAP_MAPORDERDETAILACTIVITY)
public class MapOrderDetailActivity extends BaseActivity implements LocationSource, AMap.InfoWindowAdapter, AMap.OnMapTouchListener, AMap.OnInfoWindowClickListener {

    @BindView(R2.id.search_et)
    TextView searchEt;
    @BindView(R2.id.order_detail_map)
    MapView orderDetailMap;
    @BindView(R2.id.issueorder_start_iv)
    ImageView issueorderStartIv;
    @BindView(R2.id.issueorder_start_tv)
    TextView issueorderStartTv;
    @BindView(R2.id.issue_go_start_iv)
    ImageView issueGoStartIv;
    @BindView(R2.id.start_view)
    View startView;
    @BindView(R2.id.issueorder_end_iv)
    ImageView issueorderEndIv;
    @BindView(R2.id.issueorder_end_tv)
    TextView issueorderEndTv;
    @BindView(R2.id.issue_go_end_iv)
    ImageView issueGoEndIv;
    @BindView(R2.id.end_view)
    View endView;
    @BindView(R2.id.issueorder_issue_iv)
    ImageView issueorderIssueIv;
    @BindView(R2.id.issueorder_distance_tv)
    TextView issueorderDistanceTv;
    @BindView(R2.id.issue_go_distance_iv)
    ImageView issueGoDistanceIv;
    @BindView(R2.id.issueorder_route_cl)
    ConstraintLayout issueorderRouteCl;
    @BindView(R2.id.order_detail_tv)
    TextView orderDetailTv;
    @BindView(R2.id.back_iv)
    ImageView backIv;
    BottomSheetBehavior bottomSheetBehavior;
    private AMap aMap;
    private Marker selectMarker;
    private List<CarBean> list = new ArrayList<>();

    @Override
    public int getView() {
        return R.layout.activity_map_orderdetail;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        if (aMap == null) {
            aMap = orderDetailMap.getMap();
        }
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setOnMapTouchListener(this);
        aMap.setInfoWindowAdapter(this);
        aMap.getUiSettings().setRotateGesturesEnabled(false);//禁止地图旋转手势.
        aMap.getUiSettings().setTiltGesturesEnabled(false);
        aMap.setOnInfoWindowClickListener(this);
        PopwindowUtils.getIncetance().initOrderPop(mContext, new OrderBean());
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(32.025216333904694, 118.7622009762265), 15));
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                PhoneCallUtils.call(marker.getSnippet(), mContext);
                return false;
            }
        });
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.design_bottom_sheet1));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void initLinsenterner() {
        list.add(new CarBean("张三", "145565", 32.08896437173746, 118.81953989846146));
        list.add(new CarBean("王五", "145564545", 31.985562554090762, 118.82025068383825));
        list.add(new CarBean("李留", "1811946511", 32.025216333904694, 118.7622009762265));
        Observable.create(new ObservableOnSubscribe<MarkerBean>() {
            @Override
            public void subscribe(ObservableEmitter<MarkerBean> e) throws Exception {
                for (int i = 0; i < list.size(); i++) {
                    Bitmap bitmap = getViewBitmap(list.get(i));
                    MarkerBean markerBean = new MarkerBean(list.get(i).getJing(), list.get(i).getWei(), list.get(i).getPhone(), bitmap);
                    e.onNext(markerBean);
                }
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MarkerBean>() {
                    @Override
                    public void accept(MarkerBean bitmap) throws Exception {
                        Marker marker = aMap.addMarker(new MarkerOptions().position(new LatLng(bitmap.getJing(), bitmap.getWei()))
                                .icon(BitmapDescriptorFactory.fromBitmap(bitmap.getBitmap()))
                                .anchor(0.5f, 0.5f));
                        marker.setSnippet(bitmap.getId());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        //设置监听事件
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //拖动
                if (newState == STATE_EXPANDED) {
                    orderDetailTv.setVisibility(View.GONE);
                }
                if (newState == STATE_COLLAPSED) {
                    orderDetailTv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //状态变化
            }
        });
    }

    private Bitmap getViewBitmap(CarBean carBean) {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View view = factory.inflate(R.layout.custom_info_window, null);
        TextView title = (TextView) view.findViewById(R.id.info_title);
        title.setText(carBean.getName());
        TextView conten = view.findViewById(R.id.info_contan);
        conten.setText(carBean.getPhone());
        view.setDrawingCacheEnabled(true);
        //调用下面这个方法非常重要，如果没有调用这个方法，得到的bitmap为null
        view.measure(View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.EXACTLY));
        //这个方法也非常重要，设置布局的尺寸和位置
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        //获得绘图缓存中的Bitmap
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    @Override
    public void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        orderDetailMap.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        orderDetailMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        orderDetailMap.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        orderDetailMap.onDestroy();
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onTouch(MotionEvent motionEvent) {

    }

    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        return null;
    }


    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @OnClick(R2.id.order_detail_tv)
    public void onViewClicked() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(STATE_COLLAPSED);
        } else if (bottomSheetBehavior.getState() == STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @OnClick(R2.id.back_iv)
    public void onViewBackClicked() {
        finish();
    }
}
