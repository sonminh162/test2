package com.lifetime.second_test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.second_test.R;
import com.lifetime.second_test.activity.MainScreenActivity;
import com.lifetime.second_test.adapter.NewFeedAdapter;
import com.lifetime.second_test.model.Info;
import com.lifetime.second_test.model.SharedViewModel;

import java.util.ArrayList;

public class NewFeedFragment extends Fragment {

    private SharedViewModel viewModel;

    View view;

    public NewFeedFragment() {
    }

    private void initView() {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_new_feed);
        recyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Info> arrayList = new ArrayList<>();
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        NewFeedAdapter adapter = new NewFeedAdapter(arrayList, new NewFeedAdapter.OnItemClickListener() {
            @Override
            public void onAvatarClick(Info info) {
                String message = info.getName();
                Intent intent = new Intent(getActivity().getBaseContext(), MainScreenActivity.class);
                intent.putExtra("message",message);
                getActivity().startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_newfeed,container,false);

        initView();


        return view;
    }
}
