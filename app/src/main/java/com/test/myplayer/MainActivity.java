package com.test.myplayer;

import android.os.Bundle;
import android.util.Log;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.kunminx.architecture.ui.page.DataBindingActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class MainActivity extends DataBindingActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    public final static int POSITION_HOME = 0;
    public final static int POSITION_LOGIN = 1;
    public final static int POSITION_SETTINGS = 2;

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
        Log.e(TAG, "onCreate: ");

        mMainActivityViewModel.getNavPosition().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer position) {
                Log.e(TAG, "onChanged: " + position);

//                DrawerLayout drawerLayout = findViewById(R.id.drawer);
//                drawerLayout.close();
                mMainActivityViewModel.openDrawer.setValue(false);

                NavController nav = Navigation.findNavController(MainActivity.this,
                        R.id.home_fragment_host);
                switch (position) {
                    case POSITION_HOME:
                        nav.navigate(R.id.action_global_homeFragment);
                        break;
                    case POSITION_LOGIN:
                        nav.navigate(R.id.action_global_loginFragment);
                        break;
                    case POSITION_SETTINGS:
                        nav.navigate(R.id.action_global_settingsFragment);
                        break;
                    default:
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }
}