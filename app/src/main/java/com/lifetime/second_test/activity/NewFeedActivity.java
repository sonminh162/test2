package com.lifetime.second_test.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.second_test.R;
import com.lifetime.second_test.adapter.NewFeedAdapter;
import com.lifetime.second_test.model.Info;

import java.util.ArrayList;

public class NewFeedActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_feed);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_new_feed);
        recyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Info> arrayList = new ArrayList<>();
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1, getResources().getString(R.string.example1), getResources().getString(R.string.example2), getResources().getString(R.string.example3), R.drawable.rectangle_copy, getResources().getString(R.string.example5)));
        NewFeedAdapter adapter = new NewFeedAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
