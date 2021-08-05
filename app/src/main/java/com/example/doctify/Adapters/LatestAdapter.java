package com.example.doctify.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctify.Models.LatestModel;
import com.example.doctify.R;

import java.util.ArrayList;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.viewholder1> {
    ArrayList<LatestModel> list1;
    Context context;

    public LatestAdapter(ArrayList<LatestModel> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.latest_job_sample,parent,false);

        return new viewholder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder1 holder, int position) {

        final LatestModel model = list1.get(position);
        holder.imgMed.setImageResource(model.getImage());
//        holder.nameMed.setText(model.getName());
//        holder.vacName.setText(model.getVac());

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class viewholder1 extends RecyclerView.ViewHolder {
        ImageView imgMed;
        TextView nameMed,vacName;
        public viewholder1(@NonNull View itemView) {
            super(itemView);

            imgMed = itemView.findViewById(R.id.imageView2);
//            nameMed = (TextView)itemView.findViewById(R.id.medName1);
//           vacName = (TextView)itemView.findViewById(R.id.vac);
        }
    }

}
