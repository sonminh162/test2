package com.lifetime.second_test.SpecialInterface;

import android.view.View;

import com.lifetime.second_test.adapter.NewFeedAdapter;


public interface ItemClickListener {
    void onClick(View view, int position, NewFeedAdapter.OnItemClickListener listener);
}
