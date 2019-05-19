package com.example.library_amap.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.utils.PhoneCallUtils;
import com.example.util.ToastUtil;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private AMap aMap;
    private Marker selectMarker;
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
        aMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void initLinsenterner() {
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (selectMarker == null) {
                    selectMarker = aMap.addMarker(new MarkerOptions().position(latLng)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.car_pic))
                            .anchor(0.5f, 0.5f));
                    selectMarker.setTitle("王神");
                    selectMarker.setSnippet("12345678");
                    selectMarker.showInfoWindow();
                    Marker marker=aMap.addMarker(new MarkerOptions().position(latLng)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.car_pic))
                            .anchor(0.5f, 0.5f));
                    marker.setTitle("王先生");
                    marker.setSnippet("18119946110");
                    marker.showInfoWindow();
                } else {
                    selectMarker.setPosition(latLng);
                }
            }
        });
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
        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return infoWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return infoWindow;
    }
    /**
     * 自定义infowinfow窗口
     */
    public void render(Marker marker, View view) {
        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.info_title));
        titleUi.setText(title);
        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.info_contan));
        snippetUi.setText(snippet);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        PhoneCallUtils.call(marker.getSnippet(),mContext);
    }
}
