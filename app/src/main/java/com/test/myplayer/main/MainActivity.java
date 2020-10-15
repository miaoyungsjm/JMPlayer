package com.test.myplayer.main;

import android.os.Bundle;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.test.myplayer.BR;
import com.test.myplayer.R;
import com.test.myplayer.base.BaseActivity;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void initViewModel() {
        mMainActivityViewModel = getActivityViewModel(MainActivityViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, mMainActivityViewModel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}