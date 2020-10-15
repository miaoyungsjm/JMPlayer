package com.test.myplayer.video;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
public class VideoFragment extends DataBindingFragment {
    private final String TAG = this.getClass().getSimpleName();

    VideoViewModel mVideoViewModel;

    @Override
    protected void initViewModel() {
        mVideoViewModel = getFragmentViewModel(VideoViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_video, BR.vm, mVideoViewModel);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onViewCreated: view: " + view);
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    protected void initView(View v) {

    }
}
