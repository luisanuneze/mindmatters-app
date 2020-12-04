package com.example.mindmattersapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.models.PageDiarioModel;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    @NonNull
    private List<PageDiarioModel> mModelDiaryList;

    public DiaryAdapter(@NonNull List<PageDiarioModel> modelDiaryList) {
        mModelDiaryList = modelDiaryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.diary_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(inflater);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(mModelDiaryList.get(position).getTitulo());
        holder.tvDate.setText(mModelDiaryList.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return mModelDiaryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle, tvDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_cardTitle);
            tvDate = itemView.findViewById(R.id.tv_cardFecha);
        }
    }
}
