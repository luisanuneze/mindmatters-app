package com.example.mindmattersapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.models.WellBeingEntry;

import java.util.List;

public class WellBeingAdapter extends RecyclerView.Adapter<WellBeingAdapter.ViewHolder> {

    List<WellBeingEntry> messagesList;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;


    public WellBeingAdapter(List<WellBeingEntry> messagesList,@NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener){
                this.messagesList = messagesList;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wellbeing_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.messageImg.setImageResource(messagesList.get(position).getMsgImgId());
        holder.messageTitle.setText(messagesList.get(position).getMsgHeader());
        holder.messageText.setText(messagesList.get(position).getMsgMoreInfo());
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener{
        private ImageView messageImg;
        private TextView messageTitle;
        private TextView messageText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageImg = (ImageView) itemView.findViewById(R.id.msgImg);
            messageTitle = (TextView) itemView.findViewById(R.id.msgTitle);
            messageText = (TextView) itemView.findViewById(R.id.msgText);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }

}
