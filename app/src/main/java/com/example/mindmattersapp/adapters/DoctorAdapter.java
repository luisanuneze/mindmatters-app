package com.example.mindmattersapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.models.Doctor;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    List<Doctor> doctorsList;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public DoctorAdapter(List<Doctor> doctorsList,@NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener){
        this.doctorsList = doctorsList;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.drFoto.setImageResource(doctorsList.get(position).getFoto());
        holder.drName.setText(doctorsList.get(position).getNombre());
        holder.drEspecialidad.setText(doctorsList.get(position).getEspecialidad());
    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener{
        private ImageView drFoto;
        private TextView drName;
        private TextView drEspecialidad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            drFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            drName = (TextView) itemView.findViewById(R.id.tvNombre);
            drEspecialidad = (TextView) itemView.findViewById(R.id.tvEspecialidad);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }
}
