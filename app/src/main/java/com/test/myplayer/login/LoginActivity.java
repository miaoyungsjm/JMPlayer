package com.test.myplayer.login;

import android.app.Activity;
import android.os.Bundle;

import com.test.myplayer.R;

import androidx.annotation.Nullable;

/**
 * @author ggz
 * @date 2020/8/22
 */
public class LoginActivity extends Activity {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
