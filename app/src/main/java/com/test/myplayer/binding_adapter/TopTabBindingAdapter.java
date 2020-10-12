package com.test.myplayer.binding_adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.StringUtils;
import com.test.myplayer.R;

import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * @author ggz
 * @date 2020/10/12
 */
public class TopTabBindingAdapter {

    @BindingAdapter(value = {"initTabAndPage"}, requireAll = false)
    public static void initTabAndPage(RadioGroup radioGroup, boolean initTabAndPage) {
        Context context = radioGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        String[] topTabArray = StringUtils.getStringArray(R.array.topTabArray);
        for (int i = 0; i < topTabArray.length; i++) {
            RadioButton radioButton = (RadioButton) inflater.inflate(
                    R.layout.item_top_tab_rg, radioGroup, false);
            radioButton.setId(i);
            radioButton.setText(topTabArray[i]);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
            radioGroup.addView(radioButton, params);
        }

        ViewPager viewPager = (radioGroup.getRootView()).findViewById(R.id.vp_fragment_host);
//        viewPager.setAdapter();
    }
}
