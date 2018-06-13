package com.morly.driver.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.common.library.util.ActivityManager;
import com.morly.driver.R;
import com.morly.driver.base.BaseSimpleActivity;
import com.morly.driver.home.benefit.BenefitFragment;
import com.morly.driver.home.local.LocalFragment;
import com.morly.driver.home.me.MeFragment;
import com.morly.driver.home.service.ServiceFragment;
import com.morly.driver.widget.HomeBottomNavigationView;

import butterknife.BindView;

public class HomeActivity extends BaseSimpleActivity {

    @BindView(R.id.bottom_navigation)
    HomeBottomNavigationView bottomNavigationView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private Fragment[] fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        ActivityManager.getInstance().popOtherActivity(HomeActivity.class);
        fragments = new Fragment[]{
                ServiceFragment.newInstance(null),
                BenefitFragment.newInstance(null),
                LocalFragment.newInstance(null),
                MeFragment.newInstance(null)
        };

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });

        bottomNavigationView.setNavigationClickListener(new HomeBottomNavigationView.NavigationClickListener() {
            @Override
            public void onItemClicked(int position) {
                viewPager.setCurrentItem(position, false);
            }
        });
    }
}
