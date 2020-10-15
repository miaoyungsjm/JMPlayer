package com.test.myplayer.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class MainActivityViewModel extends ViewModel {

    public final MutableLiveData<Boolean> openDrawer = new MutableLiveData<>();

}
