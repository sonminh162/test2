package com.lifetime.second_test.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.second_test.R;
import com.lifetime.second_test.SpecialInterface.ItemClickListener;

import com.lifetime.second_test.model.Message;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{


    ItemClickListener itemClickListener;

    ArrayList<Message> messages;



    public MessageAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrow_message,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        holder.bindView(messages.get(position));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView avatar;
        TextView name;
        TextView content;
        TextView time;
        TextView countMessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.message_item_row_avatar);
            name = itemView.findViewById(R.id.mesasge_name);
            content = itemView.findViewById(R.id.message_content);
            time = itemView.findViewById(R.id.time_message);
            countMessage = itemView.findViewById(R.id.notify_message);
        }
        public void bindView(Message message){
            avatar.setImageResource(message.getAvatar());
            name.setText(message.getName());
            content.setText(message.getMessageContent());
            time.setText(message.getTime());
            countMessage.setText(message.getCountMessage());

        }
    }
}
