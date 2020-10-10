package com.test.myplayer.drawer;

import android.view.View;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.main.MainActivityViewModel;
import com.test.myplayer.R;

import static com.test.myplayer.main.MainActivity.POSITION_HOME;
import static com.test.myplayer.main.MainActivity.POSITION_LOGIN;
import static com.test.myplayer.main.MainActivity.POSITION_SETTINGS;

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
            int position = 0;
            switch (view.getId()) {
                case R.id.tv_drawer_home:
                    position = POSITION_HOME;
                    break;
                case R.id.tv_drawer_login:
                    position = POSITION_LOGIN;
                    break;
                case R.id.tv_drawer_settings:
                    position = POSITION_SETTINGS;
                    break;
                default:
                    break;
            }
            mMainActivityViewModel.getNavPosition().setValue(position);
        }
    }
}
