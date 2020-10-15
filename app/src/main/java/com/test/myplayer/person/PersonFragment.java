package com.test.myplayer.person;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.BR;
import com.test.myplayer.R;
import com.test.myplayer.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class PersonFragment extends DataBindingFragment {
    private final String TAG = this.getClass().getSimpleName();

    PersonViewModel mPersonViewModel;

    @Override
    protected void initViewModel() {
        mPersonViewModel = getFragmentViewModel(PersonViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_person, BR.vm, mPersonViewModel);
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
