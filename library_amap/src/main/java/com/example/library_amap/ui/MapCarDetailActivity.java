package com.example.library_amap.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_amap.R;
import com.example.library_amap.R2;
import com.example.library_amap.model.MarkerBean;
import com.example.library_amap.presenter.MapCarDetailContract;
import com.example.library_amap.presenter.MapCarDetailPresenter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.event.EventUpdateOrderList;
import com.example.library_commen.model.CarBean;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.utils.PhoneCallUtils;
import com.example.overlay.DrivingRouteOverlay;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangshen on 2019/5/19.
 */
@Route(path = ArouterKey.MAP_MAPCARDETAILACTIVITY)
public class MapCarDetailActivity extends BaseMvpActivity<MapCarDetailPresenter> implements LocationSource, AMap.InfoWindowAdapter, AMap.OnMapTouchListener, AMap.OnInfoWindowClickListener, MapCarDetailContract.View, RouteSearch.OnRouteSearchListener {


    @BindView(R2.id.search_et)
    TextView searchEt;
    @BindView(R2.id.order_detail_map)
    MapView orderDetailMap;
    @BindView(R2.id.back_iv)
    ImageView backIv;

    @BindView(R2.id.transport_carnumber)
    TextView transportCarnumber;
    @BindView(R2.id.driver_name)
    TextView driverName;
    @BindView(R2.id.driver_phone)
    TextView driverPhone;
    @BindView(R2.id.accept_total)
    TextView acceptTotal;
    @BindView(R2.id.driver_attribution)
    TextView driverAttribution;
    @BindView(R2.id.now_loading)
    TextView nowLoading;
    @BindView(R2.id.unit_price)
    TextView unitPrice;
    @BindView(R2.id.loading_pic)
    ImageView loadingPic;
    @BindView(R2.id.unload_pic)
    ImageView unloadPic;
    @BindView(R2.id.reject_tv)
    TextView rejectTv;
    @BindView(R2.id.unload_accomplish_tv)
    TextView unloadAccomplishTv;
    @BindView(R2.id.bottom_ll)
    LinearLayout bottomLl;
    @BindView(R2.id.total_price)
    TextView totalPrice;
    @BindView(R2.id.qiandao)
    TextView qiandao;
    private AMap aMap;
    private Marker selectMarker;
    private String id;
    private RouteSearch routeSearch;
    private LatLonPoint start, end;

