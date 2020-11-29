package com.example.mindmattersapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.activities.ForumActivity;
import com.example.mindmattersapp.models.Topics;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder> {

    List<Topics> topicsList;

    public ForumAdapter (List<Topics> topicsList){this.topicsList = topicsList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.topicImg.setImageResource(topicsList.get(position).getIdTopicImg());
        holder.topicTitle.setText(topicsList.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return topicsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView topicImg;
        private TextView topicTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicImg = (ImageView) itemView.findViewById(R.id.topicImg);
            topicTitle = (TextView) itemView.findViewById(R.id.topicTitle);
        }
    }
}
