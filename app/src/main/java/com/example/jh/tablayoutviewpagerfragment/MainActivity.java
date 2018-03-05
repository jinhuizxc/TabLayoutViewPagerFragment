package com.example.jh.tablayoutviewpagerfragment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jh.tablayoutviewpagerfragment.fragment.ButerFragment;
import com.example.jh.tablayoutviewpagerfragment.fragment.GirlFragment;
import com.example.jh.tablayoutviewpagerfragment.fragment.UserFragment;
import com.example.jh.tablayoutviewpagerfragment.fragment.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * https://mp.weixin.qq.com/s/eKPwQLJVUsZn6HNt7eivMQ
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TabLayout mtablayout;
    ViewPager mviewpager;
    List<Fragment> mfragment;
    List<String> mtitle;
    FloatingActionButton fab_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 去除阴影
        getSupportActionBar().setElevation(0);
        initData();
        initView();
    }

    //View 初始化
    private void initView() {
        mtablayout = (TabLayout) findViewById(R.id.mtablayout);
        mviewpager = (ViewPager) findViewById(R.id.mviewpager);
        //       预加载
        mviewpager.setOffscreenPageLimit(mfragment.size());
        //       设置适配器
        mviewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override

//
            public Fragment getItem(int position) {
                return mfragment.get(position);
            }

            @Override
            public int getCount() {
                return mfragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mtitle.get(position);
            }
        });
        //将TabLayout与ViewPager进行绑定
        mtablayout.setupWithViewPager(mviewpager);

        // 初始化悬浮框
        fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);
        // 设置启动 Activity 时悬浮框默认隐藏
        fab_setting.setVisibility(View.GONE);
        //      悬浮框的点击事件
        fab_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
        //     viewPager的滑动监听
        mviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "position: " + position);
                if (position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //数据初始化
    private void initData() {
        mtitle = new ArrayList<>();
        mtitle.add("服务管家");
        mtitle.add("微信精选");
        mtitle.add("美女社区");
        mtitle.add("个人中心");
        mfragment = new ArrayList<>();
        mfragment.add(new ButerFragment());
        mfragment.add(new GirlFragment());
        mfragment.add(new WeChatFragment());
        mfragment.add(new UserFragment());
    }
}
