package com.lifetime.second_test.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.second_test.R;
import com.lifetime.second_test.adapter.NewFeedAdapter;
import com.lifetime.second_test.model.Info;

import java.util.ArrayList;

public class EmptyFragment extends Fragment {

    View view;

    public EmptyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_empty,container,false);

        return view;
    }
}
