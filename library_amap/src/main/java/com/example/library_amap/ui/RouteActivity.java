package com.example.library_amap.ui;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;


import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_commen.appkey.ArouterKey;
import com.example.overlay.DrivingRouteOverlay;
import com.example.overlay.MyDrivingRouteOverlay;

import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/21 9:32
 * @change
 */
@Route(path = ArouterKey.MAP_ROUTEACTIVITY)
public class RouteActivity extends BaseActivity implements LocationSource, AMap.OnMapTouchListener, RouteSearch.OnRouteSearchListener{

    @BindView(R2.id.route_map)
    MapView routeMap;
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
    @BindView(R2.id.issueorder_route_cl)
    ConstraintLayout issueorderRouteCl;
    private AMap aMap;
    private RouteSearch routeSearch;
    @Override
    public int getView() {
        return R.layout.activity_route;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        if (aMap == null) {
            aMap = routeMap.getMap();
        }
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setOnMapTouchListener(this);
        routeSearch = new RouteSearch(this);
        routeSearch.setRouteSearchListener(this);
    }

    @Override
    public void initLinsenterner() {


    }

    @Override
    public void getData() {
        LatLonPoint start=new LatLonPoint(32.001320127526995,118.84922390512145 );
        LatLonPoint end=new LatLonPoint(32.09100385714674,118.79593780063867);
        RouteSearch.FromAndTo fromAndTo=new RouteSearch.FromAndTo(start,end);
        RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION, null, null, "");
        routeSearch.calculateDriveRouteAsyn(query);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        routeMap.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        routeMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        routeMap.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        routeMap.onDestroy();
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
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }
    private List<DrivePath> drivePaths=new ArrayList<>();
    private DriveRouteResult driveRouteResult;
    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int errorCode) {
        aMap.clear();// 清理地图上的所有覆盖物
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (driveRouteResult != null && driveRouteResult.getPaths() != null){
                drivePaths.clear();
                drivePaths.addAll(driveRouteResult.getPaths());
                this.driveRouteResult=driveRouteResult;
            }
            drawPath();
        }
    }

    private void drawPath(){
        aMap.clear();
        for (int i = 0; i < driveRouteResult.getPaths().size(); i++) {
            DrivePath drivePath=driveRouteResult.getPaths().get(i);
            DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(
                    mContext, aMap, drivePath,
                    driveRouteResult.getStartPos(),
                    driveRouteResult.getTargetPos(), null);
            drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
            drivingRouteOverlay.setIsColorfulline(true);//是否用颜色展示交通拥堵情况，默认true
            if (i != index){
                drivingRouteOverlay.setoneColor(Color.parseColor("#80CAB5"));
            }else {
                drivingRouteOverlay.setoneColor(Color.parseColor("#1CB954"));
            }
            drivingRouteOverlay.removeFromMap();
            drivingRouteOverlay.addToMap();
            drivingRouteOverlay.zoomToSpan();
        }
    }
    int index=0;
    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }

}
