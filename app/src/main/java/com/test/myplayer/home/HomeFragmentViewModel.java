package com.test.myplayer.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<Integer> topBarPosition = new MutableLiveData<>();

    public MutableLiveData<Integer> getTopBarPosition() {
        return topBarPosition;
    }
}
