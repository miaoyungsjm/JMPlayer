package com.test.myplayer.discovery;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class DiscoveryFragment extends DataBindingFragment {
    private final String TAG = this.getClass().getSimpleName();

    private DiscoveryViewModel mDiscoveryViewModel;

    @Override
    protected void initViewModel() {
        mDiscoveryViewModel = getFragmentViewModel(DiscoveryViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_discovery, BR.vm, mDiscoveryViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: ");
    }

    public class ClickProxy {

        public void toSquare() {
            NavController nc = Navigation.findNavController(getActivity(), R.id.home_fragment_host);
            nc.navigate(R.id.action_homeFragment_to_squareFragment);
        }

        public void toPlaylist() {
            NavController nc = Navigation.findNavController(getActivity(), R.id.home_fragment_host);
            nc.navigate(R.id.action_homeFragment_to_playlistFragment);
        }
    }
}
