package com.test.myplayer.home;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;

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
}
