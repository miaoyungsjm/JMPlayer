package com.test.myplayer.drawer;

import android.content.Intent;
import android.view.View;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;
import com.test.myplayer.login.LoginActivity;
import com.test.myplayer.main.MainActivityViewModel;
import com.test.myplayer.settings.SettingsActivity;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class DrawerFragment extends DataBindingFragment {

    DrawerFragmentViewModel mDrawerFragmentViewModel;
    MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void initViewModel() {
        mDrawerFragmentViewModel = getFragmentViewModel(DrawerFragmentViewModel.class);
        mMainActivityViewModel = getActivityViewModel(MainActivityViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_drawer, BR.vm, mDrawerFragmentViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy {
        public void itemClick(View view) {
            switch (view.getId()) {
                case R.id.tv_drawer_login:
                    Intent intent0 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent0);
                    break;
                case R.id.tv_drawer_settings:
                    Intent intent1 = new Intent(getActivity(), SettingsActivity.class);
                    startActivity(intent1);
                    break;
                default:
                    break;
            }
            mMainActivityViewModel.openDrawer.setValue(false);
        }
    }
}
