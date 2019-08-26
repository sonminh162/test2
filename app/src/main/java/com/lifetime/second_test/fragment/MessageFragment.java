package com.lifetime.second_test.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.second_test.R;
import com.lifetime.second_test.adapter.MessageAdapter;
import com.lifetime.second_test.model.Message;

import java.util.ArrayList;

public class MessageFragment extends Fragment {

    View view;

    public MessageFragment() {
    }

    private void initView() {
        RecyclerView recyclerView = view.findViewById(R.id.message_recycler_view);
        recyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));

        MessageAdapter adapter = new MessageAdapter(messages);
        recyclerView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDataFromOtherFragmentBeforeSetContentView();
        view = inflater.inflate(R.layout.fragment_message,container,false);

        initView();

        return view;
    }

    private void getDataFromOtherFragmentBeforeSetContentView() {
        if(getArguments()!=null){
            String receivedMessage = getArguments().getString("message");
            Toast.makeText(getActivity().getBaseContext(), receivedMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
