package com.example.project02_last.map;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project02_last.R;
import com.example.project02_last.databinding.FragmentKymMapBinding;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;


public class KymMapFragment extends Fragment implements OnMapReadyCallback{
    FragmentKymMapBinding binding;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKymMapBinding.inflate(inflater,container,false);
        NaverMapSdk.getInstance(getContext()).setClient(
                //clientId : 매니페스트와 여기에 넣어줘야함. ( 지금 삭제함 )
                new NaverMapSdk.NaverCloudPlatformClient(""));

        locationSource =
                new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);


        binding.mapView.getMapAsync(this);
        return binding.getRoot();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,  @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) { // 권한 거부됨
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
            }
            return;
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }


    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
//        NaverMapOptions options = new NaverMapOptions()
//                .camera(new CameraPosition(new LatLng(35.1535583, 126.8879957), 8));

        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(35.1535583, 126.8879957))
                .animate(CameraAnimation.Easing , 1000);
            naverMap.moveCamera(cameraUpdate);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);
        uiSettings.setCompassEnabled(true);

        ArrayList<Marker> list = new ArrayList<>();
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPosition(new LatLng(35.1535583, 126.8879957));
            list.get(i).setMap(naverMap);
        }


        //naverMap.setMapType(NaverMap.MapType.Basic); // 맵의 타입을 변경 : 위성 , 내비 등.
        //naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING, false);
        //naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRANSIT, true); // 대중교통 , 교통 사용량 등의 표시
       // naverMap.setIndoorEnabled(true);
    }
}