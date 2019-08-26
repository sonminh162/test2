package com.lifetime.second_test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.second_test.R;
import com.lifetime.second_test.SpecialInterface.ItemClickListener;
import com.lifetime.second_test.model.Info;

import java.util.ArrayList;

public class NewFeedAdapter extends RecyclerView.Adapter<NewFeedAdapter.ViewHolder>{

    public interface OnItemClickListener{
        void onAvatarClick(Info info);
    }

    ItemClickListener itemClickListener;

    ArrayList<Info> infors;

    private OnItemClickListener listener;
    Context context;


    public NewFeedAdapter(ArrayList<Info> infors,OnItemClickListener listener) {
        this.infors = infors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrow_newfeed,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(infors.get(position));
    }

    @Override
    public int getItemCount() {
        return infors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView avatar;
        TextView name;
        TextView time;
        TextView content;
        ImageView background;
        TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.item_view_avatar);
            name = itemView.findViewById(R.id.item_view_name);
            time = itemView.findViewById(R.id.item_view_time);
            content = itemView.findViewById(R.id.item_view_content);
            background = itemView.findViewById(R.id.item_view_img);
            price = itemView.findViewById(R.id.item_view_price);
        }
        public void bindView(final Info info){
            avatar.setImageResource(info.getAvatar());
            name.setText(info.getName());
            time.setText(info.getTime());
            content.setText(info.getContent());
            background.setImageResource(info.getBackground());
            price.setText(info.getPrice());
            avatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onAvatarClick(info);
                }
            });
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(), listener);
        }
    }
}
