package com.mk.infits.adapters.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.infits.R;
import com.mk.infits.model.live.LiveUpcomingModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycLiveViewers extends RecyclerView.Adapter<RecycLiveViewers.ViewHolder> {

    Context context;
    private ArrayList<LiveUpcomingModel> list;
    private RecycLiveViewers.OnItemClickListener itemClickListener;

    public RecycLiveViewers(Context context, ArrayList<LiveUpcomingModel> list, RecycLiveViewers.OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_live_viewers_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LiveUpcomingModel model = list.get(position);

        holder.userImg.setImageResource(model.getViewersImg());

        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onItemClick(holder.getAdapterPosition());
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName,date,time,setReminder;
        CircleImageView userImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            userImg = itemView.findViewById(R.id.profileLive);

        }
    }
}
