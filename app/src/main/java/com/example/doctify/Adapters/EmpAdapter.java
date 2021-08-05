package com.example.doctify.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctify.Models.EmpModel;
import com.example.doctify.R;
import com.example.doctify.RequriementFormActivity;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.R;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.viewholder> {

    ArrayList<EmpModel> list;
    Context context;

    public EmpAdapter(ArrayList<EmpModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.doctify.R.layout.emp_sample,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final EmpModel model = list.get(position);
        holder.empMedImage.setImageResource(model.getImage());
        holder.empMedName.setText(model.getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView empMedImage;
        TextView empMedName;
        public viewholder(@NonNull View itemView) {

            super(itemView);

            empMedImage = itemView.findViewById(com.example.doctify.R.id.empMedImage);
            empMedName = (TextView)itemView.findViewById(com.example.doctify.R.id.empMedName);
        }
    }


}
