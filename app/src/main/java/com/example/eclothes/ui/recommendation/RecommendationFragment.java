package com.example.eclothes.ui.recommendation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.eclothes.R;

public class RecommendationFragment extends Fragment {

    private RecommendationViewModel recommendationViewModel;
    private static final String TAG = "RecommendationFragment";

    public View onCreate(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
        recommendationViewModel = new ViewModelProvider(this).get(RecommendationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recommendation, container, false);
        final TextView textView = root.findViewById(R.id.text_recommendation);
        recommendationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "onChanged: setText");
                textView.setText(s);
            }
        });
        return root;
    }

}
