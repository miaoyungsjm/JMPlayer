package com.test.myplayer.slide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.R;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class SlideFragment extends Fragment {
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        return view;
    }
}
