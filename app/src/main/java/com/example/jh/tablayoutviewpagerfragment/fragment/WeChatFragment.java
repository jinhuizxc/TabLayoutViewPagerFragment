package com.example.jh.tablayoutviewpagerfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jh.tablayoutviewpagerfragment.R;

/**
 * Created by jinhui on 2018/3/5.
 * Email:1004260403@qq.com
 *
 * 微信精选
 */

public class WeChatFragment extends Fragment {

    private static final String TAG = "WeChatFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_wechat, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    // 执行该方法时，Fragment完全不可见。
    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    // 局限在于此方法的第一次系统调用甚至早于Fragment的onCreate方法，故其第一次调用时isVisibleToUser值总为false，影响我们对生命周期顺序的判定；
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            Log.e(TAG, "微信精选界面hidden");
        }else {
            Log.e(TAG, "微信精选界面 nohidden");
        }
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.e(TAG, "微信精选界面可见");
        }else {
            Log.e(TAG, "微信精选界面不可见");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG, "onViewStateRestored");
    }
}
