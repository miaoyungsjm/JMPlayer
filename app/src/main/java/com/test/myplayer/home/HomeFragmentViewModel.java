package com.test.myplayer.home;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class HomeFragmentViewModel extends ViewModel {
    private final String TAG = this.getClass().getSimpleName();

    public final ObservableBoolean initTabAndPage = new ObservableBoolean();

    private MutableLiveData<Integer> topTabPosition = new MutableLiveData<>();

    public MutableLiveData<Integer> getTopTabPosition() {
        return topTabPosition;
    }

    public HomeFragmentViewModel() {
        initTabAndPage.set(true);
    }
}
