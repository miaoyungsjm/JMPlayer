package com.test.myplayer.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myplayer.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * @author ggz
 * @date 2020/8/21
 */
public class SearchFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: ");

        TextView textView = view.findViewById(R.id.tv_search_test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController nc = Navigation.findNavController(getActivity(), R.id.home_fragment_host);
                nc.navigate(R.id.action_searchFragment_to_searchResultFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView: ");
        super.onDestroyView();
    }
}
