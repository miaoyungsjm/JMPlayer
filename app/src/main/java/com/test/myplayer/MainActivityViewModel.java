package com.test.myplayer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Integer> navPosition = new MutableLiveData<>();

    public MutableLiveData<Integer> getNavPosition() {
        return navPosition;
    }
}
