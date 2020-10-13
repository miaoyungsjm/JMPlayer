package com.test.myplayer.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.StringUtils;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;
import com.test.myplayer.adapter.HomePagerAdapter;
import com.test.myplayer.discovery.DiscoveryFragment;
import com.test.myplayer.drawer.DrawerFragment;
import com.test.myplayer.main.MainActivityViewModel;
import com.test.myplayer.person.PersonFragment;
import com.test.myplayer.square.SquareFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class HomeFragment extends DataBindingFragment {

    HomeFragmentViewModel mHomeFragmentViewModel;
    MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void initViewModel() {
        mHomeFragmentViewModel = getFragmentViewModel(HomeFragmentViewModel.class);
        mMainActivityViewModel = getActivityViewModel(MainActivityViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_home, BR.vm, mHomeFragmentViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View v) {
        List<Fragment> fragmentList = new ArrayList<>();

        RadioGroup radioGroup = v.findViewById(R.id.rg_home_top_tab);
        String[] topTabArray = StringUtils.getStringArray(R.array.topTabArray);
        for (int i = 0; i < topTabArray.length; i++) {
            RadioButton radioButton = (RadioButton) getLayoutInflater().inflate(
                    R.layout.item_top_tab_rg, radioGroup, false);
            radioButton.setId(i);
            radioButton.setText(topTabArray[i]);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
            radioGroup.addView(radioButton, params);

            Fragment fragment;
            if (topTabArray[i].equals(StringUtils.getString(R.string.str_person))) {
                fragment = new PersonFragment();
            } else if (topTabArray[i].equals(StringUtils.getString(R.string.str_discovery))) {
                fragment = new DiscoveryFragment();
            } else if (topTabArray[i].equals(StringUtils.getString(R.string.str_square))) {
                fragment = new SquareFragment();
            } else {
                fragment = null;
            }

            if (fragment != null) {
                fragmentList.add(fragment);
            }
        }

        ViewPager viewPager = v.findViewById(R.id.vp_fragment_host);
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(
                getChildFragmentManager(), 0, fragmentList);
        viewPager.setAdapter(homePagerAdapter);
    }

    public class ClickProxy {

        public void openDrawer() {
            mMainActivityViewModel.openDrawer.setValue(true);
        }

    }
}
