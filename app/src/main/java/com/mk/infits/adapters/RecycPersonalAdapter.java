package com.mk.infits.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.infits.R;
import com.mk.infits.model.PersonalDetailsModel;

import java.util.ArrayList;

public class RecycPersonalAdapter extends RecyclerView.Adapter<RecycPersonalAdapter.ViewHolder> {

    Context context;
    private ArrayList<PersonalDetailsModel> list;
    private RecycPersonalAdapter.OnItemClickListener itemClickListener;

    public RecycPersonalAdapter(Context context, ArrayList<PersonalDetailsModel> list, RecycPersonalAdapter.OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_profile_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PersonalDetailsModel model = list.get(position);

        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

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

        TextView title,desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textHead);
            desc = itemView.findViewById(R.id.textDes);

        }
    }
}
