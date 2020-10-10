package com.test.myplayer.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class HomeFragment extends DataBindingFragment {

    HomeFragmentViewModel mHomeFragmentViewModel;

    @Override
    protected void initViewModel() {
        mHomeFragmentViewModel = getFragmentViewModel(HomeFragmentViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_home, BR.vm, mHomeFragmentViewModel);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
