package com.example.mindmattersapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.activities.ForumActivity;
import com.example.mindmattersapp.activities.forum.ForumWebActivity;
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

        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return topicsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView topicCard;
        private ImageView topicImg;
        private TextView topicTitle;
        private Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            topicImg = (ImageView) itemView.findViewById(R.id.topicImg);
            topicTitle = (TextView) itemView.findViewById(R.id.topicTitle);
            topicCard = itemView.findViewById(R.id.cardViewPokemonTopic);
        }

        public void setOnClickListeners() {
            topicCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ForumWebActivity.class);
            context.startActivity(intent);
        }
    }
}
