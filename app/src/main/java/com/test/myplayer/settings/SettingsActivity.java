package com.test.myplayer.settings;

import android.app.Activity;
import android.os.Bundle;

import com.test.myplayer.R;

import androidx.annotation.Nullable;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}
