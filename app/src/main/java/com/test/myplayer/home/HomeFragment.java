package com.test.myplayer.home;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.StringUtils;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;
import com.test.myplayer.adapter.HomePagerAdapter;
import com.test.myplayer.base.BaseFragment;
import com.test.myplayer.discovery.DiscoveryFragment;
import com.test.myplayer.main.MainActivityViewModel;
import com.test.myplayer.person.PersonFragment;
import com.test.myplayer.video.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class HomeFragment extends DataBindingFragment {
    private final String TAG = this.getClass().getSimpleName();

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: ");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onViewCreated: view: " + view);
        super.onViewCreated(view, savedInstanceState);

        // todo: Navigation.popBackStack() 重走问题
        initView(view);
    }

    protected void initView(View v) {
        Log.e(TAG, "initView: ");

        RadioGroup radioGroup = v.findViewById(R.id.rg_home_top_tab);
        ViewPager viewPager = v.findViewById(R.id.vp_fragment_host);

        List<Fragment> fragmentList = new ArrayList<>();
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
            } else if (topTabArray[i].equals(StringUtils.getString(R.string.str_video))) {
                fragment = new VideoFragment();
            } else {
                fragment = null;
            }

            if (fragment != null) {
                fragmentList.add(fragment);
            }
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                viewPager.setCurrentItem(i);
            }
        });

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(
                getChildFragmentManager(), 0, fragmentList);
        viewPager.setAdapter(homePagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
//                ImageView tabLineIv = v.findViewById(R.id.iv_tab_line);
//                ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) tabLineIv.getLayoutParams();
//                lp.leftMargin = radioButton.getLeft() + radioButton.getWidth() / 2 -
//                        tabLineIv.getWidth() / 2 + (int) (radioButton.getWidth() * positionOffset);
//                tabLineIv.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                    if (i == position) {
                        radioButton.setChecked(true);
                        radioButton.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    } else {
                        radioButton.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(1);
    }

    public class ClickProxy {
        public void openDrawer() {
            mMainActivityViewModel.openDrawer.setValue(true);
        }

        public void toSearch() {
            NavController nc = Navigation.findNavController(getActivity(), R.id.home_fragment_host);
            nc.navigate(R.id.action_homeFragment_to_searchFragment);
        }
    }
}
