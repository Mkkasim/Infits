package com.mk.infits.adapters.live;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
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

public class RecycUpcomingLive extends RecyclerView.Adapter<RecycUpcomingLive.ViewHolder> {

    Context context;
    private ArrayList<LiveUpcomingModel> list;
    private RecycUpcomingLive.OnItemClickListener itemClickListener;

    public RecycUpcomingLive(Context context, ArrayList<LiveUpcomingModel> list, RecycUpcomingLive.OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_upcoming_live_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LiveUpcomingModel model = list.get(position);

        holder.userName.setText(model.getUserName());
        holder.date.setText(model.getLiveDate());
        holder.time.setText(model.getLiveTime());

//        int startColor = context.getResources().getColor(R.color.gradientBlue);
//        int endColor = context.getResources().getColor(R.color.gradientViolet);
//
//        Shader shader = new LinearGradient(0,0,0,holder.setReminder.getLineHeight(),
//                Color.parseColor("#2667FF"), Color.parseColor("#D553E7"), Shader.TileMode.REPEAT);
//        holder.setReminder.getPaint().setShader(shader);

        TextPaint paint = holder.setReminder.getPaint();
        float width = paint.measureText("Set Reminder");

        Shader textShader = new LinearGradient(0, 0, width, holder.setReminder.getTextSize(),
                new int[]{
                        Color.parseColor("#2667FF"),
                        Color.parseColor("#2667FF"),
                        Color.parseColor("#2667FF"),
                        Color.parseColor("#D553E7"),
                        Color.parseColor("#D553E7"),
                }, null, Shader.TileMode.CLAMP);
        holder.setReminder.getPaint().setShader(textShader);

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

            userName = itemView.findViewById(R.id.upcoming_live_userName);
            date = itemView.findViewById(R.id.calenderText);
            time = itemView.findViewById(R.id.clockText);
            setReminder = itemView.findViewById(R.id.setReminderBtn);
            userImg = itemView.findViewById(R.id.profile_img_upcoming);

        }
    }
}
