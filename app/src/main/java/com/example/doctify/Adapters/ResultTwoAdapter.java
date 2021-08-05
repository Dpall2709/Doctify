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

import com.example.doctify.DetailActivity;
import com.example.doctify.Models.ResultTwoModel;
import com.example.doctify.R;

import java.util.ArrayList;

public class ResultTwoAdapter extends RecyclerView.Adapter<ResultTwoAdapter.viewholder>{
    ArrayList<ResultTwoModel> list;
    Context context;

    public ResultTwoAdapter(ArrayList<ResultTwoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_result,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final ResultTwoModel model = list.get(position);
        holder.description.setText(model.getDescription());
        holder.place.setText(model.getPlace());
        holder.degree.setText(model.getDegree());
        holder.date.setText(model.getDate());
        holder.name.setText(model.getName());
        holder.image.setImageResource(model.getImage());
        holder.salary.setText(model.getSalary());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("place",model.getPlace());
                intent.putExtra("degree",model.getDegree());
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getName());
                intent.putExtra("salary",model.getSalary());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView description,place,degree,salary,date,name;
        ImageView image;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            description = (TextView)itemView.findViewById(R.id.descResult);
            place = (TextView)itemView.findViewById(R.id.placeResult);
            degree = (TextView)itemView.findViewById(R.id.degreeResult);
            salary = (TextView)itemView.findViewById(R.id.salaryResult);
            date = (TextView)itemView.findViewById(R.id.dateResult);
            name = (TextView)itemView.findViewById(R.id.nameResultTitle);
            image = itemView.findViewById(R.id.imageResult);
        }
    }
}
