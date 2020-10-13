package com.test.myplayer.adapter;

import com.kunminx.architecture.ui.page.DataBindingFragment;
import com.test.myplayer.discovery.DiscoveryFragment;
import com.test.myplayer.person.PersonFragment;
import com.test.myplayer.square.SquareFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * @author ggz
 * @date 2020/10/13
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private int count;
    List<Fragment> fragmentList;

    public HomePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
        count = fragmentList.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