    @Override
    public int getView() {
        return R.layout.activity_map_cardetail;
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
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
               /* if (!TextUtils.isEmpty(marker.getSnippet())) {
                    PhoneCallUtils.call(marker.getSnippet(), mContext);
                }*/
                return false;
            }
        });
        id = getIntent().getStringExtra(IntentKey.MAP_ORDERID);
        presenter.getDetailOrderById(id);
        routeSearch = new RouteSearch(this);
        routeSearch.setRouteSearchListener(this);
        orderDetailMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override
    public void initLinsenterner() {
        orderDetailMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.order_detail_map) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
               /* if (selectMarker == null) {
                    selectMarker = aMap.addMarker(new MarkerOptions().position(latLng)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.car_pic))
                            .anchor(0.5f, 0.5f));
                    selectMarker.setTitle("王神");
                    selectMarker.setSnippet("12345678");
                    selectMarker.showInfoWindow();
                    Marker marker = aMap.addMarker(new MarkerOptions().position(latLng)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.car_pic))
                            .anchor(0.5f, 0.5f));
                    marker.setTitle("王先生");
                    marker.setSnippet("18119946110");
                    marker.showInfoWindow();
                } else {
                    selectMarker.setPosition(latLng);
                }*/
            }
        });
        driverPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneCallUtils.call(driverPhone.getText().toString(),mContext);
            }
        });
    }

    @Override
    public MapCarDetailPresenter getPresenter() {
        return new MapCarDetailPresenter();
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.FFFFFF));
        }
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
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return null;
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
        // PhoneCallUtils.call(marker.getSnippet(), mContext);
    }

    @OnClick(R2.id.back_iv)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void setDetailOrder(final DriverOrderDetailBean detailOrder) {
        driverName.setText(detailOrder.getDriverName());
        driverPhone.setText(detailOrder.getPsDriver().getDriverMobile());
        transportCarnumber.setText(detailOrder.getCarNo());
        totalPrice.setText(detailOrder.getOrderPrice()+"元");
        if (TextUtils.isEmpty(detailOrder.getSignTime())){
            qiandao.setText("未签到");
        }else {
            qiandao.setText(detailOrder.getSignTime());
        }

        unitPrice.setText(detailOrder.getPsTotalOrder().getPerPrice() + "元（单位 方/公里）");
        nowLoading.setText(detailOrder.getOrderAmount() + "方");
        start = new LatLonPoint(Double.valueOf(detailOrder.getPsTotalOrder().getStartLatitude()), Double.valueOf(detailOrder.getPsTotalOrder().getStartLongitude()));
        end = new LatLonPoint(Double.valueOf(detailOrder.getPsTotalOrder().getDstLatitude()), Double.valueOf(detailOrder.getPsTotalOrder().getDstLongitude()));
        queryRoute();
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(detailOrder.getPsCar().getCarLatitude()), Double.valueOf(detailOrder.getPsCar().getCarLongitude())), 10));
        Observable.create(new ObservableOnSubscribe<MarkerBean>() {
            @Override
            public void subscribe(ObservableEmitter<MarkerBean> e) throws Exception {
                CarBean carBean = new CarBean(detailOrder.getDriverName(), detailOrder.getCarNo(), detailOrder.getPsDriver().getDriverMobile(), Double.valueOf(detailOrder.getPsCar().getCarLatitude()), Double.valueOf(detailOrder.getPsCar().getCarLongitude()));
                Bitmap bitmap = getViewBitmap(carBean);
                MarkerBean markerBean = new MarkerBean(carBean.getJing(), carBean.getWei(), carBean.getPhone(), bitmap);
                e.onNext(markerBean);
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
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + detailOrder.getLoadLicense()).apply(requestOptions).into(loadingPic);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + detailOrder.getUnloadLicense()).apply(requestOptions).into(unloadPic);
        bottomLl.setVisibility(View.GONE);
       /* if (detailOrder.getOrderStatus().equals("R")) {
            bottomLl.setVisibility(View.VISIBLE);
        } else {
            bottomLl.setVisibility(View.GONE);
        }*/
    }

    @Override
    public void updateSuccess() {
        EventBus.getDefault().post(new EventUpdateOrderList());
        finish();
    }

    private Bitmap getViewBitmap(CarBean carBean) {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View view = factory.inflate(R.layout.custom_info_window, null);
        TextView title = (TextView) view.findViewById(R.id.info_title);
        title.setText(carBean.getName());
        TextView conten = view.findViewById(R.id.info_contan);
        conten.setText(carBean.getCarNo());
        view.setDrawingCacheEnabled(true);
        //调用下面这个方法非常重要，如果没有调用这个方法，得到的bitmap为null
        view.measure(View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(256, View.MeasureSpec.UNSPECIFIED));
        //这个方法也非常重要，设置布局的尺寸和位置
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        //获得绘图缓存中的Bitmap
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    private Bitmap getDestination() {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View view = factory.inflate(R.layout.marker_destination, null);
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

    public void queryRoute() {
        if (start != null && end != null) {
            RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(start, end);
            RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION, null, null, "");
            routeSearch.calculateDriveRouteAsyn(query);
        }
    }

    @OnClick(R2.id.reject_tv)
    public void onRejectTvClicked() {
        presenter.updateDetailOrders(id, "Z");
    }

    @OnClick(R2.id.unload_accomplish_tv)
    public void onUnloadAccomplishTvClicked() {
        presenter.batchUpdateDetailOrders(id, "X");
    }

    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int errorCode) {
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            DrivePath drivePath = driveRouteResult.getPaths().get(0);
            DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(
                    mContext, aMap, drivePath,
                    driveRouteResult.getStartPos(),
                    driveRouteResult.getTargetPos(), null);
            drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
            drivingRouteOverlay.setIsColorfulline(true);//是否用颜色展示交通拥堵情况，默认true
            drivingRouteOverlay.setoneColor(Color.parseColor("#80CAB5"));
            drivingRouteOverlay.removeFromMap();
            drivingRouteOverlay.addToMap();
            drivingRouteOverlay.zoomToSpan();
        }
    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }
}
