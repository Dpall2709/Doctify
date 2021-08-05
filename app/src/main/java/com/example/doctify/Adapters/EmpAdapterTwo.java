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

import com.example.doctify.Models.EmpModelTwo;
import com.example.doctify.R;
import com.example.doctify.RequriementFormActivity;

import java.util.ArrayList;

public class EmpAdapterTwo extends RecyclerView.Adapter<EmpAdapterTwo.viewholder> {
    ArrayList<EmpModelTwo> list;
    Context context;

    public EmpAdapterTwo(ArrayList<EmpModelTwo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.cateogries_sample,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final EmpModelTwo model = list.get(position);
        holder.image.setImageResource(model.getImage());
//        holder.drName.setText(model.getDrName());
        holder.drSpec.setText(model.getDrSpec());
        holder.place.setText(model.getPlace());
        holder.time.setText(model.getTime());
        holder.year.setText(model.getYear());
//        holder.rating.setText(model.getRating());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RequriementFormActivity.class);
                intent.putExtra("drSpec",model.getDrSpec());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView image;
       TextView drName,drSpec,place,time,year,rating;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imgEmpSecond);
//            drName = (TextView)itemView.findViewById(R.id.nameDr);
            drSpec = (TextView)itemView.findViewById(R.id.nameSpec);
            place = (TextView)itemView.findViewById(R.id.addressDr);
            time = (TextView)itemView.findViewById(R.id.workDay);
            year = (TextView)itemView.findViewById(R.id.expre);
//            rating = (TextView)itemView.findViewById(R.id.rating);
        }
    }
}
